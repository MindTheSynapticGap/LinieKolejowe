package main.data.stacje;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Graf {
    private final List<List<Stacja>> listaTras = new ArrayList<>();

    public Graf(List<Trasa> trasy) {
        // alokacja pamieci do listy przylegania
        IntStream.range(0, trasy.size()).forEach(i -> listaTras.add(i, new ArrayList<>()));

        // dodawanie tras do grafu
        trasy.forEach(trasa -> listaTras.get(trasa.getStacjaPoczatkowa().getWartosc()).add(new Stacja(trasa.getStacjaKoncowa().getWartosc(), trasa.getOdleglosc())));
    }

    public static void wydrukujGraf(Graf graf)  {
        int indexStacji = 0;

        System.out.println("Zawartosc grafu:");
        while (indexStacji < graf.listaTras.size()) {
            //przejrzyl liste przylegania i wydrukuj trasy
            for (Stacja stacja : graf.listaTras.get(indexStacji)) {
                System.out.print("Trasa: " + indexStacji + " ==> " + stacja.getWartosc() +
                        " (" + stacja.getOdlegloscOdNastepnejStacji() + ")\t");
            }

            System.out.println();
            indexStacji++;
        }
    }

}
