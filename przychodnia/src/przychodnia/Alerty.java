package przychodnia;


import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
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
   
    @Override
    public void start(Stage primaryStage){
            window = primaryStage;
        window.setTitle("Alert logowania");
       
        //blad
        Label napis = new Label("Błąd 🛠");
        napis.setFont(Font.font (20));
        GridPane.setConstraints(napis, 1, 1);
        
        Label blad = new Label("Nieprawidłowy dane logowania.\nPopraw błędy i spróbuj ponownie. 🔄");
        GridPane.setConstraints(blad, 1, 2);
          //  InputStream znak = new BufferedInputStream(new FileInputStream("file://img//blad.png"));
        //InputStream znak = Alert.class.getResourceAsStream("img/blad.png");
       // Image image = new Image(znak);
       // ImageView imageView = new ImageView(image);
       // Label label = new Label("Błąd", imageView);
       // GridPane.setConstraints(label, 1, 0);
        
        //button
        Button button = new Button("     Ok     "); 
        button.setOnAction(new EventHandler<ActionEvent>(){
        @Override 
        public void handle(ActionEvent e) {
        Logowaniepacjentow log = new Logowaniepacjentow();
        log.start(window);
    }
        });
        GridPane.setConstraints(button, 1, 3);

        //GridPane with 10px padding around edge
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 20));
        grid.setVgap(8);
        grid.setHgap(10);
                
        grid.getChildren().addAll(/*label, */napis, blad, button);
        
        scene = new Scene(grid, 350, 180);
        window.setScene(scene);
        window.show();
    }
    private void printMovie(){
        System.out.println(comboBox.getValue());
    }
    
}