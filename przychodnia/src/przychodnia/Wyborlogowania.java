package przychodnia;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.collections.ObservableList;
import javafx.event.*;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.text.Font;
import przychodnia.Alerty;
import przychodnia.Rejestracja;

/**
 *
 * @author Bartek
 */
public class Wyborlogowania extends Application {

    Stage window;
    Scene scene;
    Button button;
    ComboBox<String> comboBox;
    TableView tableview;
    ObservableList<ObservableList> data;
    String checkPESEL, checkPw;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        window = primaryStage;
        window.setTitle("Logowanie");

        MenuItem menuItem1 = new MenuItem("Lekarz");
        menuItem1.setOnAction(e -> LekarzSelect());

        MenuItem menuItem2 = new MenuItem("Pacjent");
        menuItem2.setOnAction(e -> PacjentSelect());

        MenuItem menuItem3 = new MenuItem("Administartor");
        menuItem3.setOnAction(e -> AdminSelect());

        MenuButton menuButton = new MenuButton("             Zaloguj się jako            ", null, menuItem1, menuItem2, menuItem3);
        GridPane.setConstraints(menuButton, 1, 3);

        //napis 
        Label napis = new Label("➕ Przychodnia 🚑");
        napis.setFont(Font.font(25));
        GridPane.setConstraints(napis, 1, 1);
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(8);
        grid.setHgap(10);

        Label logLabel = new Label("Nie masz konta?");
        Hyperlink hyperlink = new Hyperlink("                                    Zarejestruj się!");
        hyperlink.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                Rejestracja rej = new Rejestracja();
                rej.start(window);
            }
        });

        GridPane.setConstraints(logLabel, 1, 4);
        GridPane.setConstraints(hyperlink, 1, 4);

        grid.getChildren().addAll(menuButton, napis, logLabel, hyperlink);
        scene = new Scene(grid, 250, 150);
        window.setScene(scene);
        window.show();
    }

    private void printMovie() {
        System.out.println(comboBox.getValue());
    }

    private void AdminSelect() {
        Logowanieadmina logad = new Logowanieadmina();
        logad.start(window);
    }

    private void PacjentSelect() {
        Logowaniepacjentow logpac = new Logowaniepacjentow();
        logpac.start(window);
    }

    private void LekarzSelect() {
        Logowanielekarza loglek = new Logowanielekarza();
        loglek.start(window);
    }

}
