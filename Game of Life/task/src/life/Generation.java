package life;

import java.util.Random;

public class Generation {

    private Universe universe;
    private int n;  // Size of Universe
//    private int m;  // Number of generations to create
    private Random random;

    public Generation(Universe universe) {
        this(universe, 20);
    }

    public Generation(Universe universe, int n) {
        this.universe = universe;
        this.n = n;
        this.random = new Random();
    }

    public String[][] generateUniverse() {
        String[][] generated = new String[this.n][this.n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                generated[i][j] = random.nextBoolean() ? "O" : " ";
            }
        }
        return generated;
    }

    /*
    Evolution is controlled by two rules:
    An alive cell survives if has two or three alive neighbors; otherwise, it dies of boredom (<2) or overpopulation (>3)
    A dead cell is reborn if it has exactly three alive neighbors
     */
    public void evolve() {
        String[][] currentGen = universe.getCurrentGen();
        int len = currentGen.length;
        String[][] nextGen = new String[len][len];

            for (int i = 0; i < len; i++) {
                for (int j = 0; j < len; j++) {
                    int cellNeighbors = neighbors(currentGen, i, j);
                    // Check alive cell
                    if (currentGen[i][j].equals("O")) {
                        // Cell survives
                        if (cellNeighbors == 2 || cellNeighbors == 3) {
                            nextGen[i][j] = "O";
                        } else {
                            // Cell dies
                            nextGen[i][j] = " ";
                        }
                    }
                    // Check dead cell
                    if (currentGen[i][j].equals(" ")) {
                        if (cellNeighbors == 3) {
                            // Cell is reborn
                            nextGen[i][j] = "O";
                        } else {
                            // Cell remains dead
                            nextGen[i][j] = " ";
                        }
                    }
                }
            }
         universe.setCurrentGen(nextGen);
    }

    public int alive(String[][] matrix) {
        int count = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (matrix[i][j].equals("O")) {
                    count++;
                }
            }
        }
        return count;
    }

    public static int neighbors(String[][] uni, int r, int c) {
        int neighbors = 0;
        int size = uni.length;

        // Check N
        if (r == 0) {
            if (uni[size -1][c].equals("O")) {
                neighbors++;
            }
        } else {
            if (uni[r - 1][c].equals("O")) {
                neighbors++;
            }
        }

        // Check NE
        if (r == 0 && (c == size - 1)) {
            if (uni[size - 1][0].equals("O")) {
                neighbors++;
            }
        } else if (c == size - 1) {
            if (uni[r - 1][0].equals("O")) {
                neighbors++;
            }
        } else if (r == 0) {
            if (uni[size - 1][c + 1].equals("O")) {
                neighbors++;
            }
        } else {
            if (uni[r - 1][c + 1].equals("O")) {
                neighbors++;
            }
        }

        // Check NW
        if (r == 0 && (c == 0)) {
            if (uni[size - 1][size - 1].equals("O")) {
                neighbors++;
            }
        } else if (c == 0) {
            if (uni[r - 1][size - 1].equals("O")) {
                neighbors++;
            }
        } else if (r == 0) {
            if (uni[size - 1][c - 1].equals("O")) {
                neighbors++;
            }
        } else {
            if (uni[r - 1][c - 1].equals("O")) {
                neighbors++;
            }
        }

        // Check W
        if (c == 0) {
            if (uni[r][size - 1].equals("O")) {
                neighbors++;
            }
        } else {
            if (uni[r][c - 1].equals("O")) {
                neighbors++;
            }
        }

        // Check E
        if (c == (size - 1)) {
            if (uni[r][0].equals("O")) {
                neighbors++;
            }
        } else {
            if (uni[r][c + 1].equals("O")) {
                neighbors++;
            }
        }

        // Check SW
        if (r == size - 1 && c == 0) {
            if (uni[0][size - 1].equals("O")) {
                neighbors++;
            }
        } else if (c == 0) {
            if (uni[r + 1][size - 1].equals("O")) {
                neighbors++;
            }
        } else if (r == size - 1) {
            if (uni[0][c - 1].equals("O")) {
                neighbors++;
            }
        } else {
            if (uni[r + 1][c - 1].equals("O")) {
                neighbors++;
            }
        }

        // Check S
        if (r == size - 1) {
            if (uni[0][c].equals("O")) {
                neighbors++;
            }
        } else {
            if (uni[r + 1][c].equals("O")) {
                neighbors++;
            }
        }

        // Check SE
        if (r == size - 1 && c == size - 1) {
            if (uni[0][0].equals("O")) {
                neighbors++;
            }
        } else if (c == size - 1) {
            if (uni[r + 1][0].equals("O")) {
                neighbors++;
            }
        } else if (r == size - 1) {
            if (uni[0][c + 1].equals("O")) {
                neighbors++;
            }
        } else {
            if (uni[r + 1][c + 1].equals("O")) {
                neighbors++;
            }
        }
        return neighbors;
    }


}
