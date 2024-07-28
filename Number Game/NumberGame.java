import java.util.Random;
import java.util.Scanner;
public class NumberGame {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Random random = new Random();
		System.out.println("\nWelcome to the Number Guessing Game!");
		int score = 0;
		boolean playAgain = true;
		while (playAgain) {
			int targetNumber = random.nextInt(100) + 1;
			int attempts = 1;
			int maxAttempts = 5;
			System.out.println("A number between 1 and 100 is selected. Can you guess it?\n");
			while (attempts <= maxAttempts) {
				System.out.print("Enter your guess: ");
				int userGuess = scanner.nextInt();
				scanner.nextLine();
				if (userGuess == targetNumber) {
					System.out.println("Congratulations! You guessed the number " + targetNumber + " in " + attempts + " attempts.\n");
					score++;
					break;
				} else if (userGuess < targetNumber) {
					System.out.println("Too low! Try again.\n");
				} else {
					System.out.println("Too high! Try again.\n");
				}
				attempts++;
			}
			if (attempts > maxAttempts) {
				System.out.println("Sorry, you've run out of attempts.\nThe correct number was " + targetNumber + ".\n");
			}
			System.out.print("Do you want to play again? (yes/no): ");
			String playAgainInput = scanner.nextLine();
			playAgain = playAgainInput.equalsIgnoreCase("yes");
		}
		System.out.println("Game over! Your score: " + score);
		scanner.close();
	}
}