package przychodnia;

import static java.lang.Integer.parseInt;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;

import javafx.event.*;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.text.Font;
import static javax.xml.bind.DatatypeConverter.parseString;

/**
 *
 * @author Bartek
 */
public class Logowaniepacjentow extends Application {

    Connection conn;
    PreparedStatement pst = null;
    ResultSet rs = null;
    Stage window;
    Scene scene;
    Button button;
    ComboBox<String> comboBox;
    // TableView tableview;
    // ObservableList<Pacjenci> data;
    String checkPESEL, checkPw;

    @Override
    public void start(Stage primaryStage) {
        window = primaryStage;
        window.setTitle("Logowanie");

        //napis 
        Label napis = new Label("➕ Przychodnia 🚑");
        napis.setFont(Font.font(20));
        GridPane.setConstraints(napis, 1, 0);

        //nrP Label 
        Label nrPLabel = new Label("PESEL:");
        GridPane.setConstraints(nrPLabel, 0, 1);

        //nrP Input
        TextField nrPInput = new TextField();
        nrPInput.setPromptText("PESEL");
        GridPane.setConstraints(nrPInput, 1, 1);

        //Password Label
        Label passLabel = new Label("Hasło:");

        GridPane.setConstraints(passLabel, 0, 2);

        //Password Input
        PasswordField passInput = new PasswordField();
        passInput.setPromptText("hasło");
        // final Label message = new Label("");
        // GridPane.setConstraints(message, 1, 3);

        // passInput.setOnAction(new EventHandler<ActionEvent>() {
        //passInput.setPromptText("Hasło");
        GridPane.setConstraints(passInput, 1, 2);

        //button
        Button button = new Button("Zaloguj się");
        button.setOnAction(e -> {

            try {
                pst = connect_baza.getConnection().prepareStatement("SELECT * FROM pacjenci WHERE PESEL=? and haslo=?");
                pst.setString(1, parseString(nrPInput.getText()));
                pst.setString(2, passInput.getText());

                rs = pst.executeQuery();
                if (rs.next()) {
                    wizyty wiz = new wizyty();
                    wiz.start(primaryStage);
                } else {
                    Alerty alt = new Alerty();
                    alt.start(window);
                }
                pst.close();
                rs.close();
                // System.out.println("blad");

            } catch (SQLException ex) {
                Logger.getLogger(Logowaniepacjentow.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

        GridPane.setConstraints(button, 1, 4);

        Label logLabel = new Label("Nie masz konta?");
        Hyperlink hyperlink = new Hyperlink("Zarejestruj się!");
        hyperlink.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                Rejestracja rej = new Rejestracja();
                rej.start(window);
            }
        });
        GridPane.setConstraints(logLabel, 0, 5);
        GridPane.setConstraints(hyperlink, 1, 5);
        Button back = new Button("  Wróć  ");
        back.setOnAction(e -> {
            Wyborlogowania wyo = new Wyborlogowania();
            wyo.start(primaryStage);

        });
        GridPane.setConstraints(back, 1, 6);

        //GridPane with 10px padding around edge
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 20));
        grid.setVgap(8);
        grid.setHgap(10);

        grid.getChildren().addAll(napis, nrPLabel, nrPInput, passLabel, passInput, button, logLabel, hyperlink, back);
        scene = new Scene(grid, 350, 220);
        window.setScene(scene);
        window.show();
    }

    private void printMovie() {
        System.out.println(comboBox.getValue());
    }

}
