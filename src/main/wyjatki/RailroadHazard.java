package main.wyjatki;

import main.data.Lokomotywa;
import main.data.wagony.Wagon;

import java.util.List;

public class RailroadHazard extends Exception {
    public RailroadHazard(Lokomotywa lokomotywa, List<Wagon> wagony) {
        super(lokomotywa.getNumerIdentyfikacyjny().toString());
    }

    public void printMessage() {
        System.out.println(this.getMessage());
    }
}
