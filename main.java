import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.stage.Stage;

public class Main extends Application {

    Stage window;
    Scene scene;
    Button button;
    ComboBox<String> comboBox;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        window.setTitle("Rejestracja");

        //Imie Label - constrains use (child, column, row)
        Label nameLabel = new Label("Imię:");
        GridPane.setConstraints(nameLabel, 0, 1);

        //Imie Input
        TextField nameInput = new TextField();
        GridPane.setConstraints(nameInput, 1, 1);
        
        //Nazwisko Label - constrains use (child, column, row)
        Label nazwiskoLabel = new Label("Nazwisko:");
        GridPane.setConstraints(nazwiskoLabel, 0, 2);
        
        //Nazwisko Input
        TextField nazwiskoInput = new TextField();
        GridPane.setConstraints(nazwiskoInput, 1, 2);
        
        //nrP Label - constrains use (child, column, row)
        Label nrPLabel = new Label("PESEL:");
        GridPane.setConstraints(nrPLabel, 0, 3);

        //adres Input
        TextField nrPInput = new TextField();
        GridPane.setConstraints(nrPInput, 1, 3);

        //adres Label - constrains use (child, column, row)
        Label adresLabel = new Label("Adres:");
        GridPane.setConstraints(adresLabel, 0, 5);

        //adres Input
        TextField adresInput = new TextField();
        GridPane.setConstraints(adresInput, 1, 5);
        
        //Tel Label - constrains use (child, column, row)
        Label telLabel = new Label("Telefon:");
        GridPane.setConstraints(telLabel, 0, 6);

        //tel Input
        TextField telInput = new TextField();
        GridPane.setConstraints(telInput, 1, 6);
        
        //Mail Label - constrains use (child, column, row)
        Label mailLabel = new Label("E-Mail:");
        GridPane.setConstraints(mailLabel, 0, 7);

        //Mail Input
        TextField mailInput = new TextField();
        GridPane.setConstraints(mailInput, 1, 7);

        //Password Label
        Label passLabel = new Label("Hasło:");
        GridPane.setConstraints(passLabel, 0, 8);

        //Password Input
        PasswordField passInput = new PasswordField ();
        //passInput.setPromptText("Hasło");
        GridPane.setConstraints(passInput, 1, 8);
        
        //Password1 Label
        Label passwordLabel = new Label("Powtórz hasło:");
        GridPane.setConstraints(passwordLabel, 0, 9);

        //Password1 Input
        PasswordField passwordInput = new PasswordField ();
        //passwordInput.setPromptText("Powtórz hasło");
        GridPane.setConstraints(passwordInput, 1, 9);

        //button
        Button button = new Button("Załóż konto");
        GridPane.setConstraints(button, 1, 10);

        //Plec Label - constrains use (child, column, row)
        Label plecLabel = new Label("Płeć:");
        GridPane.setConstraints(plecLabel, 0, 4);
        comboBox = new ComboBox<>();
        comboBox.getItems().addAll(
                "Kobieta",
                "Mężczyzna"
        );

        comboBox.setPromptText("");
        button.setOnAction(e -> printMovie());

        //ComboBoxes also generate actions if you need to get value instantly
        comboBox.setOnAction( e -> System.out.println("Użytkownik wybrał " + comboBox.getValue()) );
        GridPane.setConstraints(comboBox, 1, 4);

        Label logLabel = new Label("Masz już konto?");
        Hyperlink hyperlink = new Hyperlink("Zaloguj się!");
        GridPane.setConstraints(logLabel, 0, 11);
        GridPane.setConstraints(hyperlink, 1, 11);

        //GridPane with 10px padding around edge
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 25));
        grid.setVgap(8);
        grid.setHgap(10);
        
        grid.getChildren().addAll(nameLabel, nameInput, nazwiskoLabel, nazwiskoInput, nrPLabel, nrPInput, plecLabel, 
                comboBox, telLabel, telInput, adresLabel, adresInput, mailLabel, mailInput, passLabel, passInput, passwordLabel, passwordInput, 
                button, logLabel, hyperlink);
                
        scene = new Scene(grid, 300, 400);
        window.setScene(scene);
        window.show();
    }

    private void printMovie(){
        System.out.println(comboBox.getValue());
    }

}