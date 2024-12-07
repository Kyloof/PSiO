package Pracownik;

import Osoba.Osoba;
import wynagrodzenieStrategy.Wynagrodzenie;
import wynagrodzenieStrategy.obliczWynagrodzeniePoStazu;

public abstract class Pracownik extends Osoba {
    private Wynagrodzenie wynagrodzenie;
    private int ileLatPrzepracowane;

    public Pracownik(int wiek, String imie, String nazwisko, String pesel, int ileLatPrzepracowane, Wynagrodzenie wynagrodzenie) {
        super(wiek, imie, nazwisko, pesel);
        this.wynagrodzenie = wynagrodzenie;
        this.ileLatPrzepracowane = ileLatPrzepracowane;
    }

    @Override
    public String toString(){
        return (super.toString() + "<br>" + " Wynagrodzenie: " + getWynagrodzenie()+ "<br>" + " Długość stażu: " + getIleLatPrzepracowane()+ " ");
    }


    public double getWynagrodzenie() {
        return wynagrodzenie.toStringWynagrodzenie();
    }

    public int getIleLatPrzepracowane() {
        return ileLatPrzepracowane;
    }

    public void setIleLatPrzepracowane(int ileLatPrzepracowane) {
        this.ileLatPrzepracowane = ileLatPrzepracowane;
    }


}
