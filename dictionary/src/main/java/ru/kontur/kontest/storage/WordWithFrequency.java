package ru.kontur.kontest.storage;

import java.util.Collection;

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

	public void addToCollectionForMatchedPrefix(Prefix prefix, Collection<WordWithFrequency> collection) {
		if (new Prefix(word).equals(prefix)) {
			collection.add(this);
		}
	}

}
