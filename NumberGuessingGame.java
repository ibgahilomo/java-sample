import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    private int secretNumber;
    private int attemptsLeft;
    private boolean gameOver;

    public NumberGuessingGame() {
        Random random = new Random();
        secretNumber = random.nextInt(100) + 1; // Generate a random number between 1 and 100
        attemptsLeft = 5; // Set the number of attempts allowed
        gameOver = false;
    }

    public void play() {
        Scanner scanner = new Scanner(System.in);

        while (!gameOver) {
            System.out.println("Enter your guess (1-100): ");
            int guess = scanner.nextInt();

            if (guess < secretNumber) {
                System.out.println("Too low! Try again.");
            } else if (guess > secretNumber) {
                System.out.println("Too high! Try again.");
            } else {
                System.out.println("Congratulations! You guessed the number.");
                gameOver = true;
            }

            attemptsLeft--;

            if (attemptsLeft == 0) {
                System.out.println("Sorry, you've run out of attempts. The correct number was: " + secretNumber);
                gameOver = true;
            }
        }

        scanner.close();
    }

    public static void main(String[] args) {
        NumberGuessingGame game = new NumberGuessingGame();
        game.play();
    }
}
