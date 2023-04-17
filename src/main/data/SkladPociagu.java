package main.data;

import main.data.wagony.Wagon;

import java.util.List;

public class SkladPociagu {
    private Lokomotywa lokomotywa;
    private List<Wagon> wagony;
    private int predkosc;

    public SkladPociagu(Lokomotywa lokomotywa, List<Wagon> wagony, int predkosc) {
        this.lokomotywa = lokomotywa;
        this.wagony = wagony;
        this.predkosc = lokomotywa.getPredkosc();
    }

    public Lokomotywa getLokomotywa() {
        return lokomotywa;
    }

    public List<Wagon> getWagony() {
        return wagony;
    }

    public int getPredkosc() {
        return predkosc;
    }

}
