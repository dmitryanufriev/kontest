package ru.kontur.kontest.storages;

import static org.junit.Assert.assertArrayEquals;

import java.util.Collection;

import org.junit.Before;
import org.junit.Test;

import ru.kontur.kontest.words.Prefix;
import ru.kontur.kontest.words.WordWithFrequency;

public class HashMapStorageTest {
	private Storage storage;

	@Before
	public void setUp() {
		storage = new HashMapStorage(10);
		storage.put(new WordWithFrequency("kare", 10));
		storage.put(new WordWithFrequency("kanojo", 20));
		storage.put(new WordWithFrequency("karetachi", 10));
		storage.put(new WordWithFrequency("korosu", 7));
		storage.put(new WordWithFrequency("sakura", 3));
	}
	
	@Test
	public void storageShouldFindWordsByOneCharacterPrefix() {
		String[] words = findWordsBy("k");		
		
		assertArrayEquals(new String[] { "kanojo", "kare", "karetachi", "korosu" }, words);
	}
	
	@Test
	public void storageShouldFindWordsByTwoCharactersPrefix() {
		String[] words = findWordsBy("ka");		
		
		assertArrayEquals(new String[] { "kanojo", "kare", "karetachi" }, words);
	}
	
	@Test
	public void storageShouldFindWordsByThreeCharactersPrefix() {
		String[] words = findWordsBy("kar");
		
		assertArrayEquals(new String[] { "kare", "karetachi" }, words);
	}
	
	@Test
	public void searchResultShouldBeEmptyWhenWordsNotFound() {
		String[] words = findWordsBy("nonexistent");
		
		assertArrayEquals(new String[0], words);
	}
	
	@Test
	public void storageShouldSupportExactCountOfWords() {
		Storage storage = new HashMapStorage(2);
		WordWithFrequency kare = new WordWithFrequency("kare", 10);
		WordWithFrequency kanojo = new WordWithFrequency("kanojo", 20);
		WordWithFrequency karetachi = new WordWithFrequency("karetachi", 10);
		
		storage.put(kare);
		storage.put(kanojo);
		storage.put(karetachi);
		
		Collection<WordWithFrequency> foundWords = storage.searchWordsBy(new Prefix("ka"));
		
		assertArrayEquals(new WordWithFrequency[] { kanojo, kare }, foundWords.toArray(new WordWithFrequency[0]));
	}
	
	private String[] findWordsBy(String prefix) {
		Collection<WordWithFrequency> foundWords = storage.searchWordsBy(new Prefix(prefix));
		String[] words = new String[foundWords.size()];
		int index = 0;
		for (WordWithFrequency wordWithFrequency : foundWords) {
			words[index] = wordWithFrequency.toString();
			index++;
		}
		
		return words;
	}

}
