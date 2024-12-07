package wynagrodzenieStrategy;

public class obliczWynagrodzeniePoTytyleNaukowym implements Wynagrodzenie {
    private String tytul_naukowy;

    public obliczWynagrodzeniePoTytyleNaukowym(String tytul_naukowy){
        this.tytul_naukowy=tytul_naukowy;
    }

    public int obliczWynagrodzeniePoTytyleNaukowymMetoda(String tytul_naukowy){
        if (tytul_naukowy.equals("doktor")){
            return 6000;
        }
        if (tytul_naukowy.equals("doktor habilitowany")){
            return 9000;
        }
        if (tytul_naukowy.equals("profesor")){
            return 12000;
        }
        else {
            return 0;
        }
    }

    @Override
    public int obliczWynagrodzenie() {
        return obliczWynagrodzeniePoTytyleNaukowymMetoda(tytul_naukowy);
    }

    @Override
    public int toStringWynagrodzenie() {
        return obliczWynagrodzenie();
    }
}
