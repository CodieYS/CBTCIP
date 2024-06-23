package projects;
import java.util.Random;
import java.util.Scanner;

public class GuessTheNumberGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int score = 0;
        int rounds = 3;
        int maxAttempts = 5;

        System.out.println("Welcome to the Guess the Number Game!");

        for (int round = 1; round <= rounds; round++) {
            int numberToGuess = random.nextInt(100) + 1;
            int attempts = 0;
            boolean hasGuessed = false;

            System.out.println("Round " + round + ":");
            System.out.println("I'm thinking of a number between 1 and 100. Can you guess it?");

            while (attempts < maxAttempts && !hasGuessed) {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();
                attempts++;

                if (userGuess < numberToGuess) {
                    System.out.println("Too low! Try again.");
                } else if (userGuess > numberToGuess) {
                    System.out.println("Too high! Try again.");
                } else {
                    System.out.println("Correct! You've guessed the number in " + attempts + " attempts.");
                    score += (maxAttempts - attempts + 1) * 10;  // More points for fewer attempts
                    hasGuessed = true;
                }
            }

            if (!hasGuessed) {
                System.out.println("Sorry, you've used all " + maxAttempts + " attempts. The number was " + numberToGuess + ".");
            }

            System.out.println("Score after round " + round + ": " + score);
        }

        System.out.println("Game over! Your final score is: " + score);
        scanner.close();
    }
}

