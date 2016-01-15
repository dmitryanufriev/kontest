package ru.kontur.kontest.storages;

import java.util.TreeSet;

import ru.kontur.kontest.storages.listeners.SearchListener;
import ru.kontur.kontest.words.Prefix;
import ru.kontur.kontest.words.WordWithFrequency;

public class SortedSetStorage {
	
	private final TreeSet<WordWithFrequency> sortedSet;
	
	public SortedSetStorage() {
		this.sortedSet = new TreeSet<WordWithFrequency>();
	}

	public void put(WordWithFrequency wordWithFrequency) {
		sortedSet.add(wordWithFrequency);
	}

	public void searchWordsBy(Prefix prefix, SearchListener searchListener) {
		for (WordWithFrequency wordWithFrequency : sortedSet) {
			if (wordWithFrequency.isMatchTo(prefix)) {
				searchListener.foundWord(wordWithFrequency);
			}
			
			if (searchListener.stopSearching()) {
				break;
			}
		}
	}

}
