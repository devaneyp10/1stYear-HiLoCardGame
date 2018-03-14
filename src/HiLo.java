import java.util.Scanner;
import java.util.Random;

public class HiLo {
	public static final int NUMBER_OF_GUESSES = 4;

	public static void main(String[] args) {
		System.out.println("Welcome to the Hi-Lo card game."
				+ " You will be dealt a card and you will then have to guess if the next card dealt"
				+ " is higher or lower than the current card. You must guess correctly 4 times in order to win.");
		Random generator = new Random();

		int currentCard = generator.nextInt(13) + 2;
		if (currentCard < 11)
			System.out.println("Your card is a " + currentCard);
		else if (currentCard == 11)
			System.out.println("Your card is a Jack.");
		else if (currentCard == 12)
			System.out.println("Your card is a Queen.");
		else if (currentCard == 13)
			System.out.println("Your card is a King.");
		else if (currentCard == 14)
			System.out.println("Your card is an Ace.");

		System.out.println("Now it's time to guess, type 'hi' to guess that the next number is higher, "
				+ "'lo' to guess that the next number is lower and 'equal' to guess that the number is equal.");

		Scanner guesses = new Scanner(System.in);
		boolean correct = true;
		int guessNumber = 0;
		int nextCard = 0;
		while ((correct == true) && (guessNumber < NUMBER_OF_GUESSES)) {
			nextCard = generator.nextInt(13) + 2;
			System.out.println("Guess 'hi','lo' or 'equal'.");
			if (((guesses.hasNext("hi")) || (guesses.hasNext("lo") || (guesses.hasNext("equal"))))) {
				if ((guesses.hasNext("hi") && currentCard < nextCard)
						|| (guesses.hasNext("lo") && currentCard > nextCard)
						|| (guesses.hasNext("equal") && currentCard == nextCard)) {

					if (nextCard < 11)
						System.out.println("Correct! The card was a " + nextCard + ".");
					else if (nextCard == 11)
						System.out.println("Correct! The card was a Jack.");
					else if (nextCard == 12)
						System.out.println("Correct! The card was a Queen.");
					else if (nextCard == 13)
						System.out.println("Correct! The card was a King.");
					else if (nextCard == 14)
						System.out.println("Correct! the card was an Ace.");

					currentCard = nextCard;
					guessNumber++;
					guesses.next();
				}

				else {
					correct = false;
				}

			} else {
				System.out.println("Error, invalid entry. Try again.");
				guesses.next();
			}
		}
		if (guessNumber != 4) {
			if (nextCard < 11)
				System.out.println("Incorrect. Unlucky, the card was a " + nextCard + ". Run again to retry.");
			else if (nextCard == 11)
				System.out.println("Incorrect. The card was a Jack. Run again to retry.");
			else if (nextCard == 12)
				System.out.println("Incorrect. The card was a Queen. Run again to retry.");
			else if (nextCard == 13)
				System.out.println("Incorrect. The card was a King. Run again to retry.");
			else if (nextCard == 14)
				System.out.println("Incorrect. The card was a Ace. Run again to retry.");

		}

		else
			System.out.println("Congratulations, You win!");
		guesses.close();

	}

}
