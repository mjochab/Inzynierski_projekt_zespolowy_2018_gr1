package przychodnia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
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
import static javax.xml.bind.DatatypeConverter.parseString;

/**
 *
 * @author Bartek
 */
public class Logowanieadmina extends Application {

    Stage window;
    Scene scene;
    Button button;
    ComboBox<String> comboBox;
    TableView tableview;
    ObservableList<ObservableList> data;
    String checkPESEL, checkPw;
    Connection conn;
    PreparedStatement pst = null;
    ResultSet rs = null;

    @Override
    public void start(Stage primaryStage) {
        window = primaryStage;
        window.setTitle("Logowanie");

        //napis 
        Label napis = new Label("➕ Przychodnia 🚑");
        napis.setFont(Font.font(20));
        GridPane.setConstraints(napis, 1, 0);

        //nrP Label 
        Label nrPLabel = new Label("ID_admin:");
        GridPane.setConstraints(nrPLabel, 0, 1);

        //nrP Input
        final TextField nrPInput = new TextField();

        GridPane.setConstraints(nrPInput, 1, 1);

        //Password Label
        Label passLabel = new Label("Hasło:");

        GridPane.setConstraints(passLabel, 0, 2);

        //Password Input
        final PasswordField passInput = new PasswordField();
        // final Label message = new Label("");
        // GridPane.setConstraints(message, 1, 3);

        // passInput.setOnAction(new EventHandler<ActionEvent>() {
        //passInput.setPromptText("Hasło");
        GridPane.setConstraints(passInput, 1, 2);

        //button
        Button button = new Button("Zaloguj się");
        button.setOnAction(e -> {

            try {
                pst = connect_baza.getConnection().prepareStatement("select* from admin where login=? and haslo=?");

                pst.setString(1, parseString(nrPInput.getText()));
                pst.setString(2, parseString(passInput.getText()));
                rs = pst.executeQuery();
                if (rs.next()) {
                    addpeople addp = new addpeople();
                    addp.start(primaryStage);
                } else {
                    Alerty alt = new Alerty();
                    alt.start(window);
                }
                pst.close();
                rs.close();

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
