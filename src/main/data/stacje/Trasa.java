package main.data.stacje;

import main.wątki.KalkulatorTrasy;

public class Trasa {
    private final Stacja stacjaPoczatkowa;
    private final Stacja stacjaKoncowa;
    private final int odleglosc;
    private final KalkulatorTrasy kalkulatorTrasy;

    public Trasa(Stacja src, Stacja dest, int weight) {
        this.stacjaPoczatkowa = src;
        this.stacjaKoncowa = dest;
        this.odleglosc = weight;
        this.kalkulatorTrasy = new KalkulatorTrasy(this);
    }

    public Stacja getStacjaPoczatkowa() {
        return stacjaPoczatkowa;
    }

    public Stacja getStacjaKoncowa() {
        return stacjaKoncowa;
    }

    public int getOdleglosc() {
        return odleglosc;
    }
}
