package ru.kontur.kontest.storage;

import java.util.Collection;
import java.util.HashSet;

public class WordWithFrequency implements Comparable<WordWithFrequency> {

	private final String word;
	private final int frequency;
	
	private HashSet<Prefix> prefixes;

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


	public void addToCollectionForMatchedPrefix(Prefix prefix, Collection<WordWithFrequency> collection) {
		if (prefixes == null) {
			prefixes = generatePrefixesFor(word);
		}
		
		if (prefixes.contains(prefix)) {
			collection.add(this);
		}
	}
	
	private static HashSet<Prefix> generatePrefixesFor(String word) {
		final int prefixesCount = word.length();
		HashSet<Prefix> prefixes = new HashSet<Prefix>(prefixesCount);
		for (int i = 1; i <= prefixesCount; i++) {
			prefixes.add(new Prefix(word.substring(0, i)));
		}
		return prefixes;
	}

	@Override
	public String toString() {
		return String.format("Word: %s, Frequency: %d", word, frequency);
	}

}
