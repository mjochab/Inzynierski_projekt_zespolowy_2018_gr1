package przychodnia;
/**
 *
 * @author Krystian Tracz
 */
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class connect_baza {    
 

       
		   
    /**
     * @param args the command line arguments
     * @return 
     * @throws java.sql.SQLException
     */
 
    private static String driverName = "com.mysql.jdbc.Driver";
    private static String username = "root";
    private static String password = "";
    private static Connection myConn;
//

    public static Connection getConnection() {
        try {
            Class.forName(driverName);
            try {
                myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/przuchodnia", "root", "");
            } catch (SQLException ex) {
                System.out.println("Failed to create the database connection.");
            }
        } catch (ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
        return myConn;
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

