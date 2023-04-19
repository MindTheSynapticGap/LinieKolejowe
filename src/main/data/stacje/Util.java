package main.data.stacje;

import main.data.Lokomotywa;
import main.data.wagony.*;

import java.util.*;

public abstract class Util {
    final static int ILOSC_SKLADOW = 25;
    final static int ILOSC_STACJI = 100;
    final static int ILOSC_TRAS = 500;
    private static final List<Stacja> stacje = new ArrayList<>();
    private static final List<Trasa> trasa = new ArrayList<>();
    private static final List<Lokomotywa> lokomotywy = new ArrayList<>();
    private static final List<Wagon> wagony = new ArrayList<>();

    public static void przygotujGraf() {
        generujGraf();
        Graf.getInstance().wydrukujKrawedzie();
    }

    public static void przygotujSklady() {
        generujLokomotywy();

    }

    private static void generujGraf() {
        for (int i = 0; i < ILOSC_TRAS; i++) {
            generujStacje();
            Stacja pierwszaStacja = stacje.get((int) Math.floor(Math.random() * 100));
            Stacja drugaStacja = stacje.get((int) Math.floor(Math.random() * 100));

            if (!pierwszaStacja.equals(drugaStacja)) {
                Graf.getInstance().dodajKrawedz(pierwszaStacja, drugaStacja);
            } else {
                i--;
            }
        }
    }

    private static void generujStacje() {
        for (int i = 0; i < ILOSC_STACJI; i++) {
            stacje.add(new Stacja(i, (int) Math.floor(Math.random() * 100)));
        }
    }

    private static void generujLokomotywy() {
        for (int i = 0; i < ILOSC_SKLADOW; i++) {
            int maxLiczbaWagonow = (int) (Math.random() * 5);
            int maxUciagLadunku = (int) (Math.random() * 1000);
            int maxLiczbaWagonowWSieciElektrycznej = (int) (maxLiczbaWagonow - Math.random() * 5);
            String nazwa = "dupa";
            Stacja stacjaMacierzysta = stacje.get((int) Math.floor(Math.random() * 100));
            Stacja stacjaDocelowa = stacje.get((int) Math.floor(Math.random() * 100));
            while (stacjaMacierzysta.equals(stacjaDocelowa)) {
                stacjaDocelowa = stacje.get((int) Math.floor(Math.random() * 100));
            }
            int predkoscPoczatkowa = (int) Math.floor(Math.random() * 150);
            lokomotywy.add(new Lokomotywa(maxLiczbaWagonow, maxUciagLadunku, maxLiczbaWagonowWSieciElektrycznej, nazwa, stacjaMacierzysta, stacjaMacierzysta, stacjaDocelowa, predkoscPoczatkowa));
        }
    }

    private static void generujWagony() {
        List<TypyWagonow> TYPY_WAGONOW = List.of(TypyWagonow.values());
        for (Lokomotywa lokomotywa : lokomotywy) {
            for (int j = 0; j < lokomotywa.getMaxLiczbaWagonow(); j++) {
                switch (TYPY_WAGONOW.get(new Random().nextInt())) {
                    case BAGAZOWO_POCZTOWY -> wagony.add(new WagonBagazowoPocztowy(1000, 2000, 0, "dupa", "dupa"));
                    case CHLODNICZY -> wagony.add(new WagonChlodniczy(1000, 2000, 0, "dupa", "dupa"));
                    case MATERIALY_CIEKLE_TOKSYCZNE ->
                            wagony.add(new WagonNaCiekleMaterialyToksyczne(1000, 2000, 0, "dupa", "dupa"));
                    case MATERIALY_CIEKLE -> wagony.add(new WagonNaMaterialyCiekle(1000, 2000, 0, "dupa", "dupa"));
                    case MATERIALY_GAZOWE -> wagony.add(new WagonNaMaterialyGazowe(1000, 2000, 0, "dupa", "dupa"));
                    case MATERIALY_TOKSYCZNE ->
                            wagony.add(new WagonNaMaterialyToksyczne(1000, 2000, 0, "dupa", "dupa"));
                    case MATERIALY_WYBUCHOWE ->
                            wagony.add(new WagonNaMaterialyWybuchowe(1000, 2000, 0, "dupa", "dupa"));
                    case PASAZERSKI -> wagony.add(new WagonPasazerski(1000, 2000, 0, "dupa", "dupa"));
                    case POCZTOWY -> wagony.add(new WagonPocztowy(1000, 2000, 0, "dupa", "dupa"));
                    case RESTAURACYJNY -> wagony.add(new WagonRestauracyjny(1000, 2000, 0, "dupa", "dupa"));
                    case TOWAROWY_CIEZKI -> wagony.add(new WagonTowarowyCiezki(1000, 2000, 0, "dupa", "dupa"));
                    case TOWAROWY_PODSTAWOWY -> wagony.add(new WagonTowarowyPodstawowy(1000, 2000, 0, "dupa", "dupa"));
                }
            }
        }
    }






}
