package main.wątki;

import main.data.SkladPociagu;
import main.data.stacje.Graf;
import main.data.stacje.Stacja;
import main.data.stacje.Trasa;
import main.data.stacje.Util;

import java.util.ArrayList;
import java.util.List;

public class WyszukiwarkaTrasy extends Thread {
    private SkladPociagu skladPociagu;
    private Stacja stacjaPoczatkowa;
    private Stacja stacjaKoncowa;

    public WyszukiwarkaTrasy(SkladPociagu skladPociagu) {
        this.skladPociagu = skladPociagu;
        this.stacjaPoczatkowa = skladPociagu.getLokomotywa().getStacjaZrodlowa();
        this.stacjaKoncowa = skladPociagu.getLokomotywa().getStacjaDolecowa();
    }

    @Override
    public void run() {
        List<Stacja> wyszukanaDroga = Graf.getInstance().znajdzDrogeMiedzyStacjami(stacjaPoczatkowa, stacjaKoncowa, new ArrayList<>());
        Trasa konkretnaTrasa = Util.trasa.stream().filter(trasa -> (trasa.getStacjaPierwsza().equals(stacjaPoczatkowa) && trasa.getStacjaDruga().equals(wyszukanaDroga.get(0))) || (trasa.getStacjaDruga().equals(stacjaPoczatkowa) && trasa.getStacjaPierwsza().equals(wyszukanaDroga.get(0)))).findFirst().get();
        konkretnaTrasa.getKolejkaSkladow().add(skladPociagu);
    }

}
