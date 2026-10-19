import java.util.Random;
import java.util.Scanner;

public class Ass_01_Craps{

    static Scanner scanner = new Scanner(System.in);
    static Random rnd = new Random();

    // Rolls two dice, displays them, and returns the sum
    static int roll() {
        int die1 = rnd.nextInt(6) + 1;
        int die2 = rnd.nextInt(6) + 1;
        int sum = die1 + die2;
        System.out.println("Die 1: " + die1 + "  Die 2: " + die2 + "  Sum: " + sum);
        return sum;
    }

    static void playGame() {
        int sum = roll();

        if (sum == 2 || sum == 3 || sum == 12) {
            System.out.println("Craps! You crapped out and lost.");
        } else if (sum == 7 || sum == 11) {
            System.out.println("Natural! You won!");
        } else {
            int point = sum;
            System.out.println("The point is now " + point);

            while (true) {
                sum = roll();
                if (sum == point) {
                    System.out.println("Made point and won!");
                    break;
                } else if (sum == 7) {
                    System.out.println("Got a seven and lost.");
                    break;
                } else {
                    System.out.println("Trying for point");
                }
            }
        }
        System.out.println();
    }

    static boolean playAgain() {
        while (true) {
            System.out.print("Play again? [Y/N]: ");
            String input = scanner.nextLine().trim();
            if (input.equalsIgnoreCase("Y")) return true;
            if (input.equalsIgnoreCase("N")) return false;
            System.out.println("Please enter Y or N.");
        }
    }

    public static void main(String[] args) {
        System.out.println("Craps");
        do {
            playGame();
        } while (playAgain());
        System.out.println("Thanks for playing!");
    }
}
