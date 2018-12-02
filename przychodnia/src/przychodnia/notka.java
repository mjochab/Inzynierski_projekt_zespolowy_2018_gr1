/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package przychodnia;

import javafx.application.Application;
import javafx.collections.*;
import javafx.event.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
 import javafx.scene.image.Image;

import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;

/**
 *
 * @author Krystian Tracz
 */
public class notka extends Application {
    TableView<Pacjenci> table;
    Stage window;
    
    @Override
    public void start(Stage primaryStage) {
         window = primaryStage;
         primaryStage.setTitle("notka");
       

        TextArea textArea = new TextArea();
       textArea.setMinSize(300, 600);
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
      
        table = new TableView<>();
        table.setItems(getPacjenci());
        table.getColumns().addAll(nameColumn, surnameColumn, PESELColumn);
          VBox vbox = new VBox();
          vbox.getChildren().addAll(table,textArea);

        Scene scene = new Scene(vbox, 500, 600);

        window.setScene(scene);
        window.show();
    }
    public ObservableList<Pacjenci> getPacjenci(){
        ObservableList<Pacjenci> pacjenci = FXCollections.observableArrayList();
        pacjenci.add(new Pacjenci("Adam","John",1254784512));
       
        return pacjenci;

    /**
     * @param args the command line arguments
     */
}
}
