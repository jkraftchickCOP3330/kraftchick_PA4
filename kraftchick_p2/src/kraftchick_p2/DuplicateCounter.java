package kraftchick_p2;

import java.io.File;
import java.util.Scanner;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.Map;
import java.util.HashMap;

public class DuplicateCounter 
{
	private HashMap<String, Integer> wordCounter = new HashMap<String, Integer>();
	
	public void count(String dataFile) throws IOException
	{
		Scanner file = new Scanner(new File(dataFile));
		
		while (file.hasNext())
		{
			String word = file.next();
			
			if (wordCounter.putIfAbsent(word, 1) != null)
			{
				wordCounter.replace(word, wordCounter.get(word) + 1);
			}
		}
		
		file.close();
	}
	
	public void write(String outputFile) throws IOException
	{
		PrintWriter fileOut = new PrintWriter(new File(outputFile));
		
		for (Map.Entry<String, Integer> wordCount : wordCounter.entrySet())
		{
			fileOut.println(wordCount.getKey() + " " + wordCount.getValue());
		}
		
		fileOut.close();
	}
}