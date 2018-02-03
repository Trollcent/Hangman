public class Hangman {
	private int maxGuesses = 6;//Int variable that holds max guesses
	private WordDatabase interestingWord;//WordDatabase object variable
	private String currentAnswer;//String variable that holds the answer
	private StringBuilder yourAnswer;//String builder object variable
	private StringBuilder charGuesses;//String builder object variable
	public final int CORRECT = 1, WRONG = -1, FINISH = 2, FAILED = -2, SAME = 0;//enum variables
	
	Hangman()
	{
		interestingWord = new WordDatabase();//Instantiate WordDatabase
		yourAnswer = new StringBuilder();//Instantiate empty StringBuilder
		charGuesses = new StringBuilder();//Instantiate empty StringBuilder
	}
	public void gameCreated()
	{
		if(interestingWord.hasNext())
		{
			currentAnswer = interestingWord.next();//returns a random word
			charGuesses.setLength(0);//empty the string builder
			yourAnswer.setLength(0);//empty the string builder
			maxGuesses = 6;
			for(int index = 0; index < currentAnswer.length(); index++)
			{
				yourAnswer.append('_');//add underscores to your answer
			}
			for(int i = 0; i < yourAnswer.length(); i++)
			{
				if(yourAnswer.charAt(i) == '_')//finds the _
					yourAnswer.insert(i+1, ' ');//add space after the _
			}	
		}
		else
		{
			throw new ArrayIndexOutOfBoundsException();//throw an ArrayIndexOutOfBoundsException
		}
	}
	public String spacingYourAnswer()
	{
		return yourAnswer.toString();//return the user's current word in a String
	}
	public String playerGuesses()
	{
		return charGuesses.toString();//return the letters that user guess in a string
	}
	public int numberWrong()
	{
		return maxGuesses;//return the number of guesses
	}
	public String correctString()
	{
		return currentAnswer;//return the answer
	}
	public final int returnIfGuess(char playerGuess)
	{
		if(!Character.isLetter(playerGuess) || playerGuesses().indexOf(playerGuess) != -1) 
		{
			return SAME;//return SAME
		}
		boolean interestingGuess = false;
		int value;
		charGuesses.append(playerGuess);
		if(currentAnswer.indexOf(charGuesses.charAt(playerGuesses().length()-1), 0) != -1)//check the position of the letter
		{
			value = currentAnswer.indexOf(charGuesses.charAt(playerGuesses().length()-1), 0);//the value is set to the index of the character found
			interestingGuess = true;//initialize the guess to true
			if(value == 0)
			{
				yourAnswer.setCharAt(value, charGuesses.charAt(playerGuesses().length()-1));// set the letter you guessed to your answer if found
				while(currentAnswer.indexOf(charGuesses.charAt(playerGuesses().length()-1), value + 1) != -1)//set the character to your answer
				{
					value = currentAnswer.indexOf(charGuesses.charAt(playerGuesses().length()-1), value + 1);//the value is set to the index of the character found
					yourAnswer.setCharAt(value + value, charGuesses.charAt(playerGuesses().length()-1));//set the character to your answer
				}
			}
			else
			{
				yourAnswer.setCharAt(value + value, charGuesses.charAt(playerGuesses().length()-1));// set the letter you guessed to your answer if found
				while(currentAnswer.indexOf(charGuesses.charAt(playerGuesses().length()-1), value + 1) != -1)
				{
					value = currentAnswer.indexOf(charGuesses.charAt(playerGuesses().length()-1), value + 1);//the value is set to the index of the character found
					yourAnswer.setCharAt(value + value, charGuesses.charAt(playerGuesses().length()-1));//set the character to your answer
				}
			}	
		}
		if(!interestingGuess)
		{
			maxGuesses--;//Decrement the guess playerGuesses().length()
			if(numberWrong() <= 0)
			{
				return FAILED;//return FAILED
			}
			return WRONG;//return WRONG
		}
		System.out.print("You have found the correct letter\n");//Display that you found the letter
		if(correctString().equals(yourAnswer.toString().replaceAll("\\s+","").trim()))
		{
			return FINISH;//return FINISH
		}
		return CORRECT;//return CORRECT
	}
}
