package main.data.wagony;

import java.util.UUID;

public class WagonNaCiekleMaterialyToksyczne extends WagonTowarowyCiezki {
    public WagonNaCiekleMaterialyToksyczne(int wagaNetto, int wagaBrutto, int liczbaMiejscSiedzacych, String nadawca, String zabezpieczenia) {
        super(wagaNetto, wagaBrutto, liczbaMiejscSiedzacych, nadawca, zabezpieczenia);
    }
}
