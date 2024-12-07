package Student;

import Kursy.Kursy;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class StudentTest {

    @Test
    void testDodajKurs() {
        Student student = new Student(1,"1","1","1",1,"1",1,1); // Zastąp TwojaKlasa nazwą rzeczywistej klasy, w której znajduje się metoda dodajKurs
        Kursy kurs = new Kursy("Programowanie", "Jan Kowalski", "Marek");
        student.dodajKurs(kurs);
        ArrayList<Kursy> listaKursow = student.getListaKursow();
        System.out.println(listaKursow);
        System.out.println(kurs);
        assertEquals(kurs.toString(),listaKursow.get(0).toString());
    }
}