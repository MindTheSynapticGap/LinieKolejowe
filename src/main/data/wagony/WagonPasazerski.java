package main.data.wagony;

import java.util.UUID;

public class WagonPasazerski extends Wagon implements WagonElektryczny {

    public WagonPasazerski(int wagaNetto, int wagaBrutto, int liczbaMiejscSiedzacych, String nadawca, String zabezpieczenia) {
        super(wagaNetto, wagaBrutto, liczbaMiejscSiedzacych, nadawca, zabezpieczenia);
    }

}
