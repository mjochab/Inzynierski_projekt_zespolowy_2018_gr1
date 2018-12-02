package przychodnia;

import java.sql.Connection;
import java.sql.ResultSet;
import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Callback;

/**
 * 
 * @author Narayan
 */

public class addworkpearson extends Application{
    //Ttabela i dane
    private ObservableList<ObservableList> data;
    private TableView tableview;
    TextField hasloInput, IDInput,nameInput, sernameInput,  functionInput,e_mailInput;
    Stage window;
    //MAIN EXECUTOR
    public static void main(String[] args) {
        launch(args);
    }
    //CONNECTION DATABASE
    public void buildData(){
          Connection c ;
          data = FXCollections.observableArrayList();
          try{
            c = connect_baza.getConnection();
            //SQL FOR SELECTING ALL OF CUSTOMER
            String SQL = "SELECT * from lekarze";
            //ResultSet
            ResultSet rs = c.createStatement().executeQuery(SQL);

          
            for(int i=0 ; i<rs.getMetaData().getColumnCount(); i++){
                //We are using non property style for making dynamic table
                final int j = i;                
                TableColumn col = new TableColumn(rs.getMetaData().getColumnName(i+1));
                col.setCellValueFactory(new Callback<CellDataFeatures<ObservableList,String>,ObservableValue<String>>(){                    
                    public ObservableValue<String> call(CellDataFeatures<ObservableList, String> param) {                                                                                              
                        return new SimpleStringProperty(param.getValue().get(j).toString());                        
                    }                    
                });

                tableview.getColumns().addAll(col); 

                
                System.out.println("Column ["+i+"] ");
            }

            
            while(rs.next()){
                //iteracja Row
                ObservableList<String> row = FXCollections.observableArrayList();
                for(int i=1 ; i<=rs.getMetaData().getColumnCount(); i++){
                    //iteracja Column
                    row.add(rs.getString(i));
                }
                System.out.println("Row [1] added "+row );
                data.add(row);
                
                
                

            }

            //FINALLY ADDED TO TableView
            tableview.setItems(data);

          }catch(Exception e){
              e.printStackTrace();
              System.out.println("Error on Building Data");             
          }
      }


      @Override
      public  void start(Stage primaryStage){
              window = primaryStage;
              window.setTitle("dodawanie lekarzy");
        //TableView
        tableview = new TableView();
        tableview.setMaxSize(500, 470);
        tableview.setOnMouseClicked(e -> NotkaButtonClicked());
        buildData();

        //Main Scene

         //Imie input
        IDInput = new TextField();
        IDInput.setPromptText("ID");

        nameInput = new TextField();
        nameInput.setPromptText("Imie");
        nameInput.setMinWidth(100);

        //nazwisko input
        sernameInput = new TextField();
        sernameInput.setPromptText("Nazwisko");

        //funkcja input
        functionInput = new TextField();
        functionInput.setPromptText("Funkcja");

        //e_mail input
        e_mailInput = new TextField();
        e_mailInput.setPromptText("E_mail");

        //haslo input
        hasloInput = new TextField();
        hasloInput.setPromptText("Hasło");

        //Button
        Button addButton = new Button("Dodaj");
       // addButton.setOnAction(e -> addButtonClicked());

        Button deleteButton = new Button("Usuń");
       // deleteButton.setOnAction(e -> deleteButtonClicked());;
        HBox hBox = new HBox();
        hBox.setPadding(new Insets(20, 20, 20, 20));
        hBox.setSpacing(10);
         hBox.getChildren().addAll(hasloInput,IDInput, nameInput, sernameInput, functionInput, e_mailInput, addButton, deleteButton);
       
        
        //Main Scene
        VBox vBox = new VBox();
        vBox.getChildren().addAll(tableview,hBox); 
        
        
                Scene scene = new Scene(vBox);        

        
        
        
        
        
        window.setScene(scene);
        window.show();
        
        
        
      }

    private void NotkaButtonClicked() {
notka noteczka = new notka();
noteczka.start(window);
    }
      
      
}