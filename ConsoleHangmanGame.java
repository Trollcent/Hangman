import java.util.Scanner;
public class ConsoleHangmanGame {
	private Hangman startGame;//A private Hangman Object
	public static Scanner scanner = new Scanner(System.in);
	ConsoleHangmanGame()
	{
		startGame = new Hangman();//Instantiate hangman
	}
	public boolean startingGame()
	{
		boolean gameOver;//boolean that is set to true
		int holdValue = 0;//int that is set to 0
		try
		{
			gameOver = false;
			startGame.gameCreated();//call gameCreated() if there is an error catch(ArrayIndexOutOfBounds)
			while(holdValue != startGame.FINISH && holdValue != startGame.FAILED)
			{
				gameOver = true;
				String playerGuess;//String that holds user input
				System.out.println("Current Word:");//print out Current Word:
				System.out.println(startGame.spacingYourAnswer());//print out the user's word
				System.out.print("\nEnter a letter: ");// Ask your to enter the letter
				playerGuess = scanner.next();//User input goes to hold string
				playerGuess = playerGuess.trim().toLowerCase();//set playerGuess to lowercase
				holdValue = startGame.returnIfGuess(playerGuess.charAt(0));//call returnIfGuess which finds the letter of the user inputted and return an int
				displayResult(holdValue);//call displayResult
			}
		}
		catch(ArrayIndexOutOfBoundsException ie)
		{	
			gameOver =  false;//set gameOver to false
		}	
		return gameOver;//return gameOver
	}
	public void displayResult(int holdValue)
	{
		if(holdValue == startGame.SAME)//if holdValue == SAME(0) execute
		{
			System.out.println("It is either not a letter or you have already guessed it");//Display that the user's input is not a letter or a repeated letter
		}
		System.out.println("\nLetters you have guessed: " + startGame.playerGuesses());//Displays the letter you have guessed so far
		if(holdValue == startGame.FINISH)//if  holdValue == FINISH(2) execute
		{
			System.out.print("You have found the correct letter\n");//Display that you found the letter
			System.out.println("You solved it: " + "\"" + startGame.spacingYourAnswer().replaceAll("\\s+","").trim() + "\" " + "Congratulations!");//Congratulate the user for solving the problem
		}
		else if(holdValue == startGame.FAILED)//if  holdValue == FAILED(-2) execute
		{ 
			System.out.println("Sorry, that is not in the word");//Display that the user's letter is not in the letter 
			System.out.println("Sorry you used up all your incorrect guesses");//Display that you used up all of your guesses
			System.out.println("The answer = " + startGame.correctString());//Display the current answer
		} else if(holdValue == startGame.WRONG)//if  holdValue == WRONG(-1) execute
		{
			System.out.println("Sorry, that is not in the word");//Display that the user's letter is not in the letter 
			System.out.println("You are allowed " + startGame.numberWrong() + " more incorrect guesses\n");//Display how many guesses you have left
		}
		else if(holdValue == startGame.CORRECT)//if  holdValue == CORRECT(1) execute
		{
			System.out.print("You have found the correct letter\n");//Display that you found the letter
		}
	}
}
