package przychodnia;

import java.sql.Connection;
import java.sql.ResultSet;
import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.*;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.event.*;
import javafx.scene.Parent;
import javafx.scene.control.Alert.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.util.Callback;

/**
 *
 * @author Bartek
 */
public class Logowanie extends Application {

    Stage window;
    Scene scene;
    Button button;
    ComboBox<String> comboBox;
    TableView tableview;
    ObservableList<ObservableList> data;

     public void buildData() {
        Connection c;
        data = FXCollections.observableArrayList();
        try {
            c = connect_baza.getConnection();
            //SQL FOR SELECTING ALL OF CUSTOMER
            String SQL = "SELECT PESEL from pacjenci";
            //ResultSet
            ResultSet rs = c.createStatement().executeQuery(SQL);

            for (int i = 0; i < rs.getMetaData().getColumnCount(); i++) {
                //We are using non property style for making dynamic table
                final int j = i;
                TableColumn col = new TableColumn(rs.getMetaData().getColumnName(i + 1));
                col.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<ObservableList, String>, ObservableValue<String>>() {
                    public ObservableValue<String> call(TableColumn.CellDataFeatures<ObservableList, String> param) {
                        return new SimpleStringProperty(param.getValue().get(j).toString());
                    }
                });

                tableview.getColumns().addAll(col);

                System.out.println("Column [" + i + "] ");
            }

            while (rs.next()) {
                //iteracja Row
                ObservableList<String> row = FXCollections.observableArrayList();
                for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
                    //iteracja Column
                    row.add(rs.getString(i));
                }
                System.out.println("Row [1] added " + row);
                data.add(row);
            }

            //FINALLY ADDED TO TableView
            tableview.setItems(data);

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error on Building Data");
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) {
        window = primaryStage;
        window.setTitle("Logowanie");
       
        //napis 
        Label napis = new Label("➕ Przychodnia 🚑");
        napis.setFont(Font.font (20));
        GridPane.setConstraints(napis, 1, 0);
        
        //nrP Label 
        Label nrPLabel = new Label("PESEL:");
        GridPane.setConstraints(nrPLabel, 0, 1);
        

        //nrP Input
        TextField nrPInput = new TextField();
            

        GridPane.setConstraints(nrPInput, 1, 1);

        //Password Label
        Label passLabel = new Label("Hasło:");
    


        GridPane.setConstraints(passLabel, 0, 2);

        //Password Input
    final PasswordField passInput = new PasswordField();
  final Label message = new Label("");
          GridPane.setConstraints(message, 1, 3);


   // passInput.setOnAction(new EventHandler<ActionEvent>() {
    
        //passInput.setPromptText("Hasło");
        GridPane.setConstraints(passInput, 1, 2);

        //button
        Button button = new Button("Zaloguj się");
        button.setOnAction(new EventHandler<ActionEvent>(){
        @Override 
        public void handle(ActionEvent e) {
         if (!nrPLabel.getText().equals(data)) {
        //  message.setText("Twoje hało lub PESEL jest niepoprawne ");
          //message.setTextFill(Color.web("red")); 
          Alerty alt = new Alerty();
          alt.start(window);
        } else {
          
        }
        passInput.setText("");
    }
        });

        
        
       
        GridPane.setConstraints(button, 1, 4);

        Label logLabel = new Label("Nie masz konta?");
        Hyperlink hyperlink = new Hyperlink("Zarejestruj się!");
        hyperlink.setOnAction(new EventHandler<ActionEvent>(){
          @Override
         public void handle(ActionEvent e) { 
            Rejestracja rej = new Rejestracja();
            rej.start(window);           
        }                
        });
        /*
        if(nrPInput.getText().equals("86042917564") && passInput.getText().equals("qwerty")){
            
                Stage stage = new Stage(); 
        
                Alerty alert = new Alerty();
                alert.start(primaryStage);
                
        }
            else {
                Label blad = new Label();
                blad.setText("Nieprawidłowe hasło lub PESEL!");
            }
            */   
        GridPane.setConstraints(logLabel, 0, 5);
        GridPane.setConstraints(hyperlink, 1, 5);

        //GridPane with 10px padding around edge
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 20));
        grid.setVgap(8);
        grid.setHgap(10);
                
        grid.getChildren().addAll(napis, nrPLabel, nrPInput, passLabel, passInput, button, logLabel, hyperlink,message);
        
        scene = new Scene(grid, 350, 220);
        window.setScene(scene);
        window.show();
    }
    private void printMovie(){
        System.out.println(comboBox.getValue());
    }

    
        }
    


