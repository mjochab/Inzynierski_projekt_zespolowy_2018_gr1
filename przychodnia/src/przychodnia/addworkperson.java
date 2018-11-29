/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package przychodnia;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author Krystian Tracz
 */
@SuppressWarnings("serial")

public class addworkperson extends Application {

    Stage window;
    TableView<Pracownicy> table;
    TextField IDInput, nameInput, sernameInput, functionInput, e_mailInput, hasloInput;

    @Override
    public void start(Stage primaryStage) {
        window = primaryStage;
        window.setTitle("Dodawanie pracowników do bazy");

        //Id column
        TableColumn<Pracownicy, String> IDColumn = new TableColumn<>("Imie");
        IDColumn.setMinWidth(200);
        IDColumn.setCellValueFactory(new PropertyValueFactory<>("name"));

        //Imie column
        TableColumn<Pracownicy, String> nameColumn = new TableColumn<>("Imie");
        nameColumn.setMinWidth(200);
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));

        //nazwisko column
        TableColumn<Pracownicy, String> sernameColumn = new TableColumn<>("Nazwisko");
        sernameColumn.setMinWidth(200);
        sernameColumn.setCellValueFactory(new PropertyValueFactory<>("surname"));

        //funkcja column
        TableColumn<Pracownicy, String> funkcjaColumn = new TableColumn<>("funkcja");
        funkcjaColumn.setMinWidth(200);
        funkcjaColumn.setCellValueFactory(new PropertyValueFactory<>("funkcja"));

        //e_mail column
        TableColumn<Pracownicy, String> e_mailColumn = new TableColumn<>("e_mail");
        e_mailColumn.setMinWidth(200);
        e_mailColumn.setCellValueFactory(new PropertyValueFactory<>("e_mail"));

        //funkcjacolumn
        TableColumn<Pracownicy, String> hasloColumn = new TableColumn<>("hasło");
        hasloColumn.setMinWidth(200);
        hasloColumn.setCellValueFactory(new PropertyValueFactory<>("haslo"));

        //Imie input
        IDInput = new TextField();
        nameInput.setPromptText("ID");

        nameInput = new TextField();
        nameInput.setPromptText("Imie");
        nameInput.setMinWidth(100);

        //nazwisko input
        sernameInput = new TextField();
        sernameInput.setPromptText("Nazwisko");

        //funkcja input
        functionInput = new TextField();
        functionInput.setPromptText("Funkcja");

        //e_mail input
        e_mailInput = new TextField();
        e_mailInput.setPromptText("E_mail");

        //haslo input
        hasloInput = new TextField();
        hasloInput.setPromptText("Hasło");

        //Button
        Button addButton = new Button("Dodaj");
        addButton.setOnAction(e -> addButtonClicked());

        Button deleteButton = new Button("Usuń");
        deleteButton.setOnAction(e -> deleteButtonClicked());

        HBox hBox = new HBox();
        hBox.setPadding(new Insets(20, 20, 20, 20));
        hBox.setSpacing(10);
        hBox.getChildren().addAll(IDInput, nameInput, sernameInput, e_mailInput, functionInput, hasloInput, addButton, deleteButton);

        table = new TableView<>();
        table.setItems(getPracownicy());
        table.getColumns().addAll(IDColumn, nameColumn, sernameColumn, funkcjaColumn, e_mailColumn, hasloColumn);

        VBox vBox = new VBox();
        vBox.getChildren().addAll(table, hBox);

        Scene scene = new Scene(vBox);
        window.setScene(scene);
        window.show();
    }

    //Add button clicked
    public void addButtonClicked() {
        Pracownicy Pracownicy1 = new Pracownicy();
        Pracownicy1.setid_Lekarza(Integer.parseInt(IDInput.getText()));
        Pracownicy1.setName(nameInput.getText());
        Pracownicy1.setSurname(sernameInput.getText());
        Pracownicy1.setFunction(functionInput.getText());
        Pracownicy1.setE_mail(e_mailInput.getText());
        Pracownicy1.setHaslo(hasloInput.getText());

        table.getItems().add(Pracownicy1);
        IDInput.clear();
        nameInput.clear();
        sernameInput.clear();
        functionInput.clear();
        e_mailInput.clear();
        hasloInput.clear();
    }

    //Delete button clicked
    public void deleteButtonClicked() {
        ObservableList<Pracownicy> PracownicySelected, allPracownicy;
       allPracownicy = table.getItems();
     PracownicySelected = table.getSelectionModel().getSelectedItems();

      // PracownicySelected.forEach(allPracownicy::remove);
    }

    public ObservableList<Pracownicy> getPracownicy() {
        ObservableList<Pracownicy> Pracownicy1 = FXCollections.observableArrayList();
       Pracownicy1.add(new Pracownicy(1, "Adam", "Kowalski", "Akowalski@gmail.com", "Lekarz gastrolog", "admin123"));
        Pracownicy1.add(new Pracownicy(2, "Ewa", "Zawilec", "EwaZawilec@gmail.com", "Stomatolog", "Admin12"));

        return Pracownicy1;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
