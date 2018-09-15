package weathermanModule3;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class SpellChecker 
{

	public static void main(String[] args) 
	{
		// initialize variables to be used
		List<String> states = new ArrayList<String>();
		List<String> statesDictionary = new ArrayList<String>();
		
		String pathStates = "C:\\Users\\Rob\\Desktop\\SoftwareDev_01\\Module3Files\\";
		String statesFile = "States.txt";
		Path statesPath = FileSystems.getDefault().getPath(pathStates, statesFile);
		
		String pathDictionary = "C:\\Users\\Rob\\Desktop\\SoftwareDev_01\\Module3Files\\";
		String dictionaryFile = "Dictionary.txt";
		Path dictionaryPath = FileSystems.getDefault().getPath(pathDictionary, dictionaryFile);
		
		// initialize the CheckStates object
		CheckStates check = new CheckStates();
		
		// read in both files
		try 
		{
			states = Files.readAllLines(statesPath);
			statesDictionary = Files.readAllLines(dictionaryPath);
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// call the method to check states in the list
		check.checkDictionary(states, statesDictionary);
		
		// print results
		System.out.println(check.toString());
	}

}
