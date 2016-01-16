package ru.kontur.kontest.storages;

import java.util.ArrayList;
import java.util.Collection;
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

	public Collection<WordWithFrequency> searchWordsBy(Prefix prefix) {
		final ArrayList<WordWithFrequency> words = new ArrayList<WordWithFrequency>();
		searchWordsBy(prefix, new SearchListener() {
			
			@Override
			public boolean stopSearching() {
				return false;
			}
			
			@Override
			public void foundWord(WordWithFrequency wordWithFrequency) {
				words.add(wordWithFrequency);
			}
		});
		
		return words;
	}
	
	public Collection<WordWithFrequency> searchWordsBy(Prefix prefix, final int count) {
		final ArrayList<WordWithFrequency> words = new ArrayList<WordWithFrequency>();
		searchWordsBy(prefix, new SearchListener() {
			
			@Override
			public boolean stopSearching() {
				return words.size() >= count;
			}
			
			@Override
			public void foundWord(WordWithFrequency wordWithFrequency) {
				words.add(wordWithFrequency);
			}
		});
		
		return words;
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
