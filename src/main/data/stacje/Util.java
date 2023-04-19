package main.data.stacje;

import main.data.Lokomotywa;
import main.data.SkladPociagu;
import main.data.wagony.*;

import java.util.*;

public abstract class Util {
    private final static int ILOSC_SKLADOW = 25;
    private final static int ILOSC_STACJI = 100;
    private final static int ILOSC_TRAS = 500;
    private static final List<Stacja> stacje = new ArrayList<>();
    public static final List<Trasa> trasa = new ArrayList<>();
    private static final List<Lokomotywa> lokomotywy = new ArrayList<>();
    private static final List<Wagon> wagony = new ArrayList<>();
    private static final List<SkladPociagu> skladyPociagow = new ArrayList<>();

    public static void przygotujGraf() {
        generujGraf();
        Graf.getInstance().wydrukujKrawedzie();
    }

    public static void przygotujSklady() {
        generujLokomotywy();
        generujWagony(lokomotywy);
        skladyPociagow.forEach(skladPociagu -> System.out.println(skladPociagu.getPredkosc()));
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

    private static void generujWagony(List<Lokomotywa> wygenerowaneLokomotywy) {
        List<TypyWagonow> TYPY_WAGONOW = List.of(TypyWagonow.values());
        for (Lokomotywa lokomotywa : wygenerowaneLokomotywy) {
            List<Wagon> wagonyTemp = new ArrayList<>();
            for (int j = 0; j < lokomotywa.getMaxLiczbaWagonow(); j++) {
                switch (TYPY_WAGONOW.get(new Random().nextInt(12))) {
                    case BAGAZOWO_POCZTOWY -> wagonyTemp.add(new WagonBagazowoPocztowy(1000, 2000, 0, "dupa", "dupa"));
                    case CHLODNICZY -> wagonyTemp.add(new WagonChlodniczy(1000, 2000, 0, "dupa", "dupa"));
                    case MATERIALY_CIEKLE_TOKSYCZNE ->
                            wagonyTemp.add(new WagonNaCiekleMaterialyToksyczne(1000, 2000, 0, "dupa", "dupa"));
                    case MATERIALY_CIEKLE -> wagonyTemp.add(new WagonNaMaterialyCiekle(1000, 2000, 0, "dupa", "dupa"));
                    case MATERIALY_GAZOWE -> wagonyTemp.add(new WagonNaMaterialyGazowe(1000, 2000, 0, "dupa", "dupa"));
                    case MATERIALY_TOKSYCZNE ->
                            wagonyTemp.add(new WagonNaMaterialyToksyczne(1000, 2000, 0, "dupa", "dupa"));
                    case MATERIALY_WYBUCHOWE ->
                            wagonyTemp.add(new WagonNaMaterialyWybuchowe(1000, 2000, 0, "dupa", "dupa"));
                    case PASAZERSKI -> wagonyTemp.add(new WagonPasazerski(1000, 2000, 0, "dupa", "dupa"));
                    case POCZTOWY -> wagonyTemp.add(new WagonPocztowy(1000, 2000, 0, "dupa", "dupa"));
                    case RESTAURACYJNY -> wagonyTemp.add(new WagonRestauracyjny(1000, 2000, 0, "dupa", "dupa"));
                    case TOWAROWY_CIEZKI -> wagonyTemp.add(new WagonTowarowyCiezki(1000, 2000, 0, "dupa", "dupa"));
                    case TOWAROWY_PODSTAWOWY -> wagonyTemp.add(new WagonTowarowyPodstawowy(1000, 2000, 0, "dupa", "dupa"));
                }
            }
            wagony.addAll(wagonyTemp);
            skladyPociagow.add(new SkladPociagu(lokomotywa, wagonyTemp));
        }
    }








}
