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

    public static void printGraph(Graf graf)  {
        int src_vertex = 0;
        int list_size = graf.listaTras.size();

        System.out.println("Zawartosc grafu:");
        while (src_vertex < list_size) {
            //traverse through the adjacency list and print the edges
            for (Stacja edge : graf.listaTras.get(src_vertex)) {
                System.out.print("Trasa: " + src_vertex + " ==> " + edge.getWartosc() +
                        " (" + edge.getOdlegloscOdNastepnejStacji() + ")\t");
            }

            System.out.println();
            src_vertex++;
        }
    }
}
