package main.data.stacje;

import java.util.Objects;

public class Stacja implements Comparable<Stacja>{
    private int wartosc;
    private int odlegloscOdNastepnejStacji;
    boolean visited;

    public Stacja(int value, int weight) {
        this.wartosc = value;
        this.odlegloscOdNastepnejStacji = weight;
        visited = false;
    }

    public int getWartosc() {
        return wartosc;
    }

    public int getOdlegloscOdNastepnejStacji() {
        return odlegloscOdNastepnejStacji;
    }

    public boolean isVisited() {
        return visited;
    }

    void visit() {
        visited = true;
    }

    void unvisit() {
        visited = false;
    }

    @Override
    public int compareTo(Stacja o) {
        return this.getWartosc()-o.getWartosc();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Stacja stacja = (Stacja) o;
        return wartosc == stacja.wartosc && odlegloscOdNastepnejStacji == stacja.odlegloscOdNastepnejStacji;
    }

    @Override
    public int hashCode() {
        return Objects.hash(wartosc, odlegloscOdNastepnejStacji);
    }
}
