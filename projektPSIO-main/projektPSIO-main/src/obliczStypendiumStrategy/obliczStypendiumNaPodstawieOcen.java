package obliczStypendiumStrategy;

import java.io.Serializable;

public class obliczStypendiumNaPodstawieOcen implements Stypendium,Serializable{
    private float sredniaOcen;
    public obliczStypendiumNaPodstawieOcen(float sredniaOcen){
        this.sredniaOcen=sredniaOcen;
    }

    public int obliczStypendiumnaPodstawieOcenMetoda(float sredniaOcen) {
        if (sredniaOcen > 5.0)
            return 2000;
        if (sredniaOcen > 4.5)
            return 1200;
        if (sredniaOcen > 4.2)
            return 1000;
        else
            return 0;
    }

    @Override
    public int obliczStypendium() {
        return obliczStypendiumnaPodstawieOcenMetoda(sredniaOcen);
    }

    @Override
    public String toStringStypendium() {
        return obliczStypendium() + " zł";
    }
}
