package MainPage;

import Osoba.Osoba;
import Pracownik.PracownikNaukowoDydaktyczny;
import Pracownik.PracownikUczelni;
import UczelniaController.Controller;
import UczelniaController.Serializacja;
import Student.Student;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Frontend extends JFrame implements ActionListener {

    private JLabel titleLabel = new JLabel("Politechnika Wrocławska");

    private JButton saveButton = new JButton("Zapisz");
    private JButton loadButton = new JButton("Odczytaj");
    private JButton wyszukajStudentaButton = new JButton("Wyszukaj Studenta");
    private JButton wyszukajPracownikowButton = new JButton("Wyszukaj Pracowników");
    private JButton wyszukajPracownikaAdminButton = new JButton("Wyszukaj Pracownika Administracyjnego");

    private CardLayout cardLayout = new CardLayout();
    private JPanel mainPage = new JPanel(cardLayout);
    private JList<String> listaOsobJList = new JList<>();
    private JPanel functionalityPage = new JPanel();
    private JPanel showPeoplePage = new JPanel();
    private JPanel NazwyOsobPanel = new JPanel();

    private JLabel LStudent = new JLabel("Student");
    private JLabel LPracownikNaukowoDydaktyczny = new JLabel("Pracownik Naukowo-Dydaktyczny");
    private JLabel LPracownikUczelni = new JLabel("Pracownik Uczelni");
    private JPanel addPersonPage = new JPanel();
    private JPanel pokazOsobyPanel = new JPanel();

    private JButton addPersonButton = new JButton("Dodaj osobę");
    private JButton showPeopleButton = new JButton("Wyswietl osoby");
    private JButton functionalityButton = new JButton("Wejdź do funkcji");

    private JTextField studentIndexField = new JTextField("Wprowadź indeks");
    private JTextField employeeJobField = new JTextField("Wprowadź pracę");
    private JTextField paycheckField = new JTextField("Wprowadź zarobki");

    public Frontend() {



        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS)); // Set layout manager

        JPanel titlePanel = new JPanel();
        titlePanel.add(titleLabel);
        add(titlePanel);

        JPanel buttonPanel = createButtonPanel();
        add(buttonPanel);

        add(mainPage);

        NazwyOsobPanel.add(LStudent);
        NazwyOsobPanel.add(LPracownikNaukowoDydaktyczny);
        NazwyOsobPanel.add(LPracownikUczelni);

        JPanel functionalityButtonPanel = new JPanel();
        functionalityButtonPanel.setLayout(new BoxLayout(functionalityButtonPanel, BoxLayout.Y_AXIS));
        wyszukajPracownikaAdminButton.setPreferredSize(new Dimension(300, 100));
        wyszukajStudentaButton.setPreferredSize(new Dimension(300, 100));
        wyszukajPracownikowButton.setPreferredSize(new Dimension(300, 100));
        functionalityButtonPanel.add(wyszukajPracownikowButton);
        functionalityButtonPanel.add(wyszukajStudentaButton);
        functionalityButtonPanel.add(wyszukajPracownikaAdminButton);
        functionalityButtonPanel.setPreferredSize(new Dimension(300, 500)); // Ustaw preferowaną szerokość kolumny przycisków

        JPanel functionalyTextPanel = new JPanel(new GridBagLayout());
        functionalyTextPanel.setPreferredSize(new Dimension(300, 300)); // Zwiększ preferowaną szerokość kolumny pól tekstowych

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 5, 5, 5);

        gbc.gridx = 0;
        gbc.gridy = 0;
        studentIndexField.setPreferredSize(new Dimension(200, 30));
        functionalyTextPanel.add(studentIndexField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        employeeJobField.setPreferredSize(new Dimension(200, 30));
        functionalyTextPanel.add(employeeJobField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        paycheckField.setPreferredSize(new Dimension(200, 30));
        functionalyTextPanel.add(paycheckField, gbc);

        functionalityPage.setLayout(new BoxLayout(functionalityPage, BoxLayout.X_AXIS));
        functionalityPage.add(functionalityButtonPanel);
        functionalityPage.add(functionalyTextPanel);

        dodajOsobe addPersonPage = new dodajOsobe(this);
        mainPage.add(addPersonPage, "DodajOsobe");
        mainPage.add(pokazOsobyPanel, "PokazOsoby");
        mainPage.add(functionalityPage, "Wejdź do funkcji");

        titleLabel.setForeground(Color.BLUE);
        titleLabel.setBackground(Color.LIGHT_GRAY);
        titleLabel.setOpaque(true);

        saveButton.setBackground(Color.GREEN);
        loadButton.setBackground(Color.GREEN);
        wyszukajStudentaButton.setBackground(Color.YELLOW);
        wyszukajPracownikowButton.setBackground(Color.YELLOW);
        wyszukajPracownikaAdminButton.setBackground(Color.YELLOW);
        addPersonButton.setBackground(Color.ORANGE);
        showPeopleButton.setBackground(Color.ORANGE);
        functionalityButton.setBackground(Color.ORANGE);

        mainPage.setBackground(Color.WHITE);
        addPersonPage.setBackground(Color.WHITE);
        showPeoplePage.setBackground(Color.WHITE);
        functionalityPage.setBackground(Color.WHITE);
        pokazOsobyPanel.setBackground(Color.WHITE);

        pokazOsobyPanel.setLayout(new BoxLayout(pokazOsobyPanel, BoxLayout.X_AXIS));
        studentIndexField.setBackground(Color.LIGHT_GRAY);
        employeeJobField.setBackground(Color.LIGHT_GRAY);
        paycheckField.setBackground(Color.LIGHT_GRAY);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(500, 500));
        pack();
        setLocationByPlatform(true);
        setVisible(true);
    }

    private JPanel createButtonPanel() {
        saveButton.addActionListener(this);
        loadButton.addActionListener(this);
        wyszukajStudentaButton.addActionListener(this);
        wyszukajPracownikowButton.addActionListener(this);
        wyszukajPracownikaAdminButton.addActionListener(this);
        addPersonButton.addActionListener(this);
        showPeopleButton.addActionListener(this);
        functionalityButton.addActionListener(this);

        JPanel saveLoadPanel = new JPanel();
        saveLoadPanel.add(saveButton);
        saveLoadPanel.add(loadButton);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(saveLoadPanel);
        buttonPanel.add(addPersonButton);
        buttonPanel.add(showPeopleButton);
        buttonPanel.add(functionalityButton);

        return buttonPanel;
    }


    public void Start() {
        cardLayout.show(mainPage, "Strona Glowna");
    }

    private void pokazListeOsob() {
        ArrayList<Osoba> listaOsob = Controller.getListaOsob();

        JLabel LStudent = new JLabel("Studenci:");
        LStudent.setFont(new Font("Arial", Font.BOLD, 16));
        LStudent.setForeground(Color.BLUE);

        JLabel LPracownikNaukowoDydaktyczny = new JLabel("Pracownicy Naukowo-Dydaktyczni:");
        LPracownikNaukowoDydaktyczny.setFont(new Font("Arial", Font.BOLD, 16));
        LPracownikNaukowoDydaktyczny.setForeground(Color.RED);

        JLabel LPracownikUczelni = new JLabel("Pracownicy Uczelni:");
        LPracownikUczelni.setFont(new Font("Arial", Font.BOLD, 16));
        LPracownikUczelni.setForeground(Color.GREEN);

        JPanel studentPanel = new JPanel();
        studentPanel.setLayout(new BoxLayout(studentPanel, BoxLayout.Y_AXIS));
        studentPanel.add(LStudent);

        JPanel pndPanel = new JPanel();
        pndPanel.setLayout(new BoxLayout(pndPanel, BoxLayout.Y_AXIS));
        pndPanel.add(LPracownikNaukowoDydaktyczny);

        JPanel puPanel = new JPanel();
        puPanel.setLayout(new BoxLayout(puPanel, BoxLayout.Y_AXIS));
        puPanel.add(LPracownikUczelni);

        for (Osoba osoba : listaOsob) {
            if (osoba instanceof Student) {
                JLabel studentLabel = new JLabel();
                studentLabel.setFont(new Font("Arial", Font.PLAIN, 14));  // Ustawienie rozmiaru czcionki dla danych osobowych
                studentLabel.setText("<html>" + ((Student) osoba).toString().replace("<br>", "<br/>") + "<br>" + "</html>");
                studentPanel.add(studentLabel);
            } else if (osoba instanceof PracownikUczelni) {
                JLabel puLabel = new JLabel();
                puLabel.setFont(new Font("Arial", Font.PLAIN, 14));
                puLabel.setText("<html>" + ((PracownikUczelni) osoba).toString().replace("<br>", "<br/>") + "<br>" + "</html>");
                puPanel.add(puLabel);
            } else if (osoba instanceof PracownikNaukowoDydaktyczny) {
                JLabel pndLabel = new JLabel();
                pndLabel.setFont(new Font("Arial", Font.PLAIN, 14));
                pndLabel.setText("<html>" + ((PracownikNaukowoDydaktyczny) osoba).toString().replace("<br>", "<br/>") + "<br>" + "</html>");
                pndPanel.add(pndLabel);
            }
        }

        JScrollPane studentScrollPane = new JScrollPane();
        studentScrollPane.setViewportView(studentPanel);

        JScrollPane pndScrollPane = new JScrollPane();
        pndScrollPane.setViewportView(pndPanel);

        JScrollPane puScrollPane = new JScrollPane();
        puScrollPane.setViewportView(puPanel);

        pokazOsobyPanel.removeAll();
        pokazOsobyPanel.add(studentScrollPane);
        pokazOsobyPanel.add(pndScrollPane);
        pokazOsobyPanel.add(puScrollPane);

        pokazOsobyPanel.revalidate();
        pokazOsobyPanel.repaint();
    }


    private void wyswietlWynikiWyszukiwania(String wyniki) {
        JLabel label = new JLabel(wyniki);
        pokazOsobyPanel.removeAll();
        pokazOsobyPanel.add(label);
        pokazOsobyPanel.revalidate();
        pokazOsobyPanel.repaint();
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == saveButton) {
            Serializacja.zapis(Controller.getListaOsob(), "baza.ser");
            Serializacja.zapisKurs(Controller.getListaKursow(), "bazaKursow.ser");

        } else if (e.getSource() == loadButton) {
            Serializacja.odczyt("baza.ser");
            Serializacja.odczytKurs("bazaKursow.ser");
        }
        if (e.getSource() == wyszukajStudentaButton) {
            int numerIndeksu = Integer.parseInt(studentIndexField.getText());
            String result = Controller.wyszukajStudentaPoNumerzeIndeksu(numerIndeksu);
            wyswietlWynikiWyszukiwania(result);
            cardLayout.show(mainPage, "PokazOsoby");
        }

        if (e.getSource() == wyszukajPracownikowButton) {
            double zarobki = Double.parseDouble(paycheckField.getText());
            String result = Controller.wyszukajPracownikowUczelniPoZarobkach(zarobki);
            wyswietlWynikiWyszukiwania(result);
            cardLayout.show(mainPage, "PokazOsoby");
        }

        if (e.getSource() == wyszukajPracownikaAdminButton) {
            String stanowisko = employeeJobField.getText();
            String result = Controller.wyszukajPracownikaAdministracyjnegoPoStanowisku(stanowisko);
            wyswietlWynikiWyszukiwania(result);
            cardLayout.show(mainPage, "PokazOsoby");
        }

        if (e.getSource() == addPersonButton) {
            cardLayout.show(mainPage, "DodajOsobe");
        }

        if (e.getSource() == showPeopleButton) {
            pokazListeOsob();
            cardLayout.show(mainPage,"PokazOsoby");
        }

        if (e.getSource() == functionalityButton) {
            cardLayout.show(mainPage, "Wejdź do funkcji");
        }
    }
}

