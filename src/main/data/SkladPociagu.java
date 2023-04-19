package main.data;

import main.data.wagony.Wagon;
import main.wyjatki.RailroadHazard;
import main.wątki.KalkulatorPredkosci;
import main.wątki.WyszukiwarkaTrasy;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class SkladPociagu {

    private final Lokomotywa lokomotywa;
    private final List<Wagon> wagony;
    private volatile double predkosc;
    private final KalkulatorPredkosci kalkulatorPredkosci;
    private final WyszukiwarkaTrasy wyszukiwarkaTrasy;

    public SkladPociagu(Lokomotywa lokomotywa, List<Wagon> wagony, double predkosc) {
        this.lokomotywa = lokomotywa;
        this.wagony = wagony;
        this.predkosc = predkosc;
        this.kalkulatorPredkosci = new KalkulatorPredkosci(this);
        this.wyszukiwarkaTrasy = new WyszukiwarkaTrasy();
    }

    public Lokomotywa getLokomotywa() {
        return lokomotywa;
    }

    public List<Wagon> getWagony() {
        return wagony;
    }

    public double getPredkosc() {
        return predkosc;
    }

    public void setPredkosc(double predkosc) {
        this.predkosc = predkosc;
    }

    public KalkulatorPredkosci getKalkulatorPredkosci() {
        return kalkulatorPredkosci;
    }

    public WyszukiwarkaTrasy getWyszukiwarkaTrasy() {
        return wyszukiwarkaTrasy;
    }
}
