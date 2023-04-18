package main.wątki;

import main.data.SkladPociagu;
import main.wyjatki.RailroadHazard;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class KalkulatorPredkosci extends Thread {
    private final SkladPociagu skladPociagu;

    public KalkulatorPredkosci(SkladPociagu skladPociagu) {
        this.skladPociagu = skladPociagu;
    }

    @Override
    public void run() {
        Random random = new Random();
        while(!Thread.currentThread().isInterrupted()) {
            try {
                TimeUnit.SECONDS.sleep(1);
                if (random.nextBoolean()) {
                    skladPociagu.setPredkosc(Math.floor(skladPociagu.getPredkosc() * 1.03));
                } else {
                    skladPociagu.setPredkosc(Math.floor(skladPociagu.getPredkosc() * 0.97));
                }
                System.out.println("Predkosc pociagu: " + skladPociagu.getPredkosc());
                if (skladPociagu.getPredkosc() > 100) {
                    throw new RailroadHazard(skladPociagu.getLokomotywa(), skladPociagu.getWagony());

                }
            } catch (RailroadHazard e) {
                e.printMessage();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

}
