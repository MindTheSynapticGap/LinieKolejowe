package main.data.wagony;

import java.util.UUID;

public class WagonChlodniczy extends WagonTowarowyPodstawowy implements WagonElektryczny {
    public WagonChlodniczy(int wagaNetto, int wagaBrutto, int liczbaMiejscSiedzacych, String nadawca, String zabezpieczenia) {
        super(wagaNetto, wagaBrutto, liczbaMiejscSiedzacych, nadawca, zabezpieczenia);
    }
}
