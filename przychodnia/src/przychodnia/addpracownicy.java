package przychodnia;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
 
@SuppressWarnings("serial")
public class addpracownicy extends Application  {   
    Stage window;
    TableView<Pracownicy> table;
    TextField nameInput, sernameInput, PESELInput, adresInput, e_mailInput, telefonInput, funkcjaInput;
    ComboBox<String> comboBox;
 
   
     
 
    
    public void start(Stage primaryStage)  {
        window = primaryStage;
        window.setTitle("Dodawanie pracowników do bazy");

        //Imie column
        TableColumn<Pracownicy, String> nameColumn = new TableColumn<>("Imie");
        nameColumn.setMinWidth(200);
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));

        //nazwisko column
        TableColumn<Pracownicy, String> sernameColumn = new TableColumn<>("Nazwisko");
        sernameColumn.setMinWidth(200);
        sernameColumn.setCellValueFactory(new PropertyValueFactory<>("surname"));

        //PESEL column
        TableColumn<Pracownicy, Long> PESELColumn = new TableColumn<>("PESEL");
        PESELColumn.setMinWidth(200);
        PESELColumn.setCellValueFactory(new PropertyValueFactory<>("PESEL"));
        
        //adres column
        TableColumn<Pracownicy, String> adresColumn = new TableColumn<>("adres");
        adresColumn.setMinWidth(200);
        adresColumn.setCellValueFactory(new PropertyValueFactory<>("adres"));
        
        //e_mail column
        TableColumn<Pracownicy, String> e_mailColumn = new TableColumn<>("e_mail");
        e_mailColumn.setMinWidth(200);
        e_mailColumn.setCellValueFactory(new PropertyValueFactory<>("e_mail"));
       
        //telefon column
        TableColumn<Pracownicy, Integer> telefonColumn = new TableColumn<>("telefon");
        telefonColumn.setMinWidth(200);
        telefonColumn.setCellValueFactory(new PropertyValueFactory<>("telefon"));
        
        //funkcja column
        TableColumn<Pracownicy, String> funkcjaColumn = new TableColumn<>("funkcja");
        funkcjaColumn.setMinWidth(200);
        funkcjaColumn.setCellValueFactory(new PropertyValueFactory<>("funkcja"));

        //Imie input
        nameInput = new TextField();
        nameInput.setPromptText("Imie");
        nameInput.setMinWidth(100);

        //nazwisko input
        sernameInput = new TextField();
        sernameInput.setPromptText("Nazwisko");

        //PESEL input
        PESELInput = new TextField();
        PESELInput.setPromptText("PESEL");

        //adres input
        adresInput = new TextField();
        adresInput.setPromptText("Adres");

        
        //e_mail input
        e_mailInput = new TextField();
        e_mailInput.setPromptText("E_mail");
 
        //telefon input
        telefonInput = new TextField();
        telefonInput.setPromptText("Telefon");

        //funkcja input
        //Plec Label - constrains use (child, column, row)
        Label plecLabel = new Label("Płeć:");
        GridPane.setConstraints(plecLabel, 0, 4);
        comboBox = new ComboBox<>();
        comboBox.getItems().addAll(
                "Lekarz ",
                "Pielęgniarka"
        );
        //Button
        Button addButton = new Button("Dodaj");
        addButton.setOnAction(e -> addButtonClicked());
        
        Button deleteButton = new Button("Usuń");
        deleteButton.setOnAction(e -> deleteButtonClicked());

        HBox hBox = new HBox();
        hBox.setPadding(new Insets(20,20,20,20));
        hBox.setSpacing(10);
        hBox.getChildren().addAll(nameInput, sernameInput, PESELInput, adresInput, e_mailInput, telefonInput,comboBox, addButton, deleteButton);

        table = new TableView<>();
        table.setItems(getPracownicy());
       // table.getColumns().addAll(nameColumn, sernameColumn, PESELColumn, adresColumn,e_mailColumn,telefonColumn,funkcjaColumn);

        VBox vBox = new VBox();
        vBox.getChildren().addAll(table, hBox);

        Scene scene = new Scene(vBox);
        window.setScene(scene);
        window.show();
    }

    //Add button clicked
    public void addButtonClicked(){
        Pracownicy Pracownicy1 = new Pracownicy();
        Pracownicy1.setName(nameInput.getText());
        Pracownicy1.setSurname(sernameInput.getText());
        Pracownicy1.setE_mail(e_mailInput.getText());
        Pracownicy1.setFunction(funkcjaInput.getText());
        

     //   table.getItems().add(Pracownicy1);
        nameInput.clear();
        sernameInput.clear();
        PESELInput.clear();
        adresInput.clear();
        e_mailInput.clear();
        telefonInput.clear();
        funkcjaInput.clear();
    }

    //Delete button clicked
    public void deleteButtonClicked(){
        ObservableList<Pracownicy> PracownicySelected, allPracownicy;
        allPracownicy = table.getItems();
      //  PracownicySelected = table.getSelectionModel().getSelectedItems();

      //  PracownicySelected.forEach(allPracownicy::remove);
    }

    //Get all of the products
    
    
     
   public ObservableList<Pracownicy> getPracownicy(){
        ObservableList<Pracownicy> Pracownicy1 = FXCollections.observableArrayList();
     //   Pracownicy1.add(new Pracownicy("Adam","Kowalski",93102598742l,"Zakopianka 65","Akowalski@gmail.com",125698745,"Lekarz gastrolog"));
      //  Pracownicy1.add(new Pracownicy("Ewa","Zawilec",12569874514l,"Rzeszów, Kwadratowa 65","EwaZawilec@gmail.com",171415196,"Stomatolog"));

        return Pracownicy1;
    }
     public static void main(String[] args) {
        launch(args);
    }
}

    
        
      

        
    


   
 
         
        
    
