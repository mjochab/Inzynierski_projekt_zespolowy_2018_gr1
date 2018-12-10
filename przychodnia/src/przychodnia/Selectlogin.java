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
public class Selectlogin extends Application  {   
    Stage window;
 
   
     
 

    @Override
    public void start(Stage primaryStage) {
        window = primaryStage;
        window.setTitle("Dodawanie pracowników do bazy");

        
       ;

        HBox hBox = new HBox();
        hBox.setPadding(new Insets(30,30,30,30));
        hBox.setSpacing(10);
        hBox.getChildren().addAll();

       
        VBox vBox = new VBox();
        vBox.getChildren().addAll(hBox);

        Scene scene = new Scene(vBox,400,500);
        window.setScene(scene);
        window.show();
    }
    
    

      
    

    
    
      
    }
  


    
        
      

        
    


   
 
         
        
    
