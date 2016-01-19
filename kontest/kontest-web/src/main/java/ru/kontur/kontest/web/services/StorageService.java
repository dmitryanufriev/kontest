package ru.kontur.kontest.web.services;

import ru.kontur.kontest.storages.HashMapStorage;
import ru.kontur.kontest.storages.Storage;
import ru.kontur.kontest.words.WordWithFrequency;

public class StorageService {

	public Storage getStorage() {
		HashMapStorage hashMapStorage = new HashMapStorage(10, 10);
		
		hashMapStorage.put(new WordWithFrequency("kare", 10));
		hashMapStorage.put(new WordWithFrequency("kanojo", 20));
		hashMapStorage.put(new WordWithFrequency("karetachi", 10));
		hashMapStorage.put(new WordWithFrequency("korosu", 7));
		hashMapStorage.put(new WordWithFrequency("sakura", 3));
		
		return hashMapStorage;
	}

}
