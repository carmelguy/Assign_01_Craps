import java.util.Random;
import java.util.Scanner;

public class CrapsGame
{
    public static void main(String[] args) {
        // Create Random and Scanner objects for the game
        Random rnd = new Random();
        Scanner scanner = new Scanner(System.in);

        // Variable to control game repetition
        boolean playAgain = true;

        // Welcome message
        System.out.println("Welcome to the Craps Game!");

        // Main game loop
        while (playAgain) {
            System.out.println("\n--- New Game ---");

            // First roll
            int die1 = rnd.nextInt(6) + 1;
            int die2 = rnd.nextInt(6) + 1;
            int sum = die1 + die2;

            // Display the initial roll
            System.out.println("First roll: Die 1 = " + die1 + ", Die 2 = " + die2 + ", Sum = " + sum);

            // Determine the outcome of the first roll
            if (sum == 2 || sum == 3 || sum == 12) {
                System.out.println("Craps! You crapped out. Sorry, you lose.");
            } else if (sum == 7 || sum == 11) {
                System.out.println("Natural! Congrats, you win!");
            } else {
                // Point is established
                int point = sum;
                System.out.println("Point is now " + point + ". Roll again to try for point.");

                boolean continuePlaying = true;

                // Rolling for point
                while (continuePlaying) {
                    System.out.println("\nPress Enter to roll the dice...");
                    scanner.nextLine(); // Wait for user input

                    die1 = rnd.nextInt(6) + 1;
                    die2 = rnd.nextInt(6) + 1;
                    sum = die1 + die2;

                    System.out.println("Roll: Die 1 = " + die1 + ", Die 2 = " + die2 + ", Sum = " + sum);

                    if (sum == point) {
                        System.out.println("Made point and won! Congratulations!");
                        continuePlaying = false;
                    } else if (sum == 7) {
                        System.out.println("Got a seven and lost. Sorry!");
                        continuePlaying = false;
                    } else {
                        System.out.println("Trying for point " + point + "...");
                    }
                }
            }

            // Ask if the player wants to play again
            System.out.print("\nDo you want to play again? (y/n): ");
            String response = scanner.nextLine().trim().toLowerCase();
            playAgain = response.equals("y") || response.equals("yes");
        }

        System.out.println("Thanks for playing Craps! Goodbye!");
        scanner.close();
    }
}