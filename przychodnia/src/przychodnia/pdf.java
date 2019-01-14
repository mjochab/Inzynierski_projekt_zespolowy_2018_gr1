/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package przychodnia;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Krystian Tracz
 */
public class pdf {
    
    public void getpdflekarz(){
        try {
            String file_name = "lekarze.pdf";
            Document document = new Document() {};
            PdfWriter.getInstance(document, new FileOutputStream(file_name));
            document.open();
            
            connect_baza conbaz = new connect_baza();
            Connection connection = conbaz.getConnection1();
            PreparedStatement ps = null;
            ResultSet rs = null;
            
            String query = "Select * from lekarze";
            ps=connection.prepareStatement(query);
            rs = ps.executeQuery();
            while(rs.next()){
                
                Paragraph para = new Paragraph(rs.getString("id_lekarza")+" , "+ rs.getString("imie")+" , "+rs.getString("nazwisko")+" , "+rs.getString("specjalnosc")+" , "+rs.getString("email")+" , "+rs.getString("login"));
                document.add(para);
                document.add(new Paragraph(" "));
            }
             document.add(new Paragraph(" "));
            document.close();
        } catch (SQLException ex) {
            Logger.getLogger(pdf.class.getName()).log(Level.SEVERE, null, ex);
        } catch (DocumentException ex) {
            Logger.getLogger(pdf.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(pdf.class.getName()).log(Level.SEVERE, null, ex);
        }
}
    
     public void getpdfpacjent(){
        try {
            String file_name = "pacjenci.pdf";
            Document document = new Document() {};
            PdfWriter.getInstance(document, new FileOutputStream(file_name));
            document.open();
            
            connect_baza conbaz = new connect_baza();
            Connection connection = conbaz.getConnection1();
            PreparedStatement ps = null;
            ResultSet rs = null;
            
            String query = "Select * from pacjenci";
            ps=connection.prepareStatement(query);
            rs = ps.executeQuery();
            while(rs.next()){
                
                Paragraph para = new Paragraph(rs.getString("id_pacjenta")+" , "+ rs.getString("imie")+" , "+rs.getString("nazwisko")+" , "+rs.getString("PESEL")+" , "+rs.getString("adres")+" , "+rs.getInt("telefon")+","+rs.getString("email")+",  "+ rs.getString("haslo"));
                document.add(para);
                document.add(new Paragraph(" "));
            }
             document.add(new Paragraph(" "));
            document.close();
        } catch (SQLException ex) {
            Logger.getLogger(pdf.class.getName()).log(Level.SEVERE, null, ex);
        } catch (DocumentException ex) {
            Logger.getLogger(pdf.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(pdf.class.getName()).log(Level.SEVERE, null, ex);
        }
}
}

 

