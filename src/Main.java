import main.data.stacje.Graf;
import main.data.stacje.Stacja;
import main.data.stacje.Trasa;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Stacja> stacje = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            stacje.add(new Stacja(i, (int) Math.floor(Math.random() * 100)));
        }

        List<Trasa> trasy = new ArrayList<>();

        for (int i = 0; i < stacje.size(); i++) {
            trasy.add(new Trasa(stacje.get((int) Math.floor(Math.random() * 100)), stacje.get((int) Math.floor(Math.random() * 100)), (int) Math.floor(Math.random() * 100)));
        }

        Graf graf = new Graf(trasy);

        Graf.wydrukujGraf(graf);
    }

}
