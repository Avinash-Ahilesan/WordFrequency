import java.util.Comparator;

public class Word implements Comparable<Word>{

	private int frequency = 0;
	private String word;
	public Word(String word)
	{
		setWord(word);
		frequency =1;
	}
	public String getWord() {
		return word;
	}
	public void setWord(String word) {
		this.word = word;
	}
	public int getFrequency() {
		return frequency;
	}
	public void incrementFrequency()
	{
		frequency++;
	}
	
	public String toString()
	{
		return word;
	}
	@Override
	public int compareTo(Word wordToCompare) {
		// TODO Auto-generated method stub
		return wordToCompare.frequency - this.frequency;
	}
	
}
