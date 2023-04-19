package main.data.stacje;

import main.data.SkladPociagu;
import main.wątki.KalkulatorTrasy;

import java.util.Objects;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Trasa {
    private final Stacja stacjaPierwsza;
    private final Stacja stacjaDruga ;
    private final int odleglosc;
    private final KalkulatorTrasy kalkulatorTrasy;
    private final BlockingQueue<SkladPociagu> kolejkaSkladow;

    public Trasa(Stacja src, Stacja dest, int weight) {
        this.stacjaPierwsza = src;
        this.stacjaDruga = dest;
        this.odleglosc = weight;
        this.kalkulatorTrasy = new KalkulatorTrasy(this);
        this.kolejkaSkladow = new LinkedBlockingQueue<>();
    }

    public Stacja getStacjaPierwsza() {
        return stacjaPierwsza;
    }

    public Stacja getStacjaDruga() {
        return stacjaDruga;
    }

    public int getOdleglosc() {
        return odleglosc;
    }

    public KalkulatorTrasy getKalkulatorTrasy() {
        return kalkulatorTrasy;
    }

    public BlockingQueue<SkladPociagu> getKolejkaSkladow() {
        return kolejkaSkladow;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Trasa trasa = (Trasa) o;
        return odleglosc == trasa.odleglosc && Objects.equals(stacjaPierwsza, trasa.stacjaPierwsza) && Objects.equals(stacjaDruga, trasa.stacjaDruga);
    }

    @Override
    public int hashCode() {
        return Objects.hash(stacjaPierwsza, stacjaDruga, odleglosc);
    }
}
