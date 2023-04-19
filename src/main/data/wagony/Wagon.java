package main.data.wagony;

import java.util.UUID;

public abstract class Wagon {

    private final UUID numerIdentyfikacyjny;
    private final int wagaNetto;
    private int wagaBrutto;
    private int liczbaMiejscSiedzacych;
    private String nadawca;
    private String zabezpieczenia;

    public Wagon(int wagaNetto, int wagaBrutto, int liczbaMiejscSiedzacych, String nadawca, String zabezpieczenia) {
        this.numerIdentyfikacyjny = UUID.randomUUID();
        this.wagaNetto = wagaNetto;
        this.wagaBrutto = wagaBrutto;
        this.liczbaMiejscSiedzacych = liczbaMiejscSiedzacych;
        this.nadawca = nadawca;
        this.zabezpieczenia = zabezpieczenia;
    }

    public UUID getNumerIdentyfikacyjny() {
        return numerIdentyfikacyjny;
    }

    public int getWagaNetto() {
        return wagaNetto;
    }

    public int getWagaBrutto() {
        return wagaBrutto;
    }

    public int getLiczbaMiejscSiedzacych() {
        return liczbaMiejscSiedzacych;
    }

    public String getNadawca() {
        return nadawca;
    }

    public String getZabezpieczenia() {
        return zabezpieczenia;
    }
}
