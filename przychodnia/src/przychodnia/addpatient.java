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
public class addpatient extends Application {

    //Ttabela i dane
        TableView <Pacjenci> tableview = new TableView<>();
    TextField  IDInput;
    Stage window;
    Connection conn;
    PreparedStatement pst = null;
    ResultSet rs = null;
    final ObservableList<Pacjenci>  data = FXCollections.observableArrayList();

    //MAIN EXECUTOR
    //CONNECTION DATABASE
   
       public  void addData() {
        try{
   String query="select * from pacjenci";   
            pst = connect_baza.getConnection().prepareStatement(query);
  rs = pst.executeQuery();
  
  while(rs.next()){
      data.add(new Pacjenci(
              rs.getInt("id_pacjenta"),rs.getString("imie"), rs.getString("nazwisko"),rs.getInt("PESEL"), rs.getString("adres"), rs.getInt("telefon"), rs.getString("email"),rs.getString("haslo")));
              
           
  }
  tableview.setItems(data);
  pst.close();
  rs.close();
  }
         catch (SQLException ex) {
            Logger.getLogger(Logowaniepacjentow.class.getName()).log(Level.SEVERE, null, ex);
}  
}

    @Override
    public void start(Stage primaryStage) {
        window = primaryStage;
        window.setTitle("dodawanie lekarzy");
        //TableView
        tableview = new TableView();
        // tableview.setMaxSize(500, 470);
       addData();
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
               tableview.getColumns().addAll(IDColumn,nameColumn,sernameColumn,PESELColumn,adresColumn,telefonColumn,e_mailColumn,hasloColumn);

        //Main Scene
        //Imie input
        IDInput = new TextField();
        IDInput.setPromptText("ID");

      
        //Button
      

        Button deleteButton = new Button("Usuń");
        deleteButton.setOnAction(e -> deleteButtonClicked());

        Button pdfButton = new Button("PDF");
        pdfButton.setOnAction(e -> {
            try {
                pdfButtonClicked();
            } catch (FileNotFoundException ex) {
                Logger.getLogger(addpatient.class.getName()).log(Level.SEVERE, null, ex);
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
        hBox.getChildren().addAll(tableview,IDInput, deleteButton, pdfButton, backButton);

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

   

    private void deleteButtonClicked() {
 try {

            String query = "DELETE FROM pacjenci WHERE id_pacjenta= ?";
            pst = connect_baza.getConnection().prepareStatement(query);
             pst.setString(1,IDInput.getText());
            
          

            pst.executeUpdate();

            tableview.setItems(data);
addpatient adp = new addpatient();
adp.start(window);
        } catch (SQLException ex) {
            Logger.getLogger(Logowaniepacjentow.class.getName()).log(Level.SEVERE, null, ex);
        }
    } 

    private void pdfButtonClicked() throws FileNotFoundException {
        pdf p = new pdf();
        p.getpdfpacjent();

    }

    
}
