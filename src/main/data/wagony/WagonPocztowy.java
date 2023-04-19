package main.data.wagony;

import java.util.UUID;

public class WagonPocztowy extends Wagon implements WagonElektryczny {
    public WagonPocztowy(int wagaNetto, int wagaBrutto, int liczbaMiejscSiedzacych, String nadawca, String zabezpieczenia) {
        super(wagaNetto, wagaBrutto, liczbaMiejscSiedzacych, nadawca, zabezpieczenia);
    }
}
