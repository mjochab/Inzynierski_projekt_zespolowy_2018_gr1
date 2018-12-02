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
public class addpeople extends Application  {   
    Stage window;
    TableView<Lekarze> table;
 
   
     
 

    @Override
    public void start(Stage primaryStage) {
        window = primaryStage;
        window.setTitle("Dodawanie pracowników do bazy");

        
        //Button
        
        Button addButton = new Button("Lekarz");
       //addButton.setOnAction(e -> addButtonClicked());
        
        Button deleteButton = new Button("Pilęgniarka");
        deleteButton.setOnAction(e -> deleteButtonClicked());

        HBox hBox = new HBox();
        hBox.setPadding(new Insets(30,30,30,30));
        hBox.setSpacing(10);
        hBox.getChildren().addAll( addButton, deleteButton);

       
        VBox vBox = new VBox();
        vBox.getChildren().addAll(hBox);

        Scene scene = new Scene(vBox);
        window.setScene(scene);
        window.show();
    }

    //Add button clicked
    public void addButtonClicked(){
    addworkpearson addprac = new addworkpearson();
    addprac.start(window);
  
        

       
    }

    //Delete button clicked
    public void deleteButtonClicked(){
      
    }

    
    
      public static void main(String[] args) {
        launch(args);
    }
  
}

    
        
      

        
    


   
 
         
        
    
