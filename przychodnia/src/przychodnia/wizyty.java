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
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.cell.ComboBoxListCell;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author Krystian Tracz
 */
public class wizyty extends Application {

    public static final ObservableList names = FXCollections.observableArrayList();
    public static final ObservableList data = FXCollections.observableArrayList();

    @Override
    public void start(Stage primaryStage) {
        
       ListView listView = new ListView();
        listView.getItems().add("Item 1");
        listView.getItems().add("Item 2");
        listView.getItems().add("Item 3");       

        
      
        
        Button btn = new Button("Dodaj historie pacjenta");
          btn.setOnAction(event -> {
historia his =new historia();
his.start(primaryStage);
           
              });
        
 HBox hbox = new HBox(listView,btn);
     Scene scene = new Scene(hbox, 300, 120);
        primaryStage.setScene(scene);
        primaryStage.show();

    /**
     * @param args the command line arguments
     */
}
}
