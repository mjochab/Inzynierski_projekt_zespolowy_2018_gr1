/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package przychodnia;

import java.sql.Connection;
import java.sql.ResultSet;
import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.*;
import javafx.event.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
 import javafx.scene.image.Image;

import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.util.Callback;

/**
 *
 * @author Krystian Tracz
 */
public class notka extends Application {
        ObservableList<ObservableList> data;
          TableView tableview;
         Stage window;
    
    
    public void buildData(){
          Connection c ;
          data = FXCollections.observableArrayList();
          try{
            c = connect_baza.getConnection();
            //SQL FOR SELECTING ALL OF CUSTOMER
            String SQL = "SELECT imie, nazwisko, PESEL FROM pacjenci ";
            //ResultSet
            ResultSet rs = c.createStatement().executeQuery(SQL);

          
            for(int i=0 ; i<rs.getMetaData().getColumnCount(); i++){
                //We are using non property style for making dynamic table
                final int j = i;                
                TableColumn col = new TableColumn(rs.getMetaData().getColumnName(i+1));
                col.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<ObservableList,String>,ObservableValue<String>>(){                    
                    public ObservableValue<String> call(TableColumn.CellDataFeatures<ObservableList, String> param) {                                                                                              
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
    public void start(Stage primaryStage) {
         window = primaryStage;
         primaryStage.setTitle("notka");
       

        TextArea textArea = new TextArea();
      textArea.setMinSize(300, 550);
    //Name column
        TableColumn<Pacjenci, String> nameColumn = new TableColumn<>("Imie");
        nameColumn.setMinWidth(200);
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));

        //Price column
        TableColumn<Pacjenci, String> surnameColumn = new TableColumn<>("Nazwisko");
        surnameColumn.setMinWidth(100);
        surnameColumn.setCellValueFactory(new PropertyValueFactory<>("surname"));

        //Quantity column
        TableColumn<Pacjenci,Integer > PESELColumn = new TableColumn<>("PESEL");
        PESELColumn.setMinWidth(100);
        PESELColumn.setCellValueFactory(new PropertyValueFactory<>("PESEL"));
      
        tableview = new TableView();
       buildData();
          VBox vbox = new VBox();
          vbox.getChildren().addAll(tableview,textArea);

        Scene scene = new Scene(vbox, 500, 600);

        window.setScene(scene);
        window.show();
    }
   
   
}

