package UczelniaController;

public class Wyjatki {
}
class NiepoprawnaLiczbaKursow extends Exception {
    public NiepoprawnaLiczbaKursow(String wiadomosc) {
        super(wiadomosc);
    }


    public static void ZlaLiczbaKursow(int n) {
        try {
            Metoda1(n);
        } catch (NiepoprawnaLiczbaKursow e) {
            e.printStackTrace();
        }
    }

    public static void Metoda1(int n) throws NiepoprawnaLiczbaKursow {
        if (n == 0) throw new NiepoprawnaLiczbaKursow("Student nie może nie uczestniczyć w żadnym kursie");
    }
}

