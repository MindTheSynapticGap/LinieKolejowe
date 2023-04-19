import main.data.Lokomotywa;
import main.data.SkladPociagu;
import main.data.stacje.Graf;
import main.data.stacje.Stacja;
import main.data.stacje.Util;
import main.wątki.KalkulatorPredkosci;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Util.przygotujGraf();

        Lokomotywa lokomotywa = new Lokomotywa(2, 2, 2, "dupa", null, null, null, 100);
        SkladPociagu skladPociagu = new SkladPociagu(lokomotywa, null, 100);
        KalkulatorPredkosci kalkulatorPredkosci = new KalkulatorPredkosci(skladPociagu);

        //KalkulatorTrasy kalkulatorTrasy = new KalkulatorTrasy(trasy.get(0));
       // kalkulatorTrasy.setSkladPociagu(skladPociagu);

        //kalkulatorTrasy.start();
        //kalkulatorPredkosci.start();
    }

}
