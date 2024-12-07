package Student;

import Osoba.Osoba;
import Kursy.Kursy;
import obliczStypendiumStrategy.Stypendium;
import obliczStypendiumStrategy.obliczStypendiumNaPodstawieOcen;

import java.util.ArrayList;

public class Student extends Osoba {
    private int indeks;
    private float sredniaOcen;
    private String kierunek;
    private int ktorySemestr;
    private Stypendium stypendium;
    private ArrayList<Kursy> listaKursow = new ArrayList<Kursy>();


    public Student(int wiek, String imie, String nazwisko, String pesel, int indeks, String kierunek, int ktorySemestr, float sredniaOcen) {
        super(wiek, imie, nazwisko, pesel);
        this.indeks = indeks;
        this.kierunek = kierunek;
        this.ktorySemestr = ktorySemestr;
        this.sredniaOcen = sredniaOcen;
        this.stypendium = new obliczStypendiumNaPodstawieOcen(sredniaOcen);

    }


    public void dodajKurs(Kursy kurs) {
        Kursy nowyKurs = new Kursy(kurs.getNazwaKursu(), kurs.getWykladowca(), kurs.getCwiczeniowiec());
        getListaKursow().add(nowyKurs);
    }



    public String getStypendium(){
        return stypendium.toStringStypendium();
    }
    @Override
    public String toString(){
        return (super.toString() + "<br>"+ " indeks: "  + getIndeks() + "<br>" + "Kierunek: " + getKierunek() + "<br>" + "Semestr: " + getKtorySemestr() + "<br>" + "Stypendium" + getStypendium() + "<br>" + wyswietlKursy());
    }


    public double getSredniaOcen(){
        return sredniaOcen;
    }

    public String wyswietlKursy() {
        String kursy = "";
        for (int i = 0; i < getListaKursow().size(); i++) {
            kursy += "Kurs: " + getListaKursow().get(i).getNazwaKursu()+ "<br>" + " Wykładowca: " + getListaKursow().get(i).getWykladowca() + "<br>"+ " Cwiczeniowiec: " + getListaKursow().get(i).getCwiczeniowiec() + "<br>";
        }
        return kursy;

    }

    public int getIndeks() {
        return indeks;
    }

    public void setIndeks(int indeks) {
        this.indeks = indeks;
    }

    public String getKierunek() {
        return kierunek;
    }

    public void setKierunek(String kierunek) {
        this.kierunek = kierunek;
    }

    public int getKtorySemestr() {
        return ktorySemestr;
    }

    public void setKtorySemestr(int ktorySemestr) {
        this.ktorySemestr = ktorySemestr;
    }

    public ArrayList<Kursy> getListaKursow() {
        return listaKursow;
    }
}
