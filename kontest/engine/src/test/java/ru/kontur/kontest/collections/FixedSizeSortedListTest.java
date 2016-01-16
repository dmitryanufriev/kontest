package ru.kontur.kontest.collections;

import static org.junit.Assert.*;

import org.junit.*;

import ru.kontur.kontest.words.WordWithFrequency;

public class FixedSizeSortedListTest {
	
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
	private FixedSizeSortedList<WordWithFrequency> sortedList;

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
		
		sortedList = new FixedSizeSortedList<WordWithFrequency>(10);
		
		for (WordWithFrequency wordWithFrequency : new WordWithFrequency[] { a, b, c, d, e, f, g, h, i, j }) {
			sortedList.add(wordWithFrequency);
		}		
	}
	
	@Test
	public void wordsWithFrequenciesShouldBeAddedInSortOrder() {
		assertArrayEquals(new WordWithFrequency[] { j, b, c, d, g, e, f, h, i, a }, sortedList.toArray(new WordWithFrequency[0]));
	}
	
	@Test
	public void sortedListShouldBeFixedSize() {
		WordWithFrequency z = new WordWithFrequency("z", 11);
		sortedList.add(z);
		
		assertArrayEquals(new WordWithFrequency[] { z, j, b, c, d, g, e, f, h, i }, sortedList.toArray(new WordWithFrequency[0]));
	}
	
	@Test
	public void wordWithSmallFrequencyShouldNotBeAddedToSet() {
		WordWithFrequency z = new WordWithFrequency("z", 0);
		sortedList.add(z);
		
		assertArrayEquals(new WordWithFrequency[] { j, b, c, d, g, e, f, h, i, a }, sortedList.toArray(new WordWithFrequency[0]));
	}
	
}
