package przychodnia;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
/**
 *
 * @author Bartek
 */
public class Recepty extends Application {

    Stage window;
    TableView<Product> table;
    TextField idInput, nameInput, surnameInput, lekInput, iloscInput;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        window.setTitle("Recepty");

        //ID column
        TableColumn<Product, String> idColumn = new TableColumn<>("ID Recepty");
        idColumn.setMinWidth(100);
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        
        //Name column
        TableColumn<Product, String> nameColumn = new TableColumn<>("Imię");
        nameColumn.setMinWidth(150);
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        
        //Surname column
        TableColumn<Product, String> surnameColumn = new TableColumn<>("Nazwisko");
        surnameColumn.setMinWidth(150);
        surnameColumn.setCellValueFactory(new PropertyValueFactory<>("surname"));

        //Lek column
        TableColumn<Product, String> lekColumn = new TableColumn<>("Nazwa leku");
        lekColumn.setMinWidth(150);
        lekColumn.setCellValueFactory(new PropertyValueFactory<>("lek"));
        
        //Ilosc column
        TableColumn<Product, String> iloscColumn = new TableColumn<>("Ilość");
        iloscColumn.setMinWidth(100);
        iloscColumn.setCellValueFactory(new PropertyValueFactory<>("ilosc"));

        //Ilosc input
        idInput = new TextField();
        idInput.setPromptText("ID");
        idInput.setMaxWidth(45);

        //Name input
        nameInput = new TextField();
        nameInput.setPromptText("Imię");
        nameInput.setMinWidth(100);
        
        //Surname input
        surnameInput = new TextField();
        surnameInput.setPromptText("Nazwisko");
        surnameInput.setMinWidth(100);

        //Lek input
        lekInput = new TextField();
        lekInput.setPromptText("Nazwa lek");
        lekInput.setMinWidth(100);
        
        //Ilosc input
        iloscInput = new TextField();
        iloscInput.setPromptText("Ilość");
        iloscInput.setMaxWidth(45);

        //Button
        Button addButton = new Button("Dodaj");
        addButton.setOnAction(e -> addButtonClicked());
        Button deleteButton = new Button("Usuń");
        deleteButton.setOnAction(e -> deleteButtonClicked());

        HBox hBox = new HBox();
        hBox.setPadding(new Insets(10,10,10,10));
        hBox.setSpacing(10);
        hBox.getChildren().addAll(idInput, nameInput, surnameInput, lekInput, iloscInput, addButton, deleteButton);

        table = new TableView<>();
        table.setItems(getProduct());
        table.getColumns().addAll(idColumn, nameColumn, surnameColumn, lekColumn, iloscColumn);

        VBox vBox = new VBox();
        vBox.getChildren().addAll(table, hBox);

        Scene scene = new Scene(vBox);
        window.setScene(scene);
        window.show();
    }

    //Add button clicked
    public void addButtonClicked(){
        Product product = new Product();
        product.setID(Integer.parseInt(idInput.getText()));
        product.setName(nameInput.getText());
        product.setSurname(surnameInput.getText());
        product.setLek(lekInput.getText());
        product.setIlosc(Integer.parseInt(iloscInput.getText()));
        table.getItems().add(product);
        nameInput.clear();
        surnameInput.clear();
        lekInput.clear();
        iloscInput.clear();
    }

    //Delete button clicked
    public void deleteButtonClicked(){
        ObservableList<Product> productSelected, allProducts;
        allProducts = table.getItems();
        productSelected = table.getSelectionModel().getSelectedItems();

        productSelected.forEach(allProducts::remove);
    }

    //Get all of the products
    public ObservableList<Product> getProduct(){
        ObservableList<Product> products = FXCollections.observableArrayList();
        products.add(new Product(1, "Jan", "Kowalski", "Njfofjo", 78));
        products.add(new Product(2, "Jacek", "Nowak", "Tdbflaj", 42));
        return products;
    }
}