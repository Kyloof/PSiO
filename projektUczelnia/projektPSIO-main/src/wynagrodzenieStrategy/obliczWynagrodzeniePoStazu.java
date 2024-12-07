package wynagrodzenieStrategy;

import java.io.Serializable;

public class obliczWynagrodzeniePoStazu implements Wynagrodzenie, Serializable {
    private int dlugoscStazu;
    public obliczWynagrodzeniePoStazu(int dlugoscStazu){
        this.dlugoscStazu = dlugoscStazu;
    }

    public int obliczWynagrodzenieNaPodstawieStazuMetoda(int dlugoscStazu){
        if (dlugoscStazu > 10){
            return 10000;
        }
        if (dlugoscStazu > 5 ){
            return 7000;
        }
        if (dlugoscStazu > 2){
            return 6000;
        }
        else
            return 5000;

    }
    @Override
    public int obliczWynagrodzenie() {
        return obliczWynagrodzenieNaPodstawieStazuMetoda(dlugoscStazu);
    }

    @Override
    public int toStringWynagrodzenie() {
        return obliczWynagrodzenie();
    }
}

