package ru.kontur.kontest.storage;

import static org.junit.Assert.*;

import org.junit.*;

public class FixedSizeSortedSetForWordWithFrequencyTest {
	
	private WordWithFrequency a;
	private WordWithFrequency b;
	private WordWithFrequency c;
	private WordWithFrequency d;
	private WordWithFrequency e;
	private WordWithFrequency f;
	private WordWithFrequency g;
	private WordWithFrequency h;
	private WordWithFrequency i;
	private WordWithFrequency j;

	@Before
	public void setUp() {
		a = new WordWithFrequency("a", 1);
		b = new WordWithFrequency("b", 9);
		c = new WordWithFrequency("c", 8);
		d = new WordWithFrequency("d", 7);
		e = new WordWithFrequency("e", 6);
		f = new WordWithFrequency("f", 5);
		g = new WordWithFrequency("g", 7);
		h = new WordWithFrequency("h", 3);
		i = new WordWithFrequency("i", 2);
		j = new WordWithFrequency("j", 10);
	}
	
	@Test
	public void wordsWithFrequenciesShouldBeAddedInSortOrder() {
		
		FixedSizeSortedSetForWordWithFrequency set = new FixedSizeSortedSetForWordWithFrequency(10);
		
		for (WordWithFrequency wordWithFrequency : new WordWithFrequency[] { a, b, c, d, e, f, g, h, i, j }) {
			set.add(wordWithFrequency);
		}
		
		assertArrayEquals(new WordWithFrequency[] { j, b, c, d, g, e, f, h, i, a }, set.toArray());
	}
	
	@Test
	public void sortedSetShouldBeFixedSize() {
		
		FixedSizeSortedSetForWordWithFrequency set = new FixedSizeSortedSetForWordWithFrequency(10);
		
		for (WordWithFrequency wordWithFrequency : new WordWithFrequency[] { a, b, c, d, e, f, g, h, i, j }) {
			set.add(wordWithFrequency);
		}
		
		WordWithFrequency z = new WordWithFrequency("z", 11);
		set.add(z);
		
		assertArrayEquals(new WordWithFrequency[] { z, j, b, c, d, g, e, f, h, i }, set.toArray());
	}
	
}
