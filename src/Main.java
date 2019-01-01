import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Main {

	public static void main(String[] args) {
		
			try {
				/*
				 * 						List of Cases to Check For
				 * 					-----------------------------------
				 * 					1. If there's an apostrophe between two letters, save it as a word
				 * 					1a. ALICE vs ALICE'S vs ALICES (remove apostrophe if it's followed by an S, otherwise don't
				 * 					2. Remove punctuation like comma's and periods and tildrs
				 * 					3.  make sure its not case sensitive
				 * 					4. numbers are words
				 */
				HashMap<String, Word> wordList = new HashMap<String, Word>();
				BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
				String line = reader.readLine();
				while(line != null)
				{
					//do stuff
					StringTokenizer st = new StringTokenizer(line);
					while(st.hasMoreTokens())
					{
						String s = st.nextToken();
						if(wordList.get(s.toLowerCase())== null ){
							Word word = new Word(s);
							wordList.put(s.toLowerCase(), word);
						}
						else
						{
							wordList.get(s.toLowerCase()).incrementFrequency();
						}
						
					}
					line = reader.readLine();
				}
				
				System.out.println("20 most frequent words \nWord       Frequency");
				Iterator it = wordList.keySet().iterator();
				ArrayList<Word> sortedList = new ArrayList<Word>();
				while(it.hasNext())
				{
					sortedList.add(wordList.get(it.next()));
				}
				Collections.sort(sortedList);
				for(Word wrd: sortedList)
				{
					System.out.println(wrd + " " + wrd.getFrequency());
				}
				
			} catch (FileNotFoundException e) {
				
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	}

}
