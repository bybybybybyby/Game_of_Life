package life;

import java.lang.Thread;

public class Main {

    public static void main(String[] args) {

        Universe universe = new Universe();
        Generation generation = new Generation(universe);
        universe.setCurrentGen(generation.generateUniverse());
        GameOfLife gol = new GameOfLife();

        while (true) {
            // Reset button pressed
            if (gol.isReset()) {
                universe = new Universe();
                generation = new Generation(universe);
                universe.setCurrentGen(generation.generateUniverse());
                gol.setGen(0);
                gol.resetToFalse();
            }

            // Play/Pause button pressed
            if (gol.isPaused()) {
//                // Only can get it to unpause with more code than 'continue'
                try {
                    Thread.sleep(1);
                    continue;
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }

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
                Thread.sleep(50);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }

            String gen = "Generation #" + gol.getGen();
            String alive = "Alive: " + generation.alive(currentGen);

            gol.generationLabel.setText(gen);
            gol.aliveLabel.setText(alive);

            gol.setGen(gol.getGen() + 1);
        }
    }


}
