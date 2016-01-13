package ru.kontur.kontest.storage;

import java.util.SortedSet;
import java.util.TreeSet;

public class FixedSizeSortedSetForWordWithFrequency {

	private final SortedSet<WordWithFrequency> sortedSet;
	private final int size;
	
	public FixedSizeSortedSetForWordWithFrequency(int size) {
		this.size = size;
		this.sortedSet = new TreeSet<WordWithFrequency>();
	}

	public void add(WordWithFrequency wordWithFrequency) {
		if (sortedSet.size() == size) {
			sortedSet.remove(sortedSet.last());
		}
		sortedSet.add(wordWithFrequency);
	}

	public WordWithFrequency[] toArray() {
		return sortedSet.toArray(new WordWithFrequency[0]);
	}

}
