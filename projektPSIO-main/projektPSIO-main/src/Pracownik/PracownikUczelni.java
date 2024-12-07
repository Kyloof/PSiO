package Pracownik;

import wynagrodzenieStrategy.Wynagrodzenie;

public class PracownikUczelni extends Pracownik{
    private String stanowisko;

    public PracownikUczelni(int wiek, String imie, String nazwisko, String pesel, int ileLatPrzepracowane, String stanowisko, Wynagrodzenie wynagrodzenie) {
        super(wiek, imie, nazwisko, pesel, ileLatPrzepracowane, wynagrodzenie);
        this.stanowisko = stanowisko;
    }
    @Override
    public String toString(){
        return (super.toString()+ "<br>" + " Stanowisko: " + getStanowisko());
    }
    public String getStanowisko() {
        return stanowisko;
    }

    public void setStanowisko(String stanowisko) {
        this.stanowisko = stanowisko;
    }
}
