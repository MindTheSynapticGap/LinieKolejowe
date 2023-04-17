package main.data.stacje;

public class Stacja {
    private int wartosc;
    private int odlegloscOdNastepnejStacji;

    public Stacja(int value, int weight) {
        this.wartosc = value;
        this.odlegloscOdNastepnejStacji = weight;
    }

    public int getWartosc() {
        return wartosc;
    }

    public int getOdlegloscOdNastepnejStacji() {
        return odlegloscOdNastepnejStacji;
    }
}
