/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package przychodnia;

import java.sql.*;
import java.util.function.Predicate;
import java.util.logging.*;
import javafx.application.Application;
import javafx.collections.*;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 *
 * @author Krystian Tracz
 */
public class wizyty extends Application {
    // private TableView tableview;

    TableView<Pacjenci> tableview = new TableView<>();

    TextField searchInput;
    Stage window;
    Connection conn;
    PreparedStatement pst = null;
    ResultSet rs = null;
    final ObservableList<Pacjenci> data = FXCollections.observableArrayList();

    public void addData() {
        try {
            String query = "select * from pacjenci";
            pst = connect_baza.getConnection().prepareStatement(query);
            rs = pst.executeQuery();

            while (rs.next()) {
                data.add(new Pacjenci(
                        rs.getInt("id_pacjenta"), rs.getString("imie"), rs.getString("nazwisko"), rs.getInt("PESEL"), rs.getString("adres"), rs.getInt("telefon"), rs.getString("email"), rs.getString("haslo")));

            }
            tableview.setItems(data);
            pst.close();
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(Logowaniepacjentow.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void start(Stage primaryStage) {
        window = primaryStage;
        window.setTitle(" Wizyta");
        addData();

        searchInput = new TextField();
        searchInput.setPromptText("Wyszukaj pacjenta");
        searchInput.setMaxWidth(200);
        FilteredList<Pacjenci> filteredData = new FilteredList<>(data, e -> true);
        searchInput.setOnKeyReleased(e -> {
            searchInput.textProperty().addListener((observableValue, oldValue, newValue) -> {
                filteredData.setPredicate((Predicate<? super Pacjenci>) pacjenci -> {
                    if (newValue == null || newValue.isEmpty()) {
                        return true;
                    }
                    String lowerCaseFilter = newValue.toLowerCase();
                    if (pacjenci.getName().toLowerCase().contains(lowerCaseFilter)) {
                        return true;
                    } else if (pacjenci.getSurname().toLowerCase().contains(lowerCaseFilter)) {
                        return true;
                    }
                    return false;
                });
            });
            SortedList<Pacjenci> sortedData = new SortedList<>(filteredData);
            sortedData.comparatorProperty().bind(tableview.comparatorProperty());
            tableview.setItems(sortedData);

        });
        TextArea textArea = new TextArea();
        textArea.setMaxSize(200, 300);
        //id column
        TableColumn<Pacjenci, Integer> IDColumn = new TableColumn<>("ID");
        IDColumn.setMinWidth(50);
        IDColumn.setCellValueFactory(new PropertyValueFactory<>("ID"));

        //Imie column
        TableColumn<Pacjenci, String> nameColumn = new TableColumn<>("Imie");
        nameColumn.setMinWidth(200);
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));

        //nazwisko column
        TableColumn<Pacjenci, String> sernameColumn = new TableColumn<>("Nazwisko");
        sernameColumn.setMinWidth(200);
        sernameColumn.setCellValueFactory(new PropertyValueFactory<>("surname"));

        //PESEL column
        TableColumn<Pacjenci, Long> PESELColumn = new TableColumn<>("PESEL");
        PESELColumn.setMinWidth(200);
        PESELColumn.setCellValueFactory(new PropertyValueFactory<>("PESEL"));

        //adres column
        TableColumn<Pacjenci, String> adresColumn = new TableColumn<>("adres");
        adresColumn.setMinWidth(200);
        adresColumn.setCellValueFactory(new PropertyValueFactory<>("adres"));

        //telefon column
        TableColumn<Pacjenci, Integer> telefonColumn = new TableColumn<>("telefon");
        telefonColumn.setMinWidth(200);
        telefonColumn.setCellValueFactory(new PropertyValueFactory<>("telefon"));

        //e_mail column
        TableColumn<Pacjenci, String> e_mailColumn = new TableColumn<>("e_mail");
        e_mailColumn.setMinWidth(200);
        e_mailColumn.setCellValueFactory(new PropertyValueFactory<>("e_mail"));

        //funkcja column
        TableColumn<Pacjenci, String> hasloColumn = new TableColumn<>("haslo");
        hasloColumn.setMinWidth(200);
        hasloColumn.setCellValueFactory(new PropertyValueFactory<>("haslo"));

        tableview.getColumns().addAll(IDColumn, nameColumn, sernameColumn, PESELColumn, adresColumn, telefonColumn, e_mailColumn, hasloColumn);

        /*      
 Button btn = new Button("Dodaj historie pacjenta");
          btn.setOnAction(event -> {
historia his =new historia();
his.start(primaryStage);
         
              });*/
        Button logouteButton = new Button("Wyloguj się");
        logouteButton.setOnAction(e -> logButtonClicked());
       

        HBox hBox = new HBox();
        hBox.setPadding(new Insets(20, 20, 20, 20));
        hBox.setSpacing(10);
        hBox.getChildren().addAll(searchInput,textArea, tableview);

        //Main Scene
        VBox vBox = new VBox();
        vBox.setStyle("-fx-background-image:url('img/tapeta.jpg')");
        vBox.getChildren().addAll(hBox, logouteButton);
        Scene scene = new Scene(vBox);

        window.setScene(scene);
        window.show();
    }

    public void logButtonClicked() {
        Wyborlogowania wyblog = new Wyborlogowania();
        wyblog.start(window);
    }

    private void NotkaButtonClicked() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
