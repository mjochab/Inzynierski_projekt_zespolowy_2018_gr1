package przychodnia;

/**
 *
 * @author Bartek
 */
public class Product {

    private int id;
    private String name;
    private String surname;
    private String lek;
    private int ilosc;

    public Product(){
        this.id = 0;
        this.name = "";
        this.surname = "";
        this.lek = "";
        this.ilosc = 0;
    }

    public Product(int id, String name, String surname, String lek, int ilosc){
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.lek = lek;
        this.ilosc = ilosc;
    }

    public int getID() {
        return id;
    }

    public void setID(int id) {
        this.id = id;
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

    public String getLek() {
        return lek;
    }

    public void setLek(String lek) {
        this.lek = lek;
    }
    
    public int getIlosc() {
        return ilosc;
    }

    public void setIlosc(int ilosc) {
        this.ilosc = ilosc;
    }
}