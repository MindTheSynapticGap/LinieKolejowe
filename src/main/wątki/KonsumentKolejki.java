package main.wątki;

import main.data.SkladPociagu;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class KonsumentKolejki extends Thread {
    private final BlockingQueue<SkladPociagu> kolejka;
    private boolean trasaZajeta = false;

    public KonsumentKolejki(LinkedBlockingQueue<SkladPociagu> kolejka) {
        this.kolejka = kolejka;
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            if (!trasaZajeta && !kolejka.isEmpty()) {
                SkladPociagu skladPociagu = null;
                try {
                    skladPociagu = kolejka.take();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                skladPociagu.getKalkulatorPredkosci().start();
            }

        }
    }

}
