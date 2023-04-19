package main.wątki;

import main.data.SkladPociagu;
import main.data.stacje.Trasa;
import main.wyjatki.RailroadHazard;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class KalkulatorTrasy extends Thread {
    private final Trasa trasa;
    private SkladPociagu skladPociagu;
    private double przebytaTrasa;


    public KalkulatorTrasy(Trasa trasa) {
        this.trasa = trasa;
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            try {
                double predkosc = skladPociagu.getPredkosc();
                TimeUnit.SECONDS.sleep(1);
                przebytaTrasa += predkosc/3600;
                System.out.println("Obecna predkosc pociagu: " + predkosc);
                System.out.println("Procent przebytej trasy: " + przebytaTrasa/trasa.getOdleglosc());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void setSkladPociagu(SkladPociagu skladPociagu) {
        this.skladPociagu = skladPociagu;
    }
}
