package przychodnia;

public class Lekarze {
    private int id_lekarza;
    private String name;
    private String surname;    
    private String function;
    private String e_mail;
    private String login;
    private String haslo;


    public Lekarze(){
        this.id_lekarza=0;
        this.name = "";
        this.surname ="";
        this.function="";
        this.e_mail = "";
        this.login="";
        this.haslo = "";
        
    }

    public Lekarze(int id_lekarza, String name, String surname, String function, String e_mail, String login, String haslo){
        this.id_lekarza=id_lekarza;
        this.name = name;
        this.surname = surname;
        this.function= function;
        this.e_mail = e_mail;
        this.login=login;
        this.haslo= haslo;     
    }
   

    public int getid_Lekarza(){
     return id_lekarza;
    }
    public void setid_Lekarza(int id_lekarza){
     this.id_lekarza=id_lekarza;   
    }
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }

     public String getFunction() {
        return function;
    }
     public void setFunction(String function) {
        this.function = function;
    }
     
   public String getE_mail() {
        return e_mail;
    }
    public void setE_mail(String e_mail) {
        this.e_mail = e_mail;
    }
       public String getLogin() {
        return login;
    } 
    public void setLogin(String login) {
        this.login = login;
    }
    
    
    public String getHaslo() {
        return haslo;
    } 
    public void setHaslo(String haslo) {
        this.haslo = haslo;
    }

    }

    
   
 
