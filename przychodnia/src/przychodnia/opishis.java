package przychodnia;

public class opishis {

    private String name;
    private String surname;
   

    

    public opishis(){
        this.name = "";
        this.surname ="";


    }

    public opishis(String name, String surname){
        this.name = name;
        this.surname = surname;


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

 /*
   public String getopis() {
        return opis;
    }

    public void setopis(String opis) {
        this.opis = opis;
    }
    */


}