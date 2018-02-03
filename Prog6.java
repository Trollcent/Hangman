/* Hangman
 * Vincent Nguyen
 * 12/04/17
 * Window 8.1 Eclipse Oxygen
 * The user plays a game called hang man where you guessed the word
 * by inputting a letter
 */
import java.util.*;
public class Prog6 {
	static private Scanner scanner = new Scanner(System.in);
	static public void main(String [] args)
	{
		boolean gameOver;
		boolean hi = false;
		ConsoleHangmanGame startingHangman = new ConsoleHangmanGame();
		do
		{
			gameOver = startingHangman.startingGame();
			if(gameOver)
				hi = chooseLetter("Do you want to play again? ");
		}while(gameOver && hi);
		if(!gameOver)
		{
			System.out.println("No Words Left");//print out No words left
		}
	}

	static public boolean chooseLetter(String prompt)
	{
		String takeLetter;
		System.out.print(prompt);//Ask user if he wants to play again
		takeLetter = scanner.next();//User input goes into take letter
		System.out.print("\n");
		if(takeLetter.charAt(0) == 'y' || takeLetter.charAt(0) == 'Y')
		{
			return true;
		}
		return false;
	}
}

