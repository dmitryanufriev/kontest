package ru.kontur.kontest.storage;

public class WordWithFrequency implements Comparable<WordWithFrequency> {

	private final String word;
	private final int frequency;

	public WordWithFrequency(String word, int frequency) {
		this.word = word;
		this.frequency = frequency;
	}

	public int compareTo(WordWithFrequency wordWithFrequency) {
		int frequenciesComparisonResult = wordWithFrequency.frequency - frequency;
		
		if (frequenciesComparisonResult == 0) { // Частоты одинаковые, сравниваем слова
			return word.compareTo(wordWithFrequency.word);
		}
		
		return frequenciesComparisonResult;
	}

	@Override
	public String toString() {
		return String.format("Word: %s, Frequency: %d", word, frequency);
	}

}
