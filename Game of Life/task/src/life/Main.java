package life;

import java.io.IOException;
import java.util.Scanner;
import java.lang.Thread;

public class Main {
    public static void main(String[] args) {

        Universe universe = new Universe();
        Generation generation = new Generation(universe);
        universe.setCurrentGen(generation.generateUniverse());
        GameOfLife gol = new GameOfLife();

        while (true) {
            generation.evolve();

            String [][] currentGen = universe.getCurrentGen();
            int len = currentGen.length;

            for (int i = 0; i < len; i++) {
                for (int j = 0; j < len; j++) {
                    if (currentGen[i][j].equals("O")) {
                        gol.grid.fillCell(i, j);
                    } else {
                        gol.grid.removeCell(i, j);
                    }
                }
            }

            // wait between evolutions
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }

            String gen = "Generation #" + gol.getGen();
            String alive = "Alive: " + generation.alive(currentGen);

            gol.GenerationLabel.setText(gen);
            gol.AliveLabel.setText(alive);

            gol.setGen(gol.getGen() + 1);
        }
    }
}
