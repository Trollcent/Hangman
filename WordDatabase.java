import java.io.*;
import java.util.*;
public class WordDatabase implements Iterator<String>
{
	private List<String> list = new ArrayList<String>();//private List that instantiate an ArrayList<Integer>
	private Iterator<String> user;//Iterator object created with Generic string
	
	WordDatabase()
	{
		String str;//String that holds file string
		FileInputStream inFile = null;//FileInputStream object set to null
		BufferedReader reader = null;//BufferedReader  object set to null
	
		try
		{
			inFile  = new FileInputStream("info1.txt");// or inFile  = new FileInputStream("info.txt")
			InputStreamReader inStrRdr =new InputStreamReader(inFile, "UTF-8");//indicate UTF-8 and chain with FileInputStream
			reader = new BufferedReader(inStrRdr);//chains the inputStreamReader
			str = reader.readLine();//read the line of the input file
			while(str != null)
			{
				list.add(str);//add the str to the ArrayList
				str = reader.readLine();//set str to the next line of the input file
			}
			inFile.close();//close the file
			reader.close();//close the file
		}
		catch(FileNotFoundException e)
		{
			System.err.println(e);//print the exception error if FileNotFoundException is caught
			return;
		}
		catch (UnsupportedEncodingException e)
		{
			System.err.println(e);//print the exception error if UnsupportedEncodingException is caught
			return;
		}
		catch( IOException ie )
		{
			System.err.println("Error in input: " + ie);//print the exception error if IOException is caught
		}
		catch(NumberFormatException ne)
		{
			System.err.println("Error in input: " + ne);//print the exception error if NumberFormatException is caught
		} 
		user = list.iterator();//set the list.iterator to the iterator object
		randomizeString();//call function that randomizes string
	}
	public int arraySize()
	{
		return list.size();// return the stringName.length
	}
	public String next()
	{
		return user.next();// return the string at current index
	}
	public void randomizeString()
	{
		String hold1;
		int number;// Int variable to hold the randomize number
		for(int index = 0; index < arraySize(); index++)
		{
			number = (int)(Math.random()*arraySize());//get a number that is randomize from 1 to arraySize
			hold1 = list.get(number);//hold the String Object at the index of number
			list.set(number,list.get(index) );//set the String Object of index to the number index
			list.set(index,hold1);//set the holdString at the index of List
		}
	}
	public boolean hasNext()
	{
		return user.hasNext();//return true or false
	}
	public void remove(){	}
}
