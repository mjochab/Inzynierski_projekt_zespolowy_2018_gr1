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
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
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
    private ObservableList<ObservableList> data;
    private TableView tableview;
    TextField hasloInput, IDInput, nameInput, sernameInput, functionInput, e_mailInput,loginInput;
    Stage window;
    Connection conn;
    PreparedStatement pst = null;
    ResultSet rs = null;

    //MAIN EXECUTOR
    //CONNECTION DATABASE
    public void buildData() {
        Connection c;
        data = FXCollections.observableArrayList();
        try {
            c = connect_baza.getConnection();
            //SQL FOR SELECTING ALL OF CUSTOMER
            String SQL = "SELECT * from lekarze";
            //ResultSet
            ResultSet rs = c.createStatement().executeQuery(SQL);

            for (int i = 0; i < rs.getMetaData().getColumnCount(); i++) {
                //We are using non property style for making dynamic table
                final int j = i;
                TableColumn col = new TableColumn(rs.getMetaData().getColumnName(i + 1));
                col.setCellValueFactory(new Callback<CellDataFeatures<ObservableList, String>, ObservableValue<String>>() {
                    public ObservableValue<String> call(CellDataFeatures<ObservableList, String> param) {
                        return new SimpleStringProperty(param.getValue().get(j).toString());
                    }
                });

                tableview.getColumns().addAll(col);

                System.out.println("Column [" + i + "] ");
            }

            while (rs.next()) {
                //iteracja Row
                ObservableList<String> row = FXCollections.observableArrayList();
                for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
                    //iteracja Column
                    row.add(rs.getString(i));
                }
                System.out.println("Row [1] added " + row);
                data.add(row);

            }

            //FINALLY ADDED TO TableView
            tableview.setItems(data);

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error on Building Data");
        }
    }

    @Override
    public void start(Stage primaryStage) {
        window = primaryStage;
        window.setTitle("dodawanie lekarzy");
        //TableView
        tableview = new TableView();
        // tableview.setMaxSize(500, 470);
        buildData();

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

        HBox hBox = new HBox();
        hBox.setPadding(new Insets(20, 20, 20, 20));
        hBox.setSpacing(10);
        hBox.getChildren().addAll(IDInput, nameInput, sernameInput, functionInput, e_mailInput,loginInput, hasloInput, addButton, deleteButton, pdfButton);

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
            // pst.setString(1,IDInput.getText());
            pst.setString(1, nameInput.getText());
            pst.setString(2, sernameInput.getText());
            pst.setString(3, functionInput.getText());
            pst.setString(4, e_mailInput.getText());
            pst.setString(5, loginInput.getText());
            pst.setString(6, hasloInput.getText());

            pst.execute();
             


           
        } catch (SQLException ex) {
            Logger.getLogger(Logowaniepacjentow.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void deleteButtonClicked() {
      tableview.getItems().removeAll(tableview.getSelectionModel().getSelectedItem());


    }

    private void pdfButtonClicked() throws FileNotFoundException {
        PrintWriter zapis = new PrintWriter("wynik.pdf");
        zapis.println(data);
        // zapis.format(STYLESHEET_MODENA, data);

        zapis.close();
    }

}
