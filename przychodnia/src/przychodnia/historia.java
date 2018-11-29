/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package przychodnia;

import java.util.ArrayList;
//import przychodnia.Pacjenci;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Krystian Tracz
 */

 
@SuppressWarnings("serial")
public class historia extends Application  { 
    Stage window;
    TableView<Pacjenci> table;
    TextField SearchField;
  
 
   
     
 

    @Override
    public void start(Stage primaryStage) {
        window = primaryStage;
        window.setTitle("Okno histori choroby");
                
        //Imie column
        TableColumn<Pacjenci, String> nameColumn = new TableColumn<>("Imie");
        nameColumn.setMinWidth(250);
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));

        //nazwisko column
        TableColumn<Pacjenci, String> surnameColumn = new TableColumn<>("Nazwisko");
        surnameColumn.setMinWidth(250);
        surnameColumn.setCellValueFactory(new PropertyValueFactory<>("surname"));

       /*  TableColumn<opishis, String> notkaColumn = new TableColumn<>("Notka");
        notkaColumn.setMinWidth(200);
        notkaColumn.setCellValueFactory(new PropertyValueFactory<>("notka"));
*/
        // przycik dodaj
        
       Button notkaButton = new Button("Notka");
       notkaButton.setOnAction(e -> notkaButtonCliked());
        
       
        //Imie input
        SearchField = new TextField();
        SearchField.setPromptText("Wyszukuaj");
        SearchField.setMinWidth(100);

 
       
       

        //Button
        Button addButton = new Button("Wyszukaj");
        addButton.setOnAction(e -> searchButtonClicked ());
        

        HBox hBox = new HBox();
        hBox.setPadding(new Insets(10,10,10,10));
        hBox.setSpacing(10);
        hBox.getChildren().addAll(SearchField, addButton,notkaButton);

        table = new TableView<>();
        table.setItems(getPacjenci());
        table.getColumns().addAll(nameColumn, surnameColumn);

        VBox vBox = new VBox();
        vBox.getChildren().addAll(table, hBox);

        Scene scene = new Scene(vBox);
        window.setScene(scene);
        window.show();
    }

    //Add button clicked
    public void searchButtonClicked(){
     /*   opishis opishis1 = new opishis();
        opishis1.setName(nameInput.getText());
        opishis1.setSurname(surnameInput.getText());
        table.getItems().add(opishis1);
        nameInput.clear();
        surnameInput.clear();
        */
     //FilteredList<opishis> filteredData = new FilteredList<>(nameColumn,)
     
    }

    //Delete button clicked
    public void deleteButtonClicked(){
       
    
     
    }
 
    
     
    
   public ObservableList<Pacjenci> getopishis(){
      
     ObservableList<Pacjenci> pacjenci = FXCollections.observableArrayList();
      
         pacjenci.add(new Pacjenci("Adam","Kowalski"));
        pacjenci.add(new Pacjenci("Ewa","Zawilec"));
        pacjenci.add(new Pacjenci("Hania","Mosteczek"));
        pacjenci.add(new Pacjenci("Jan","NOwieslki"));


        return pacjenci;
   }

    private void notkaButtonCliked() {
    /*   choroby choroby1 = new choroby();
       choroby1.choroby();
       choroby1.setVisible(true);
     */  
    }
    
    public static void main(String[] args) {
        launch(args);
    }

    private ObservableList<Pacjenci> getPacjenci() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

    
        
      

        
    


   
 
         
        
    

 
