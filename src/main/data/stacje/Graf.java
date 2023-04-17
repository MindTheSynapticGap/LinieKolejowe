package main.data.stacje;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Graf {
    private final List<List<Stacja>> listaDrog = new ArrayList<>();

    public Graf(List<Trasa> trasy) {
        // alokacja pamieci do listy przylegania
        IntStream.range(0, trasy.size()).forEach(i -> listaDrog.add(i, new ArrayList<>()));

        // dodawanie tras do grafu
        trasy.forEach(trasa -> listaDrog.get(trasa.getStacjaPoczatkowa().getWartosc()).add(new Stacja(trasa.getStacjaKoncowa().getWartosc(), trasa.getOdleglosc())));
    }
}
