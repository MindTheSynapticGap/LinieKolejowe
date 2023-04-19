package main.data.wagony;

import java.util.UUID;

public class WagonRestauracyjny extends Wagon implements WagonElektryczny {
    public WagonRestauracyjny(int wagaNetto, int wagaBrutto, int liczbaMiejscSiedzacych, String nadawca, String zabezpieczenia) {
        super(wagaNetto, wagaBrutto, liczbaMiejscSiedzacych, nadawca, zabezpieczenia);
    }
}
