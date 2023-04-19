package main.data.stacje;

import java.util.*;

public final class Graf {
    private static Graf INSTANCJA;
    private final Map<Stacja, LinkedList<Stacja>> mapaPrzylegania = new TreeMap<>();

    public static Graf getInstance() {
        if (INSTANCJA == null) {
            INSTANCJA = new Graf();
        }

        return INSTANCJA;
    }

    private Graf() {}

    public void helperDodawaniaKrawedzi(Stacja a, Stacja b) {
        LinkedList<Stacja> tmp = mapaPrzylegania.get(a);

        if (tmp != null) {
            tmp.remove(b);
        } else tmp = new LinkedList<>();
        tmp.add(b);
        mapaPrzylegania.put(a, tmp);
    }

    public void dodajKrawedz(Stacja source, Stacja destination) {
        // We make sure that every used node shows up in our .keySet()
        if (!mapaPrzylegania.containsKey(source)) {
            mapaPrzylegania.put(source, null);
        }

        if (!mapaPrzylegania.containsKey(destination)) {
            mapaPrzylegania.put(destination, null);
        }

        helperDodawaniaKrawedzi(source, destination);
        helperDodawaniaKrawedzi(destination, source);
    }

    public void wydrukujKrawedzie() {
        for (Stacja node : mapaPrzylegania.keySet()) {
            System.out.print("Stacja " + node.getWartosc() + " ma polaczenie ze stacjami: ");
            for (Stacja neighbor : mapaPrzylegania.get(node)) {
                System.out.print(neighbor.getWartosc() + " ");
            }
            System.out.println();
        }
    }

    public boolean hasEdge(Stacja source, Stacja destination) {
        return mapaPrzylegania.containsKey(source) && mapaPrzylegania.get(source).contains(destination);
    }

    public void resetNodesVisited() {
        for (Stacja node : mapaPrzylegania.keySet()) {
            node.unvisit();
        }
    }

    public List<Stacja> znajdzDrogeMiedzyStacjami(Stacja stacjaPoczatkowa, Stacja stacjaKoncowa, ArrayList<Stacja> stacjeNaTrasie) {
        stacjaPoczatkowa.visit();

        LinkedList<Stacja> sasiedziStacjiZrodlowej = mapaPrzylegania.get(stacjaPoczatkowa);

        if (sasiedziStacjiZrodlowej.isEmpty()) {
            stacjeNaTrasie = new ArrayList<>();
            return stacjeNaTrasie;
        }

        for (Stacja sasiad : sasiedziStacjiZrodlowej) {
            if (stacjeNaTrasie.contains(stacjaKoncowa)) {
                break;
            }

            if (sasiad.equals(stacjaKoncowa)) {
                stacjeNaTrasie.add(stacjaKoncowa);
                System.out.println("ZNALEZIONO DROGĘ!");
                break;
            }

            if (!sasiad.isVisited()) {
                stacjeNaTrasie.add(sasiad);
                znajdzDrogeMiedzyStacjami(sasiad, stacjaKoncowa, stacjeNaTrasie);
            }
        }

        return stacjeNaTrasie;
    }

}
