package MainPage;

import Kursy.Kursy;
import Pracownik.PracownikNaukowoDydaktyczny;
import Pracownik.PracownikUczelni;
import UczelniaController.Controller;
import Student.Student;
import wynagrodzenieStrategy.Wynagrodzenie;
import wynagrodzenieStrategy.obliczWynagrodzeniePoStazu;
import wynagrodzenieStrategy.obliczWynagrodzeniePoTytyleNaukowym;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

class dodajOsobe extends JPanel implements ActionListener {
    private ArrayList<Kursy> dostepneKursy = new ArrayList<Kursy>();
    private Wynagrodzenie obliczWynagrodzenieStrategy;
    private JList<Kursy> listaKursowJList = new JList<>();
    private JButton dodajKursDoStudentaButton = new JButton("Dodaj wybrane kursy do studenta");
    private Frontend frontend;

    private JPanel kursyPanel = new JPanel();
    private JTextField nazwaKursuField = new JTextField("Wprowadź nazwę kursu");
    private JTextField wykladowcaField = new JTextField("WWprowadź wykładowcę");
    private JButton dodajKursButton = new JButton("Dodaj kurs");
    private CardLayout cardLayout = new CardLayout();

    private JPanel wiekPanel = new JPanel();

    private JPanel sredniaPanel = new JPanel();
    private JPanel imiePanel = new JPanel();
    private JPanel nazwiskoPanel = new JPanel();
    private JPanel kierunekPanel = new JPanel();
    private JPanel peselPanel = new JPanel();
    private JPanel indeksPanel = new JPanel();
    private JPanel semestrPanel = new JPanel();
    private JPanel wynagrodzeniePanel = new JPanel();
    private JPanel stanowiskoPanel = new JPanel();
    private JPanel tytulNaukowyPanel = new JPanel();
    private JPanel stazPanel = new JPanel();

    private JPanel studentPrzyciskPanel = new JPanel();
    private JPanel PUPrzyciskPanel = new JPanel();
    private JPanel PNDPrzyciskPanel = new JPanel();

    private JPanel contentPanel = new JPanel();
    private JPanel studentContentPanel = new JPanel();
    private JPanel PNDContentPanel = new JPanel();
    private JPanel PUContentPanel = new JPanel();
    private JLabel dodajOsobeTytul = new JLabel("Kogo chcesz dodać?");

    private JButton dodajStudentaPrzycisk = new JButton("Dodaj Studenta");
    private JButton dodajPNDPrzycisk = new JButton("Dodaj Pracownika Naukowo-Dydaktycznego");
    private JButton dodajPUPrzycisk = new JButton("Dodaj Pracownika Uczelni");
    private JButton StudentZatwierdzDodaniePrzycisk = new JButton("Zatwierdź");
    private JButton PUZatwierdzDodaniePrzycisk = new JButton("Zatwierdź");

    private JButton PNDZatwierdzDodaniePrzycisk = new JButton("Zatwierdź");

    private JButton wrocDoStronyGlownejPrzycisk = new JButton("Wroc");

    JTextField cwiczeniowiecField = new JTextField("Wprowadz Nauczyciela od cwiczen");

    private JPanel StrategiaPanel = new JPanel();
    JCheckBox StrategieCheckBox = new JCheckBox();
    JCheckBoxMenuItem poStazu = new JCheckBoxMenuItem("Oblicz wynagrodzenie po stażu");
    JCheckBoxMenuItem poTytule = new JCheckBoxMenuItem("Oblicz wynagrodzenie po tytule");



    private JLabel labelWiek = new JLabel("Wiek: ");
    private JLabel labelImie = new JLabel("Imię: ");
    private JLabel labelNazwisko = new JLabel("Nazwisko: ");
    private JLabel labelPesel = new JLabel("Pesel: ");
    private JLabel labelIndeks = new JLabel("Indeks: ");
    private JLabel labelKierunek = new JLabel("Kierunek: ");
    private JLabel labelSemestr = new JLabel("Semestr: ");
    private JLabel sredniaOcen = new JLabel("Średnia ocen: ");
    private JLabel labelWynagrodzenie = new JLabel("Wynagrodzenie: ");
    private JLabel labelStaz = new JLabel("Staż: ");
    private JLabel labelTytulNaukowy = new JLabel("Tytuł naukowy: ");
    private JLabel labelStanowisko = new JLabel("Stanowisko: ");


    private JTextField textFieldWiek = new JTextField();
    private DefaultListModel<Kursy> modelListyKursow = new DefaultListModel<>();

    private JTextField textFieldImie = new JTextField();
    private JTextField textFieldSrednia = new JTextField();
    private JTextField textFieldNazwisko = new JTextField();
    private JTextField textFieldPesel = new JTextField();
    private JTextField textFieldIndeks = new JTextField();
    private JTextField textFieldKierunek = new JTextField();
    private JTextField textFieldSemestr = new JTextField();
    private JTextField textFieldWynagrodzenie = new JTextField();
    private JTextField textFieldStaz = new JTextField();
    private JTextField textFieldTytulNaukowy = new JTextField();
    private JTextField textFieldStanowisko = new JTextField();

    private JList<Kursy> selectedKursyJList = new JList<>(modelListyKursow);


    public dodajOsobe(Frontend frontend) {

        setLayout(cardLayout);
        this.frontend = frontend;
        zaladujDostepneKursy();



        StudentZatwierdzDodaniePrzycisk.setPreferredSize(new Dimension(120, 30));
        PUZatwierdzDodaniePrzycisk.setPreferredSize(new Dimension(120, 30));
        PNDZatwierdzDodaniePrzycisk.setPreferredSize(new Dimension(120, 30));
        dodajKursButton.setPreferredSize(new Dimension(120, 30));
        wrocDoStronyGlownejPrzycisk.setPreferredSize(new Dimension(120, 30));

        dodajKursDoStudentaButton.addActionListener(this);
        StudentZatwierdzDodaniePrzycisk.addActionListener(this);
        PUZatwierdzDodaniePrzycisk.addActionListener(this);
        PNDZatwierdzDodaniePrzycisk.addActionListener(this);
        dodajKursButton.addActionListener(this);
        wrocDoStronyGlownejPrzycisk.addActionListener(this);
        StrategieCheckBox.addActionListener(this);

        StrategiaPanel.add(StrategieCheckBox);
        StrategieCheckBox.add(poStazu);
        StrategiaPanel.add(poTytule);


        studentPrzyciskPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        studentPrzyciskPanel.add(StudentZatwierdzDodaniePrzycisk);
        studentPrzyciskPanel.add(wrocDoStronyGlownejPrzycisk);

        PUPrzyciskPanel.setLayout(new BoxLayout(PUPrzyciskPanel, BoxLayout.X_AXIS));
        PUPrzyciskPanel.add(PUZatwierdzDodaniePrzycisk);
        PUPrzyciskPanel.add(wrocDoStronyGlownejPrzycisk);

        PNDPrzyciskPanel.setLayout(new BoxLayout(PNDPrzyciskPanel, BoxLayout.X_AXIS));
        PNDPrzyciskPanel.add(PNDZatwierdzDodaniePrzycisk);
        PNDPrzyciskPanel.add(wrocDoStronyGlownejPrzycisk);



        labelWiek.setPreferredSize(new Dimension(150, labelWiek.getPreferredSize().height));
        labelImie.setPreferredSize(new Dimension(150, labelImie.getPreferredSize().height));
        labelNazwisko.setPreferredSize(new Dimension(150, labelNazwisko.getPreferredSize().height));
        labelPesel.setPreferredSize(new Dimension(150, labelPesel.getPreferredSize().height));
        labelIndeks.setPreferredSize(new Dimension(150, labelIndeks.getPreferredSize().height));
        labelKierunek.setPreferredSize(new Dimension(150, labelKierunek.getPreferredSize().height));
        labelSemestr.setPreferredSize(new Dimension(150, labelSemestr.getPreferredSize().height));
        labelWynagrodzenie.setPreferredSize(new Dimension(150, labelWynagrodzenie.getPreferredSize().height));
        labelStaz.setPreferredSize(new Dimension(150, labelStaz.getPreferredSize().height));
        labelStanowisko.setPreferredSize(new Dimension(150, labelStanowisko.getPreferredSize().height));
        labelTytulNaukowy.setPreferredSize(new Dimension(150, labelTytulNaukowy.getPreferredSize().height));
        sredniaOcen.setPreferredSize(new Dimension(150, sredniaOcen.getPreferredSize().height));

// Ustaw pozostałe preferowane szerokości jak powyżej

        wiekPanel.setLayout(new BoxLayout(wiekPanel, BoxLayout.X_AXIS));
        imiePanel.setLayout(new BoxLayout(imiePanel, BoxLayout.X_AXIS));
        nazwiskoPanel.setLayout(new BoxLayout(nazwiskoPanel, BoxLayout.X_AXIS));
        peselPanel.setLayout(new BoxLayout(peselPanel, BoxLayout.X_AXIS));
        indeksPanel.setLayout(new BoxLayout(indeksPanel, BoxLayout.X_AXIS));
        kierunekPanel.setLayout(new BoxLayout(kierunekPanel, BoxLayout.X_AXIS));
        semestrPanel.setLayout(new BoxLayout(semestrPanel, BoxLayout.X_AXIS));
        wynagrodzeniePanel.setLayout(new BoxLayout(wynagrodzeniePanel, BoxLayout.X_AXIS));
        stazPanel.setLayout(new BoxLayout(stazPanel, BoxLayout.X_AXIS));
        stanowiskoPanel.setLayout(new BoxLayout(stanowiskoPanel, BoxLayout.X_AXIS));
        tytulNaukowyPanel.setLayout(new BoxLayout(tytulNaukowyPanel, BoxLayout.X_AXIS));
        sredniaPanel.setLayout(new BoxLayout(sredniaPanel, BoxLayout.X_AXIS));
// Dodaj pozostałe panele jak powyżej

// Tworzymy glue (przestrzeń elastyczną), aby rozciągnąć komponenty w danym BoxLayout
        wiekPanel.add(Box.createHorizontalGlue());
        imiePanel.add(Box.createHorizontalGlue());
        nazwiskoPanel.add(Box.createHorizontalGlue());
        peselPanel.add(Box.createHorizontalGlue());
        indeksPanel.add(Box.createHorizontalGlue());
        kierunekPanel.add(Box.createHorizontalGlue());
        semestrPanel.add(Box.createHorizontalGlue());
        wynagrodzeniePanel.add(Box.createHorizontalGlue());
        stazPanel.add(Box.createHorizontalGlue());
        stanowiskoPanel.add(Box.createHorizontalGlue());
        tytulNaukowyPanel.add(Box.createHorizontalGlue());
        sredniaPanel.add(Box.createHorizontalGlue());

// Dodaj labelWiek i textFieldWiek z odpowiednimi wagami
        wiekPanel.add(labelWiek);
        wiekPanel.add(textFieldWiek);
        wiekPanel.add(Box.createHorizontalGlue());

// Dodaj labelImie i textFieldImie z odpowiednimi wagami
        imiePanel.add(labelImie);
        imiePanel.add(textFieldImie);
        imiePanel.add(Box.createHorizontalGlue());

// Dodaj labelNazwisko i textFieldNazwisko z odpowiednimi wagami
        nazwiskoPanel.add(labelNazwisko);
        nazwiskoPanel.add(textFieldNazwisko);
        nazwiskoPanel.add(Box.createHorizontalGlue());

// Dodaj labelWiek i textFieldWiek z odpowiednimi wagami
        wiekPanel.add(labelWiek);
        wiekPanel.add(textFieldWiek);
        wiekPanel.add(Box.createHorizontalGlue());

// Dodaj labelNazwisko i textFieldNazwisko z odpowiednimi wagami
        nazwiskoPanel.add(labelNazwisko);
        nazwiskoPanel.add(textFieldNazwisko);
        nazwiskoPanel.add(Box.createHorizontalGlue());

        sredniaPanel.add(sredniaOcen);
        sredniaPanel.add(textFieldSrednia);
        sredniaPanel.add(Box.createHorizontalGlue());

        peselPanel.add(labelPesel);
        peselPanel.add(textFieldPesel);
        peselPanel.add(Box.createHorizontalGlue());

        indeksPanel.add(labelIndeks);
        indeksPanel.add(textFieldIndeks);
        indeksPanel.add(Box.createHorizontalGlue());

        kierunekPanel.add(labelKierunek);
        kierunekPanel.add(textFieldKierunek);
        kierunekPanel.add(Box.createHorizontalGlue());

        semestrPanel.add(labelSemestr);
        semestrPanel.add(textFieldSemestr);
        semestrPanel.add(Box.createHorizontalGlue());

        wynagrodzeniePanel.add(labelWynagrodzenie);
        wynagrodzeniePanel.add(textFieldWynagrodzenie);
        wynagrodzeniePanel.add(Box.createHorizontalGlue());

        stazPanel.add(labelStaz);
        stazPanel.add(textFieldStaz);
        stazPanel.add(Box.createHorizontalGlue());

        stanowiskoPanel.add(labelStanowisko);
        stanowiskoPanel.add(textFieldStanowisko);
        stanowiskoPanel.add(Box.createHorizontalGlue());

        tytulNaukowyPanel.add(labelTytulNaukowy);
        tytulNaukowyPanel.add(textFieldTytulNaukowy);
        tytulNaukowyPanel.add(Box.createHorizontalGlue());

        contentPanel.add(dodajOsobeTytul);
        contentPanel.add(dodajStudentaPrzycisk);
        contentPanel.add(dodajPNDPrzycisk);
        contentPanel.add(dodajPUPrzycisk);

        dodajStudentaPrzycisk.addActionListener(this);
        dodajPNDPrzycisk.addActionListener(this);
        dodajPUPrzycisk.addActionListener(this);

        kursyPanel.setLayout(new BoxLayout(kursyPanel, BoxLayout.X_AXIS));
        kursyPanel.add(new JLabel("Kursy:"));
        kursyPanel.add(nazwaKursuField);
        kursyPanel.add(wykladowcaField);
        kursyPanel.add(cwiczeniowiecField);
        kursyPanel.add(dodajKursButton);

        add(contentPanel, "stronaGlowna");
        add(studentContentPanel, "stronaStudenta");
        add(PNDContentPanel, "stronaPND");
        add(PUContentPanel, "stronaPU");

    }


    public void zaladujDostepneKursy() {
        ArrayList<Kursy> listaKursow = Controller.getKursy();
        modelListyKursow.clear();
        for (Kursy kurs : listaKursow) {
            modelListyKursow.addElement(kurs);
        }

    }

    private void aktualizujListeKursowStudenta() {
        listaKursowJList.setModel(modelListyKursow);
        revalidate();
        repaint();
        cardLayout.show(this, "stronaStudenta");
    }


    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == dodajKursButton) {
            Kursy kurs = new Kursy(nazwaKursuField.getText(), wykladowcaField.getText(), cwiczeniowiecField.getText());
            Controller.dodajKurs(kurs);
            zaladujDostepneKursy();
            aktualizujListeKursowStudenta();
            getParent().revalidate();
            getParent().repaint();
        }
        if (e.getSource() == StudentZatwierdzDodaniePrzycisk) {
            int wiek = Integer. parseInt(textFieldWiek.getText());
            String imie = textFieldImie.getText();
            String nazwisko = textFieldNazwisko.getText();
            String pesel = textFieldPesel.getText();
            String kierunek = textFieldKierunek.getText();
            int semestr = Integer.parseInt(textFieldSemestr.getText());
            int indeks = Integer.parseInt(textFieldIndeks.getText());
            float sredniaOcen = Float.parseFloat(textFieldSrednia.getText());




            Student student = new Student(wiek, imie, nazwisko, pesel, indeks, kierunek, semestr, sredniaOcen);
            ArrayList<Kursy> kursyDodane = new ArrayList<>();
            kursyDodane.addAll(listaKursowJList.getSelectedValuesList());

            for (Kursy kurs: kursyDodane){
                student.dodajKurs(kurs);
            }

            Controller.dodajStudenta(student);

            cardLayout.show(this, "stronaGlowna");


        }



        if (e.getSource() == PUZatwierdzDodaniePrzycisk) {
            int wiek = Integer.parseInt(textFieldWiek.getText());
            String imie = textFieldImie.getText();
            String nazwisko = textFieldNazwisko.getText();
            String pesel = textFieldPesel.getText();
            String stanowsiko = textFieldStanowisko.getText();
            int staz = Integer.parseInt(textFieldStaz.getText());
            obliczWynagrodzenieStrategy = new obliczWynagrodzeniePoStazu(staz);
            PracownikUczelni pU = new PracownikUczelni(wiek, imie, nazwisko, pesel, staz, stanowsiko, obliczWynagrodzenieStrategy);
            Controller.dodajPU(pU);
            cardLayout.show(this, "stronaGlowna");


        }
        if (e.getSource() == PNDZatwierdzDodaniePrzycisk) {
            int wiek = Integer.parseInt(textFieldWiek.getText());
            String imie = textFieldImie.getText();
            String nazwisko = textFieldNazwisko.getText();
            String pesel = textFieldPesel.getText();
            String tytulNaukowy = textFieldTytulNaukowy.getText();
            int staz = Integer.parseInt(textFieldStaz.getText());

            if (poStazu.isSelected()) {
                    obliczWynagrodzenieStrategy = new obliczWynagrodzeniePoStazu(staz);
            } else if (poTytule.isSelected()) {
                    obliczWynagrodzenieStrategy = new obliczWynagrodzeniePoTytyleNaukowym(tytulNaukowy);
            }



            PracownikNaukowoDydaktyczny PND = new PracownikNaukowoDydaktyczny(wiek, imie, nazwisko, pesel, staz, tytulNaukowy, obliczWynagrodzenieStrategy);
            Controller.dodajPND(PND);
            cardLayout.show(this, "stronaGlowna");


        }

        if (e.getSource() == dodajStudentaPrzycisk) {
            PUContentPanel.removeAll();
            PNDContentPanel.removeAll();
            studentContentPanel.removeAll();
            studentContentPanel.setLayout(new BoxLayout(studentContentPanel, BoxLayout.Y_AXIS));

            studentContentPanel.add(imiePanel);
            studentContentPanel.add(Box.createRigidArea(new Dimension(0, 5)));  // Ruchoma przestrzeń 5 pikseli
            studentContentPanel.add(nazwiskoPanel);
            studentContentPanel.add(Box.createRigidArea(new Dimension(0, 5)));
            studentContentPanel.add(peselPanel);
            studentContentPanel.add(Box.createRigidArea(new Dimension(0, 5)));
            studentContentPanel.add(indeksPanel);
            studentContentPanel.add(Box.createRigidArea(new Dimension(0, 5)));
            studentContentPanel.add(kierunekPanel);
            studentContentPanel.add(Box.createRigidArea(new Dimension(0, 5)));
            studentContentPanel.add(semestrPanel);
            studentContentPanel.add(Box.createRigidArea(new Dimension(0, 5)));
            studentContentPanel.add(sredniaPanel);
            studentContentPanel.add(Box.createRigidArea(new Dimension(0, 5)));
            studentContentPanel.add(wiekPanel);
            studentContentPanel.add(Box.createRigidArea(new Dimension(0, 15)));  // Większa przestrzeń między sekcjami

            studentContentPanel.add(kursyPanel);
            studentContentPanel.add(Box.createRigidArea(new Dimension(0, 5)));
            studentContentPanel.add(new JScrollPane(listaKursowJList));
            studentContentPanel.add(Box.createRigidArea(new Dimension(0, 15)));

            studentContentPanel.add(studentPrzyciskPanel);
            studentContentPanel.add(Box.createRigidArea(new Dimension(0, 5)));
            studentContentPanel.add(wrocDoStronyGlownejPrzycisk);

            cardLayout.show(this, "stronaStudenta");

            aktualizujListeKursowStudenta();
        }
        if (e.getSource() == dodajPNDPrzycisk) {
            PUContentPanel.removeAll();
            PNDContentPanel.removeAll();
            studentContentPanel.removeAll();

            PNDContentPanel.setLayout(new BoxLayout(PNDContentPanel, BoxLayout.Y_AXIS));

            PNDContentPanel.add(wiekPanel);
            PNDContentPanel.add(Box.createRigidArea(new Dimension(0, 5)));
            PNDContentPanel.add(imiePanel);
            PNDContentPanel.add(Box.createRigidArea(new Dimension(0, 5)));
            PNDContentPanel.add(nazwiskoPanel);
            PNDContentPanel.add(Box.createRigidArea(new Dimension(0, 5)));
            PNDContentPanel.add(peselPanel);
            PNDContentPanel.add(Box.createRigidArea(new Dimension(0, 5)));
            PNDContentPanel.add(stazPanel);
            PNDContentPanel.add(Box.createRigidArea(new Dimension(0, 5)));
            PNDContentPanel.add(tytulNaukowyPanel);
            PNDContentPanel.add(Box.createRigidArea(new Dimension(0, 5)));
            PNDContentPanel.add(PNDPrzyciskPanel);
            PNDContentPanel.add(Box.createRigidArea(new Dimension(0, 5)));
            PNDContentPanel.add(StrategiaPanel);
            PNDContentPanel.add(Box.createRigidArea(new Dimension(0, 5)));
            PNDContentPanel.add(wrocDoStronyGlownejPrzycisk);

            cardLayout.show(this, "stronaPND");

            // Dodaj inne operacje, jeśli są wymagane
        }
        if (e.getSource() == dodajPUPrzycisk) {
            PUContentPanel.removeAll();
            PNDContentPanel.removeAll();
            studentContentPanel.removeAll();

            PUContentPanel.setLayout(new BoxLayout(PUContentPanel, BoxLayout.Y_AXIS));

            PUContentPanel.add(wiekPanel);
            PUContentPanel.add(Box.createRigidArea(new Dimension(0, 5)));
            PUContentPanel.add(imiePanel);
            PUContentPanel.add(Box.createRigidArea(new Dimension(0, 5)));
            PUContentPanel.add(nazwiskoPanel);
            PUContentPanel.add(Box.createRigidArea(new Dimension(0, 5)));
            PUContentPanel.add(peselPanel);
            PUContentPanel.add(Box.createRigidArea(new Dimension(0, 5)));
            PUContentPanel.add(stazPanel);
            PUContentPanel.add(Box.createRigidArea(new Dimension(0, 5)));
            PUContentPanel.add(stanowiskoPanel);
            PUContentPanel.add(Box.createRigidArea(new Dimension(0, 5)));
            PUContentPanel.add(PUPrzyciskPanel);
            PUContentPanel.add(Box.createRigidArea(new Dimension(0, 5)));
            PUContentPanel.add(wrocDoStronyGlownejPrzycisk);

            cardLayout.show(this, "stronaPU");


        }
        if (e.getSource() == wrocDoStronyGlownejPrzycisk) {
            cardLayout.show(this, "stronaGlowna");
        }
    }

}



