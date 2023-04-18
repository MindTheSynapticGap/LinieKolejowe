package main.data;

import main.data.wagony.Wagon;
import main.wyjatki.RailroadHazard;
import main.wątki.KalkulatorPredkosci;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class SkladPociagu {

    private Lokomotywa lokomotywa;
    private final List<Wagon> wagony;
    private double predkosc;
    private final KalkulatorPredkosci kalkulatorPredkosci;

    public SkladPociagu(Lokomotywa lokomotywa, List<Wagon> wagony) {
        this.lokomotywa = lokomotywa;
        this.wagony = wagony;
        this.predkosc = lokomotywa.getPoczatkowaPredkosc();
        this.kalkulatorPredkosci = new KalkulatorPredkosci(this);
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
}
