package main.data;

import main.data.stacje.Stacja;

import java.util.UUID;

public class Lokomotywa {
    private final int maxLiczbaWagonow;
    private final int maxUciagLadunku;
    private final int maxLiczbaWagonowWSieciElektrycznej;
    private String nazwa;
    private Stacja stacjaMacierzysta;
    private Stacja stacjaZrodlowa;
    private Stacja stacjaDolecowa;
    private final UUID numerIdentyfikacyjny;
    private int poczatkowaPredkosc;

    public Lokomotywa(int maxLiczbaWagonow, int maxUciagLadunku, int maxLiczbaWagonowWSieciElektrycznej, String nazwa, Stacja stacjaMacierzysta, Stacja stacjaZrodlowa, Stacja stacjaDolecowa, int predkosc) {
        this.maxLiczbaWagonow = maxLiczbaWagonow;
        this.maxUciagLadunku = maxUciagLadunku;
        this.maxLiczbaWagonowWSieciElektrycznej = maxLiczbaWagonowWSieciElektrycznej;
        this.nazwa = nazwa;
        this.stacjaMacierzysta = stacjaMacierzysta;
        this.stacjaZrodlowa = stacjaZrodlowa;
        this.stacjaDolecowa = stacjaDolecowa;
        this.numerIdentyfikacyjny = UUID.randomUUID();
        this.poczatkowaPredkosc = predkosc;
    }

    public int getPoczatkowaPredkosc() {
        return poczatkowaPredkosc;
    }

    public int getMaxLiczbaWagonow() {
        return maxLiczbaWagonow;
    }

    public int getMaxUciagLadunku() {
        return maxUciagLadunku;
    }

    public int getMaxLiczbaWagonowWSieciElektrycznej() {
        return maxLiczbaWagonowWSieciElektrycznej;
    }

    public String getNazwa() {
        return nazwa;
    }

    public Stacja getStacjaMacierzysta() {
        return stacjaMacierzysta;
    }

    public Stacja getStacjaZrodlowa() {
        return stacjaZrodlowa;
    }

    public Stacja getStacjaDolecowa() {
        return stacjaDolecowa;
    }

    public UUID getNumerIdentyfikacyjny() {
        return numerIdentyfikacyjny;
    }
}
