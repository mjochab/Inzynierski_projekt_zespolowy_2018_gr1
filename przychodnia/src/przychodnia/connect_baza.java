package przychodnia;
/**
 *
 * @author Krystian Tracz
 */
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class connect_baza {    
 
 private Connection conn;
 private Statement prepStmt;
 private ResultSet rs;

       
		   
    /**
     * @param args the command line arguments
     * @return 
     * @throws java.sql.SQLException
     */
     public ArrayList<Pracownicy> connectlek(){
    ArrayList<Pracownicy> workList = new ArrayList<>();		   
           try
           {
               Class.forName ("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection( "jdbc:mysql://localhost:3306/przuchodnia" ,"root", "");
          prepStmt = conn.createStatement();       
          String query1 = "Select * from lekarze";               
          rs =  prepStmt.executeQuery(query1);
            Pracownicy pracownik;
            while (rs.next()) {
               pracownik = new Pracownicy(rs.getInt("id_lekarza"), rs.getString("imie"), rs.getString("nazwisko"), rs.getString("specjalność"), rs.getString("email"), rs.getString("hasło"));
               workList.add(pracownik);
            }
      JOptionPane.showMessageDialog(null, "Połączyłeś się z bazą");
            }
        catch (Exception ex)
        {
            JOptionPane.showMessageDialog(null, "Nie połączyłeś się z bazą"+ex);
        }
        return workList;
    }

       public ArrayList<Pacjenci> connectpac(){
    ArrayList<Pacjenci> personList = new ArrayList<>();		   
           try
           {
               Class.forName ("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection( "jdbc:mysql://localhost:3306/przuchodnia" ,"root", "");
          prepStmt = conn.createStatement();       
          String query1 = "Select * from pacjenci";               
          rs =  prepStmt.executeQuery(query1);
            Pacjenci pacjenci;
            while (rs.next()) {
               pacjenci = new Pacjenci(rs.getInt("id_pacjenta"), rs.getString("imie"), rs.getString("nazwisko"), rs.getString("PESEL"), rs.getString("email"), rs.getString("hasło"), rs.getString("notatka"));
               personList.add(pacjenci);
            }
      JOptionPane.showMessageDialog(null, "Połączyłeś się z bazą");
            }
        catch (Exception ex)
        {
            JOptionPane.showMessageDialog(null, "Nie połączyłeś się z bazą"+ex);
        }
        return personList;
    }
}
        
        
    
    
    
    
    
    
    
    
      
/*

 public static void main(String[] args) throws SQLException {
 connect_baza conbaza = new connect_baza();   
//conbaza.insert();
 conbaza.connect();
    }

}

 */   

