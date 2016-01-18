package ru.kontur.kontest.storages;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;

import ru.kontur.kontest.collections.FixedSizeSortedList;
import ru.kontur.kontest.words.Prefix;
import ru.kontur.kontest.words.WordWithFrequency;

public class HashMapStorage implements Storage {
	
	private final HashMap<Prefix, FixedSizeSortedList<WordWithFrequency>> storage;
	private final int countOfWordsForPrefix;
	
	public HashMapStorage(int countOfWordsForPrefix) {
		storage = new HashMap<Prefix, FixedSizeSortedList<WordWithFrequency>>();
		this.countOfWordsForPrefix = countOfWordsForPrefix;
	}
	
	public HashMapStorage(int storageSize, int countOfWordsForPrefix) {
		storage = new HashMap<Prefix, FixedSizeSortedList<WordWithFrequency>>(storageSize);
		this.countOfWordsForPrefix = countOfWordsForPrefix;
	}

	/* (non-Javadoc)
	 * @see ru.kontur.kontest.storages.Storage#put(ru.kontur.kontest.words.WordWithFrequency)
	 */
	@Override
	public void put(WordWithFrequency wordWithFrequency) {
		Prefix[] prefixes = wordWithFrequency.getPrefixes();
		for (Prefix prefix : prefixes) {
			if ( ! storage.containsKey(prefix)) {
				storage.put(prefix, new FixedSizeSortedList<WordWithFrequency>(countOfWordsForPrefix));
			}
			
			storage.get(prefix).add(wordWithFrequency);
		}
	}

	/* (non-Javadoc)
	 * @see ru.kontur.kontest.storages.Storage#searchWordsBy(ru.kontur.kontest.words.Prefix)
	 */
	@Override
	public Collection<WordWithFrequency> searchWordsBy(Prefix prefix) {
		if ( ! storage.containsKey(prefix)) {
			return Collections.emptyList();
		}
		
		return storage.get(prefix).asCollection();
	}

}
