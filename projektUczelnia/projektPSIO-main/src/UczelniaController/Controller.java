package UczelniaController;

import Kursy.Kursy;
import Osoba.Osoba;
import Pracownik.*;
import Student.Student;


import java.util.ArrayList;

public class Controller {
    private static ArrayList<Osoba> listaOsob = new ArrayList<Osoba>();

    private static ArrayList<Kursy> listaKursow = new ArrayList<Kursy>();


    public static String wyszukajStudentaPoNumerzeIndeksu(int numerIndeksu) {
        StringBuilder stringBuilder = new StringBuilder("<html><body>");

        for (Osoba osoba : getListaOsob()) {
            if (osoba instanceof Student) {
                Student student = (Student) osoba;
                if (student.getIndeks() == numerIndeksu) {
                    stringBuilder.append(student.toString()).append("<br>");
                }
            }
        }

        stringBuilder.append("</body></html>");
        return stringBuilder.toString();
    }

    public static String wyszukajPracownikowUczelniPoZarobkach(double vT) {
        StringBuilder stringBuilder = new StringBuilder("<html><body>");

        for (Osoba osoba : getListaOsob()) {
            if (osoba instanceof Pracownik) {
                Pracownik pracownik = (Pracownik) osoba;
                if (pracownik.getWynagrodzenie() > vT) {
                    stringBuilder.append(pracownik.toString()).append("<br>");
                }
            }
        }

        stringBuilder.append("</body></html>");
        return stringBuilder.toString();
    }

    public static String wyszukajPracownikaAdministracyjnegoPoStanowisku(String szukaneStanowisko) {
        StringBuilder stringBuilder = new StringBuilder("<html><body>");

        for (Osoba osoba : getListaOsob()) {
            if (osoba instanceof PracownikUczelni) {
                PracownikUczelni pracownik = (PracownikUczelni) osoba;
                if (pracownik.getStanowisko().equals(szukaneStanowisko)) {
                    stringBuilder.append(pracownik.toString()).append("<br>");
                }
            }
        }

        stringBuilder.append("</body></html>");
        return stringBuilder.toString();
    }


    public static void dodajStudenta(Student nowyStudent) {
        int n = nowyStudent.getListaKursow().size();
        NiepoprawnaLiczbaKursow.ZlaLiczbaKursow(n);
        if (n != 0) {
            getListaOsob().add(nowyStudent);
        }
    }
    public static void dodajPU(PracownikUczelni pU) {
        getListaOsob().add(pU);
    }
    public static void dodajPND(PracownikNaukowoDydaktyczny PND) {
        getListaOsob().add(PND);
    }

    public static void dodajKurs(Kursy kurs){
        getListaKursow().add(kurs);
    }
    public static ArrayList<Kursy> getKursy(){
        return getListaKursow();
    }

    /*public static void wyswietlListeOsob() {
        for (int i = 0; i < listaOsob.size(); i++) {
            listaOsob.get(i).getStan();
        }
    }*/

    public static ArrayList<Osoba> getListaOsob() {
        return listaOsob;
    }

    public static void setListaOsob(ArrayList<Osoba> listaOsob) {
        Controller.listaOsob = listaOsob;
    }

    public static ArrayList<Kursy> getListaKursow() {
        return listaKursow;
    }

    public static void setListaKursow(ArrayList<Kursy> listaKursow) {
        Controller.listaKursow = listaKursow;
    }
}





