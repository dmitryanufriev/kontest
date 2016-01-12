package ru.kontur.kontest.storage;

public class WordWithFrequency implements Comparable<WordWithFrequency> {

	private String word;
	private int frequency;

	public WordWithFrequency(String word, int frequency) {
		this.word = word;
		this.frequency = frequency;
	}

	public int compareTo(WordWithFrequency wordWithFrequency) {
		int comparisonResult = wordWithFrequency.frequency - frequency;
		
		if (comparisonResult == 0) { // Частоты одинаковые, сравниваем слова
			return word.compareTo(wordWithFrequency.word);
		}
		
		return comparisonResult;
	}

	@Override
	public String toString() {
		return String.format("Word: %s, Frequency: %d", word, frequency);
	}

}
