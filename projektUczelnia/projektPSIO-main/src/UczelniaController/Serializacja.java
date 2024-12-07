package UczelniaController;

import Kursy.Kursy;
import Osoba.Osoba;

import java.io.*;
import java.util.ArrayList;

public class Serializacja {
    public static void zapis(ArrayList<Osoba> listaOsob, String nazwaPliku) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(nazwaPliku))) {
            outputStream.writeObject(listaOsob);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void zapisKurs(ArrayList<Kursy> listaKursow, String nazwaPliku) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(nazwaPliku))) {
            outputStream.writeObject(listaKursow);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void odczyt(String nazwaPliku) {
        ArrayList<Osoba> listaOsobOdczytana = null;
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(nazwaPliku))) {
            listaOsobOdczytana = (ArrayList<Osoba>) inputStream.readObject();
            Controller.setListaOsob(listaOsobOdczytana);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void odczytKurs(String nazwaPliku) {
        ArrayList<Kursy> listaKursowOdczytana = null;
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(nazwaPliku))) {
            listaKursowOdczytana = (ArrayList<Kursy>) inputStream.readObject();
            Controller.setListaKursow(listaKursowOdczytana);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }


    }
}

