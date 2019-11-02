package kraftchick_p1;

import java.io.File;
import java.util.Scanner;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.HashSet;

public class DuplicateRemover 
{
	private HashSet<String> uniqueWords = new HashSet<String>();
	
	public void remove(String dataFile) throws IOException
	{
		Scanner file = new Scanner(new File(dataFile));
		
		while (file.hasNext())
		{
			uniqueWords.add(file.next());
		}
		
		file.close();
	}
	
	public void write(String outputFile) throws IOException
	{
		PrintWriter fileOut = new PrintWriter(new File(outputFile));
		
		for (String word : uniqueWords)
		{
			fileOut.println(word);
		}
		
		fileOut.close();
	}
}
