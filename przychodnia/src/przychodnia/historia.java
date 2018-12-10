package przychodnia;

import java.sql.Connection;
import java.sql.ResultSet;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.*;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.util.Callback;

/**
 * 
 * @author Narayan
 */

public class historia extends Application{
    //Ttabela i dane
    private ObservableList<ObservableList> data;
    private TableView tableview;
            Button addButon;
            Stage window;
            TextField notkatext; 
    //MAIN EXECUTOR
    public static void main(String[] args) {
        launch(args);
    }

    //CONNECTION DATABASE
    public ObservableList<ObservableList> buildData(){
          Connection c ;
          data = FXCollections.observableArrayList();
          try{
            c = connect_baza.getConnection();
            //SQL FOR SELECTING 
            String SQL = "SELECT * from pacjenci";
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
                //Iterate Row
                ObservableList<String> row = FXCollections.observableArrayList();
                for(int i=1 ; i<=rs.getMetaData().getColumnCount(); i++){
                    //Iterate Column
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
        return null;
      }


      @Override
      public  void start(Stage primaryStage)
{  
        window = primaryStage;
        window.setTitle("historia ");

       // TableView
      tableview = new TableView();
    //  tableview.setMaxSize(700, 570);
        tableview.setOnMouseClicked(e -> NotkaButtonClicked());
buildData();
            //haslo input
       notkatext = new TextField("");
        notkatext.setPromptText("notka tekst");
        
       
        HBox hBox = new HBox();
        hBox.setPadding(new Insets(20, 20, 20, 20));
        hBox.setSpacing(10);
         hBox.getChildren().addAll(notkatext ,tableview);
       
        
        //Main Scene
        VBox vBox = new VBox();
        vBox.setStyle("-fx-background-color: #CCFFFF ");
        vBox.getChildren().addAll(hBox); 
      Scene scene = new Scene(vBox);        

        window.setScene(scene);
        window.show(); 
        
      }
        private void NotkaButtonClicked() {
notka noteczka = new notka();
noteczka.start(window);
    }
}