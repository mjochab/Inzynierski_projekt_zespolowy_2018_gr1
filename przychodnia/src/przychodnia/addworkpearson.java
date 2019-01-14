package przychodnia;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Callback;
import javax.swing.JOptionPane;
import static javax.xml.bind.DatatypeConverter.parseString;

/**
 *
 * @author Narayan
 */
public class addworkpearson extends Application {

    //Ttabela i dane
    TextField hasloInput, IDInput, nameInput, sernameInput, functionInput, e_mailInput, loginInput;
    Stage window;
    Connection conn;
    PreparedStatement pst = null;
    ResultSet rs = null;
    final ObservableList<Lekarze> data = FXCollections.observableArrayList();
    TableView<Lekarze> tableview = new TableView<>();

    public void addData() {
        try {
            String query = "select * from lekarze";
            pst = connect_baza.getConnection().prepareStatement(query);
            rs = pst.executeQuery();

            while (rs.next()) {
                data.add(new Lekarze(
                        rs.getInt("id_lekarza"), rs.getString("imie"), rs.getString("nazwisko"), rs.getString("specjalnosc"), rs.getString("email"), rs.getString("login"), rs.getString("haslo")));

            }
            tableview.setItems(data);
            pst.close();
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(Logowaniepacjentow.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //MAIN EXECUTOR
    //CONNECTION DATABASE
    @Override
    public void start(Stage primaryStage) {
        window = primaryStage;
        window.setTitle("dodawanie lekarzy");
        //TableView
        tableview = new TableView();
        // tableview.setMaxSize(500, 470);
        TableColumn<Lekarze, Integer> IDColumn = new TableColumn<>("ID");
        IDColumn.setMinWidth(50);
        IDColumn.setCellValueFactory(new PropertyValueFactory<>("id_lekarza"));
//Imie column
        TableColumn<Lekarze, String> nameColumn = new TableColumn<>("Imie");
        nameColumn.setMinWidth(200);
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));

        //nazwisko column
        TableColumn<Lekarze, String> sernameColumn = new TableColumn<>("Nazwisko");
        sernameColumn.setMinWidth(200);
        sernameColumn.setCellValueFactory(new PropertyValueFactory<>("surname"));

        //function column
        TableColumn<Lekarze, String> funkcjaColumn = new TableColumn<>("funkcja");
        funkcjaColumn.setMinWidth(200);
        funkcjaColumn.setCellValueFactory(new PropertyValueFactory<>("function"));

        //e_mail column
        TableColumn<Lekarze, String> e_mailColumn = new TableColumn<>("e_mail");
        e_mailColumn.setMinWidth(200);
        e_mailColumn.setCellValueFactory(new PropertyValueFactory<>("e_mail"));

        //login column
        TableColumn<Lekarze, String> loginColumn = new TableColumn<>("login");
        loginColumn.setMinWidth(200);
        loginColumn.setCellValueFactory(new PropertyValueFactory<>("login"));

        //funkcja column
        TableColumn<Lekarze, String> hasloColumn = new TableColumn<>("haslo");
        hasloColumn.setMinWidth(200);
        hasloColumn.setCellValueFactory(new PropertyValueFactory<>("haslo"));

        tableview.getColumns().addAll(IDColumn, nameColumn, sernameColumn, funkcjaColumn, e_mailColumn, loginColumn, hasloColumn);
        addData();
        //Main Scene
        //Imie input
        IDInput = new TextField();
        IDInput.setPromptText("ID");

        nameInput = new TextField();
        nameInput.setPromptText("Imie");
        nameInput.setMinWidth(100);

        //nazwisko input
        sernameInput = new TextField();
        sernameInput.setPromptText("Nazwisko");

        //funkcja input
        functionInput = new TextField();
        functionInput.setPromptText("Specjalnosc");

        //e_mail input
        e_mailInput = new TextField();
        e_mailInput.setPromptText("E_mail");

        //haslo input
        hasloInput = new TextField();
        hasloInput.setPromptText("Hasło");

        //login input
        loginInput = new TextField();
        loginInput.setPromptText("Login");
        //Button
        Button addButton = new Button("Dodaj");
        addButton.setOnAction(e -> addButtonClicked());

        Button deleteButton = new Button("Usuń");
        deleteButton.setOnAction(e -> deleteButtonClicked());

        Button pdfButton = new Button("PDF");
        pdfButton.setOnAction(e -> {
            try {
                pdfButtonClicked();
            } catch (FileNotFoundException ex) {
                Logger.getLogger(addworkpearson.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

        Button backButton = new Button("Wstecz");
        backButton.setOnAction(e -> {
            addpeople addp = new addpeople();
            addp.start(primaryStage);

        });

        HBox hBox = new HBox();
        hBox.setPadding(new Insets(20, 20, 20, 20));
        hBox.setSpacing(10);
        hBox.getChildren().addAll(IDInput, nameInput, sernameInput, functionInput, e_mailInput, loginInput, hasloInput, addButton, deleteButton, pdfButton, backButton);

        //Main Scene
        VBox vBox = new VBox();
        vBox.setStyle("-fx-background-image:url('img/tapeta.jpg')");
        vBox.getChildren().addAll(tableview, hBox);
        Scene scene = new Scene(vBox);
        window.setScene(scene);
        window.show();

    }

    private void NotkaButtonClicked() {
        notka noteczka = new notka();
        noteczka.start(window);
    }

    private void addButtonClicked() {

        try {

            String query = "INSERT INTO lekarze(imie, nazwisko, specjalnosc, email, login, haslo) VALUES (?,?,?,?,?,?)";
            pst = connect_baza.getConnection().prepareStatement(query);
            pst.setString(1,IDInput.getText());
            pst.setString(1, nameInput.getText());
            pst.setString(2, sernameInput.getText());
            pst.setString(3, functionInput.getText());
            pst.setString(4, e_mailInput.getText());
            pst.setString(5, loginInput.getText());
            pst.setString(6, hasloInput.getText());

            pst.executeUpdate();
            addworkpearson addwp = new addworkpearson();
            addwp.start(window);
            //tableview.setItems(data);

        } catch (SQLException ex) {
            Logger.getLogger(Logowaniepacjentow.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void deleteButtonClicked() {
        try {

            String query = "DELETE FROM lekarze WHERE id_lekarza= ?";
            pst = connect_baza.getConnection().prepareStatement(query);
            pst.setString(1, IDInput.getText());

            pst.executeUpdate();

            addworkpearson addwp = new addworkpearson();
            addwp.start(window);
        } catch (SQLException ex) {
            Logger.getLogger(Logowaniepacjentow.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void pdfButtonClicked() throws FileNotFoundException {
        pdf p = new pdf();
        p.getpdflekarz();

    }

}
