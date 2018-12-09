package przychodnia;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javafx.application.Application;
import javafx.event.*;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.event.*;
import javafx.scene.Parent;
import javafx.scene.control.Alert.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Font;

/**
 *
 * @author Bartek
 */
public class Alerty extends Application {

    Stage window;
    Scene scene;
    Button button;
    ComboBox<String> comboBox;

    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws FileNotFoundException {
        window = primaryStage;
        window.setTitle("Alert");
       
        //blad
        Label napis = new Label("Błąd");
        napis.setFont(Font.font (20));
        GridPane.setConstraints(napis, 0, 1);
        
        Label blad = new Label("Nieprawidłowy login lub hasło.\n Popraw błędy i sprubuj ponownie");
        GridPane.setConstraints(blad, 0, 2);
        
        /*FileInputStream input = new FileInputStream("img\blad.png");
        Image image = new Image(input);
        ImageView imageView = new ImageView(image);*/
        
        //button
        Button button = new Button("Ok"); 
        GridPane.setConstraints(button, 1, 3);

        //GridPane with 10px padding around edge
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 20));
        grid.setVgap(8);
        grid.setHgap(10);
                
        grid.getChildren().addAll(napis, blad, button);
        
        scene = new Scene(grid, 350, 180);
        window.setScene(scene);
        window.show();
    }
    private void printMovie(){
        System.out.println(comboBox.getValue());
    }
    
}