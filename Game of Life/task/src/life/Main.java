package life;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

//        String TEST = "8 1 10";
//        Scanner sc = new Scanner(TEST);

        Scanner sc = new Scanner(System.in);

        String[] input = sc.nextLine().split("\\s+");
        int n = Integer.parseInt(input[0]);    // Size of Universe
        long s = Long.parseLong(input[1]);    // Seed for Random
        int m = Integer.parseInt(input[2]);    // Number of generations

        Universe universe = new Universe();
        Generation generation = new Generation(universe, n, s, m);
        universe.setCurrentGen(generation.generateUniverse());

        for (int i = 0; i < m; i++) {
            generation.evolve();
        }

        universe.printUniverse();

    }
}
