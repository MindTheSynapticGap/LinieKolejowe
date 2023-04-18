package main.data;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public class SpeedThread implements Runnable {
    @Override
    public void run() {
        try {
            TimeUnit.SECONDS.sleep(1);

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
