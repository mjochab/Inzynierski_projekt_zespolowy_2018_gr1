/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package przychodnia;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.scene.control.TableView;

/**
 *
 * @author Krystian Tracz
 */
public class Pacjenci {

    private final SimpleIntegerProperty id_pacjenta;
    private final SimpleStringProperty name;
    private final SimpleStringProperty surname;
    private final SimpleIntegerProperty PESEL;
    private final SimpleStringProperty adres;
    private final SimpleIntegerProperty telephon;
    private final SimpleStringProperty e_mail;
    private final SimpleStringProperty haslo;

    public Pacjenci(int id, String names, String surname, int PESEL, String adres, int telephon, String e_mail, String haslo) {
        this.id_pacjenta = new SimpleIntegerProperty(id);
        this.name = new SimpleStringProperty(names);
        this.surname = new SimpleStringProperty(surname);
        this.PESEL = new SimpleIntegerProperty(PESEL);
        this.adres = new SimpleStringProperty(adres);
        this.telephon = new SimpleIntegerProperty(telephon);
        this.e_mail = new SimpleStringProperty(e_mail);
        this.haslo = new SimpleStringProperty(haslo);
    }

    /*
    public Pacjenci(String name,String surname ){
      this.name=name;
      this.surname= surname;
    }
      
    public Pacjenci(String name,String surname, int PESEL){
      this.name=name;
      this.surname= surname;
      this.PESEL=null;
    }
     */
    public int getid_Pacjenta() {
        return id_pacjenta.get();
    }

    public String getName() {
        return name.get();
    }

    public String getSurname() {
        return surname.get();
    }

    public int getPESEL() {
        return PESEL.get();
    }

    public String getAdres() {
        return adres.get();
    }

    public int getTelepon() {
        return telephon.get();
    }

    public String getE_mail() {
        return e_mail.get();
    }

    public String getHaslo() {
        return haslo.get();
    }
public void setId_Pacjeta(int id){
  id_pacjenta.set(id);
}

public void setName(String names){
  name.set(names);
}
public void setSurnmae(String surnames){
  surname.set(surnames);
}
public void setPESEL(Integer pesel){
  PESEL.set(pesel);
}
public void setTelephon(Integer telephons){
  telephon.set(telephons);
}
public void setEmail(String email){
  e_mail.set(email);
}
public void setHaslo(String haslo1){
  haslo.set(haslo1);
}

}
