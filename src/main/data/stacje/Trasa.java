package main.data.stacje;

public class Trasa {
    private Stacja stacjaPoczatkowa;
    private Stacja stacjaKoncowa;
    private int odleglosc;

    public Trasa(Stacja src, Stacja dest, int weight) {
        this.stacjaPoczatkowa = src;
        this.stacjaKoncowa = dest;
        this.odleglosc = weight;
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
