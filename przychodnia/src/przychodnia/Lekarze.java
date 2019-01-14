package przychodnia;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Lekarze {

    final SimpleIntegerProperty id_lekarza;
    private SimpleStringProperty name;
    private SimpleStringProperty surname;    
    private SimpleStringProperty function;
    private SimpleStringProperty e_mail;
    private SimpleStringProperty login;
    private SimpleStringProperty haslo;
    
    public Lekarze(int id_lekarza, String name, String surname, String function, String e_mail, String login, String haslo) {
        this.id_lekarza = new SimpleIntegerProperty(id_lekarza);
        this.name = new SimpleStringProperty(name);
        this.surname = new SimpleStringProperty(surname);
        this.function = new SimpleStringProperty(function);
        this.e_mail = new SimpleStringProperty(e_mail);
        this.login = new SimpleStringProperty(login);
        this.haslo = new SimpleStringProperty(haslo);        
    }
    
    public int getid_Lekarza() {
        return id_lekarza.get();
    }

    public void setid_Lekarza(int id) {
        id_lekarza.set(id);
    }
    
    public String getName() {
        return name.get();
    }

    public void setName(String names) {
        name.set(names);
    }
    
    public String getSurname() {
        return surname.get();
    }

    public void setSurname(String surnames) {
        surname.set(surnames);
        
    }
    
    public String getFunction() {
        return function.get();
    }

    public void setFunction(String functions) {
        function.set(functions);
    }
    
    public String getE_mail() {
        return e_mail.get();
    }

    public void setE_mail(String email) {
        e_mail.set(email);
    }

    public String getLogin() {
        return login.get();
    }    

    public void setLogin(String logins) {
        login.set(logins);
    }
    
    public String getHaslo() {
        return haslo.get();
    }    

    public void setHaslo(String haslos) {
        haslo.set(haslos);
    }
    
}
