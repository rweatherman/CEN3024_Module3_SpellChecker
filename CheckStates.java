package weathermanModule3;

import java.util.List;
import java.util.Objects;

public class CheckStates 
{
	// declare variables to be used
	private String statesNotFound;
	int badWordsCount;

	// the constructor
	public CheckStates() 
	{
		super();
	}

	// getters
	public String getStatesNotFound() 
	{
		return statesNotFound;
	}
	
	public int getBadWordsCount()
	{
		return badWordsCount;
	}
	
	// this method takes both lists and loops through them comparing all the words
	// and compiling a count of words not found as well as a string of words not found
	public void checkDictionary(List<String> states, List<String> dictionary)
	{
		// this is used to see if it is the first instance of a word not found.
		int count = 0;
		
		// start the states loop
		for(int i = 0; i < states.size(); i++)
		{
			// declaring a variable to flag if a word is found or not
			// and setting the states value to a string
			boolean isFound = false;
			String state = states.get(i);
			
			// start the dictionary loop
			for(int k = 0; k < dictionary.size(); k++)
			{
				// set dictionary value to a string
				String dic = dictionary.get(k);
				
				// compare the 2 strings if a match then flag as found and break out of the dictionary loop
				// if not found then flag as not found and continue looping through the dictionary
				if(Objects.equals(state, dic))
				{
					isFound = true;
					break;
				}
				else
				{
					isFound = false;
				}
			}
			
			// evaluate the isFound flag and do stuff
			if(!isFound)
			{
				// if count hasn't yet been incremented then it is the first word to not be found
				// and start the string, otherwise append to existing string
				if(count == 0)
				{
					statesNotFound = states.get(i).toString();
				}
				else
				{
					statesNotFound = statesNotFound + ", " + states.get(i).toString();
				}
				
				// increment counter
				count++;
			}
		}
		
		// set badWordCount = to count. This is used below in the toString.
		badWordsCount = count;
	}

	@Override
	public String toString() 
	{
		return "CheckStates [Number of states not found: " + Integer.toString(getBadWordsCount()) +  ", and the states not found list is: " + statesNotFound + "]";
	}

}
