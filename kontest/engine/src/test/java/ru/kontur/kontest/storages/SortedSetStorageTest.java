package ru.kontur.kontest.storages;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.*;

import ru.kontur.kontest.storages.listeners.SearchListener;
import ru.kontur.kontest.words.Prefix;
import ru.kontur.kontest.words.WordWithFrequency;

public class SortedSetStorageTest {

	private SortedSetStorage storage;

	@Before
	public void setUp() {
		storage = new SortedSetStorage();
		storage.put(new WordWithFrequency("kare", 10));
		storage.put(new WordWithFrequency("kanojo", 20));
		storage.put(new WordWithFrequency("karetachi", 10));
		storage.put(new WordWithFrequency("korosu", 7));
		storage.put(new WordWithFrequency("sakura", 3));
	}
	
	@Test
	public void storageShouldFindWordsByOneCharacterPrefix() {
		final String[] words = new String[4];
		
		findWords("k", words);		
		
		assertArrayEquals(new String[] { "kanojo", "kare", "karetachi", "korosu" }, words);
	}
	
	@Test
	public void storageShouldFindWordsByTwoCharactersPrefix() {
		final String[] words = new String[3];
		
		findWords("ka", words);		
		
		assertArrayEquals(new String[] { "kanojo", "kare", "karetachi" }, words);
	}
	
	@Test
	public void storageShouldFindWordsByThreeCharactersPrefix() {
		final String[] words = new String[2];
		
		findWords("kar", words);
		
		assertArrayEquals(new String[] { "kare", "karetachi" }, words);
	}
	
	@Test
	public void storageShouldBeAbleToStopSearching() {
		final String[] words = new String[2];
		
		storage.searchWordsBy(new Prefix("k"), new SearchListener() {
			int index = 0;
			public void foundWord(WordWithFrequency wordWithFrequency) {
				words[index] = wordWithFrequency.toString();
				index++;
			}
			
			public boolean stopSearching() {
				return index > 1;
			}
		});
		
		assertArrayEquals(new String[] { "kanojo", "kare" }, words);
	}
	
	@Test
	public void storageShouldReturnCollectionOfFoundWords() {
		Collection<WordWithFrequency> foundWords = storage.searchWordsBy(new Prefix("ka"));
		ArrayList<String> words = new ArrayList<String>();
		for (WordWithFrequency wordWithFrequency : foundWords) {
			words.add(wordWithFrequency.toString());
		}
		
		assertArrayEquals(new String[] { "kanojo", "kare", "karetachi" }, words.toArray(new String[0]));
	}
	
	@Test
	public void storageShouldReturnCollectionWithExactCountOfFoundWords() {
		Collection<WordWithFrequency> foundWords = storage.searchWordsBy(new Prefix("ka"), 2);
		ArrayList<String> words = new ArrayList<String>();
		for (WordWithFrequency wordWithFrequency : foundWords) {
			words.add(wordWithFrequency.toString());
		}
		
		assertArrayEquals(new String[] { "kanojo", "kare" }, words.toArray(new String[0]));
	}
	
	private void findWords(String prefix, final String[] words) {
		storage.searchWordsBy(new Prefix(prefix), new SearchListener() {
			int index = 0;
			public void foundWord(WordWithFrequency wordWithFrequency) {
				words[index] = wordWithFrequency.toString();
				index++;
			}
			
			public boolean stopSearching() {
				return false;
			}
		});
	}
	
}
