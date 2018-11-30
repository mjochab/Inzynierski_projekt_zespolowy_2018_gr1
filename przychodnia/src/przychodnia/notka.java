/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package przychodnia;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;

/**
 *
 * @author Krystian Tracz
 */
public class notka extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("");

        TextArea textArea = new TextArea();
       textArea.setMinSize(600, 600);
        MenuBar menuBar = new MenuBar();
        Menu menu1 = new Menu("Menu 1");
        menuBar.getMenus().add(menu1);
       menu1.setGraphic(new ImageView(""));
        VBox vbox = new VBox(menuBar);

        Scene scene = new Scene(vbox, 500, 600);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
}
