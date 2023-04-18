import main.data.Lokomotywa;
import main.data.SkladPociagu;
import main.data.stacje.Graf;
import main.data.stacje.Stacja;
import main.data.stacje.Trasa;
import main.wątki.KalkulatorPredkosci;
import main.wątki.KalkulatorTrasy;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Stacja> stacje = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            stacje.add(new Stacja(i, (int) Math.floor(Math.random() * 100)));
        }

        List<Trasa> trasy = new ArrayList<>();

        for (int i = 0; i < stacje.size(); i++) {
            trasy.add(new Trasa(stacje.get((int) Math.floor(Math.random() * 100)), stacje.get((int) Math.floor(Math.random() * 100)), (int) Math.floor(Math.random() * 100)));
        }

        Graf graf = new Graf(trasy);

        Graf.wydrukujGraf(graf);

        Lokomotywa lokomotywa = new Lokomotywa(2, 2, 2, "dupa", null, null, null, 100);
        SkladPociagu skladPociagu = new SkladPociagu(lokomotywa, null);
        KalkulatorPredkosci kalkulatorPredkosci = new KalkulatorPredkosci(skladPociagu);
        kalkulatorPredkosci.start();

        KalkulatorTrasy kalkulatorTrasy = new KalkulatorTrasy(trasy.get(0));
        kalkulatorTrasy.setSkladPociagu(skladPociagu);
        kalkulatorTrasy.start();
    }

}
