package przychodnia;

/**
 *
 * @author Bartek
 */
public class Product {

    private String name;
    private String surname;
    private String lek;
    private double cena;
    private int ilosc;

    public Product(){
        this.name = "";
        this.surname = "";
        this.lek = "";
        this.cena = 0;
        this.ilosc = 0;
    }

    public Product(String name, String surname, String lek, double cena, int ilosc){
        this.name = name;
        this.surname = surname;
        this.lek = lek;
        this.cena = cena;
        this.ilosc = ilosc;
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
    
    public double getCena() {
        return cena;
    }

    public void setCena(double cena) {
        this.cena = cena;
    }

    public int getIlosc() {
        return ilosc;
    }

    public void setIlosc(int ilosc) {
        this.ilosc = ilosc;
    }

}