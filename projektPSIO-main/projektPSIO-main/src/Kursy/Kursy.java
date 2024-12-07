package Kursy;

import java.io.Serializable;

public class Kursy implements Serializable{
    private String nazwaKursu;
    private String wykladowca;
    private String cwiczeniowiec;

    public Kursy(String nazwaKursu, String wykladowca, String cwiczeniowiec){
        this.nazwaKursu = nazwaKursu;
        this.wykladowca = wykladowca;
        this.cwiczeniowiec = cwiczeniowiec;
    }

    @Override
    public String toString(){
        return "Nazwa kursu: " + getNazwaKursu() + " Wykladowca: " + getWykladowca() + " Cwiczeniowiec: " + getCwiczeniowiec();
    }
    public String getNazwaKursu() {
        return nazwaKursu;
    }

    public void setNazwaKursu(String nazwaKursu) {
        this.nazwaKursu = nazwaKursu;
    }

    public String getWykladowca() {
        return wykladowca;
    }

    public void setWykladowca(String wykladowca) {
        this.wykladowca = wykladowca;
    }

    public String getCwiczeniowiec() {
        return cwiczeniowiec;
    }

    public void setCwiczeniowiec(String cwiczeniowiec) {
        this.cwiczeniowiec = cwiczeniowiec;
    }
}
