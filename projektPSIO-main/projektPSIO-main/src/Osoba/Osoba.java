package Osoba;

import java.io.Serializable;

public abstract class Osoba implements Serializable {
    private int wiek;
    private String imie;
    private String nazwisko;
    private String pesel;

    public Osoba(int wiek, String imie, String nazwisko, String pesel){
        this.wiek = wiek;
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.pesel = pesel;
    }

    @Override
    public String toString(){
        return("Imię: " + getImie() + " Nazwisko: " + getNazwisko() + " Wiek: " + getWiek() + " Pesel: "+ getPesel() + " ");
    }

    public int getWiek() {
        return wiek;
    }

    public void setWiek(int wiek) {
        this.wiek = wiek;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }
}
