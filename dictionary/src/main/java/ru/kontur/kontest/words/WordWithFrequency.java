package ru.kontur.kontest.words;

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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + frequency;
		result = prime * result + ((word == null) ? 0 : word.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		
		if (obj == null) {
			return false;
		}
		
		if (getClass() != obj.getClass()) {
			return false;
		}
		
		WordWithFrequency other = (WordWithFrequency) obj;
		if (frequency != other.frequency) {
			return false;
		}
		
		if (word == null) {
			if (other.word != null) {
				return false;
			}
		} else if (!word.equals(other.word)) {
			return false;
		}
		
		return true;
	}

	@Override
	public String toString() {
		return String.format("Word: %s, Frequency: %d", word, frequency);
	}

}
