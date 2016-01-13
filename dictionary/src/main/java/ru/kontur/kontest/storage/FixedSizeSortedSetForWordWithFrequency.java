package ru.kontur.kontest.storage;

import java.util.SortedSet;
import java.util.TreeSet;

public class FixedSizeSortedSetForWordWithFrequency {

	private final SortedSet<WordWithFrequency> sortedSet;
	
	public FixedSizeSortedSetForWordWithFrequency() {
		this.sortedSet = new TreeSet<WordWithFrequency>();
	}
	
	public void add(WordWithFrequency wordWithFrequency) {
		sortedSet.add(wordWithFrequency);
	}

	public WordWithFrequency[] toArray() {
		return sortedSet.toArray(new WordWithFrequency[0]);
	}

}
