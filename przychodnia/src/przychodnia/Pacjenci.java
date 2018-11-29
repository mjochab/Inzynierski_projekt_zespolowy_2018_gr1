/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package przychodnia;

/**
 *
 * @author Krystian Tracz
 */
public class Pacjenci {
   private int id_pacjenta;
    private String name;
    private String surname;    
    private String PESEL;
    private String e_mail;
    private String haslo;
    private String notka;


    public Pacjenci(){
        this.id_pacjenta=0;
        this.name = "";
        this.surname ="";
        this.PESEL="";
        this.e_mail = "";
        this.haslo = "";
        this.notka="";
    }

    public void Pacjenci(int id_pacjenta, String name, String surname, String PESEL, String e_mail, String haslo, String notka){
        this.id_pacjenta=id_pacjenta;
        this.name = name;
        this.surname = surname;
        this.PESEL=PESEL;
        this.e_mail = e_mail;
        this.haslo= haslo;   
        this.notka=notka;
    }
    public Pacjenci(String name,String surname){
      this.name=name;
      this.surname= surname;
    }

    public int getid_Pacjentaa(){
     return id_pacjenta;
    }
    public void setid_Pacjentaint(int id_pacjenta){
     this.id_pacjenta=id_pacjenta;   
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

     public String getPESEL() {
        return PESEL;
    }
     public void setPESEL(String PESEL) {
        this.PESEL = PESEL;
    }
     
   public String getE_mail() {
        return e_mail;
    }
    public void setE_mail(String e_mail) {
        this.e_mail = e_mail;
    }
    
     public String getHaslo() {
        return haslo;
    } 
    public void setHaslo(String haslo) {
        this.haslo = haslo;
    }
    
    public String getNotka() {
        return notka;
    } 
    public void setNotka(String notka) {
        this.notka = notka;
    }
     
}