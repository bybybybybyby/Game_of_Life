package life;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split("\\s+");
        int n = Integer.valueOf(input[0]);    // Size of Universe
        long s = Long.valueOf(input[1]);    // Seed for Random
        Random random = new Random(s);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(random.nextBoolean() ? 'O' : ' ');
            }
            System.out.println();
        }
    }
}
