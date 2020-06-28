package life;

import java.io.IOException;
import java.util.Scanner;
import java.lang.Thread;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());

        Universe universe = new Universe();
        Generation generation = new Generation(universe, n);
        universe.setCurrentGen(generation.generateUniverse());

        int g = 1;
        int evolutions = 10;

        while (evolutions > 0) {

            System.out.println("Generation #" + g++);
            System.out.println("Alive: " + generation.alive(universe.getCurrentGen()));

            universe.printUniverse();
            generation.evolve();
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
            clearScreen();
            evolutions--;
        }

    }

    public static void clearScreen() {
        //Clears Screen in java
        try {
            if (System.getProperty("os.name").contains("Windows"))
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            else
                Runtime.getRuntime().exec("clear");
        } catch (IOException | InterruptedException e) {
            System.out.println(e);
        }

    }
}
