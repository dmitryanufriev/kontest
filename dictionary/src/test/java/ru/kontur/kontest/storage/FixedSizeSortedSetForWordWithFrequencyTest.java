package ru.kontur.kontest.storage;

import static org.junit.Assert.*;

import org.junit.*;

public class FixedSizeSortedSetForWordWithFrequencyTest {
	
	@Test
	public void wordsWithFrequenciesShouldBeAddedInSortOrder() {
		WordWithFrequency a = new WordWithFrequency("a", 1);
		WordWithFrequency b = new WordWithFrequency("b", 9);
		WordWithFrequency c = new WordWithFrequency("c", 8);
		WordWithFrequency d = new WordWithFrequency("d", 7);
		WordWithFrequency e = new WordWithFrequency("e", 6);
		WordWithFrequency f = new WordWithFrequency("f", 5);
		WordWithFrequency g = new WordWithFrequency("g", 7);
		WordWithFrequency h = new WordWithFrequency("h", 3);
		WordWithFrequency i = new WordWithFrequency("i", 2);
		WordWithFrequency j = new WordWithFrequency("j", 10);
		
		FixedSizeSortedSetForWordWithFrequency set = new FixedSizeSortedSetForWordWithFrequency();
		
		for (WordWithFrequency wordWithFrequency : new WordWithFrequency[] { a, b, c, d, e, f, g, h, i, j }) {
			set.add(wordWithFrequency);
		}
		
		assertArrayEquals(new WordWithFrequency[] { j, b, c, d, g, e, f, h, i, a }, set.toArray());
	}
	
}
