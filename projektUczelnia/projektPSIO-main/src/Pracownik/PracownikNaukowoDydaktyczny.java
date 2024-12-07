package Pracownik;

import wynagrodzenieStrategy.Wynagrodzenie;

public class PracownikNaukowoDydaktyczny extends Pracownik{
    private String tytulNaukowy;


    public PracownikNaukowoDydaktyczny(int wiek, String imie, String nazwisko, String pesel, int ileLatPrzepracowane, String tytulNaukowy, Wynagrodzenie wynagrodzenie) {
        super(wiek, imie, nazwisko, pesel, ileLatPrzepracowane, wynagrodzenie);
        this.tytulNaukowy = tytulNaukowy;

    }

    @Override
    public String toString(){
        return (super.toString() + "<br>" + "Tytul naukowy: " + getTytulNaukowy());
    }


    public String getTytulNaukowy() {
        return tytulNaukowy;
    }

    public void setTytulNaukowy(String tytulNaukowy) {
        this.tytulNaukowy = tytulNaukowy;
    }




}
