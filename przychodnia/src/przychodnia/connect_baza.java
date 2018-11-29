package przychodnia;
/**
 *
 * @author Krystian Tracz
 */
import java.sql.*;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
//import apka_1.connect.dodawanie_prac;
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
     public ArrayList<Pracownicy> connect(){
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

       public void SelectPracownicy(){
        
        ArrayList<Pracownicy> listpr = connect();
       // DefaultTableModel model = (DefaultTableModel) dodawanie_prac.tablework.getModel();
       Object[] row = new Object[6];
       for(int i=0; i<listpr.size();i++){
        row[0]= listpr.get(i).getid_Lekarza();
        row[1]= listpr.get(i).getName();
        row[2]= listpr.get(i).getSurname();   
        row[4]= listpr.get(i).getFunction();      
        row[3]= listpr.get(i).getE_mail();  
        row[5]= listpr.get(i).getHaslo();
      //  model.addRow(row);

       }
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

