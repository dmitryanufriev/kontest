package ru.kontur.kontest.storage;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.*;

public class WordWithFrequencyTest {
	
	private static final int FEWER_FREQUENCY = 5;
	private static final int HIGHER_FREQUENCY = 10;

	@Test
	public void wordWithHigherFrequencyShouldBeLessThanWordWithFewerFrequency() {
		WordWithFrequency wordWithFrequency = new WordWithFrequency("a", HIGHER_FREQUENCY);
		
		String msg = "Word with frequency " + HIGHER_FREQUENCY + " should be less than word with frequency " + FEWER_FREQUENCY;
		assertTrue(msg, wordWithFrequency.compareTo(new WordWithFrequency("a", FEWER_FREQUENCY)) < 0);
	}
	
	@Test
	public void wordWithFewerFrequencyShouldBeGreaterThanWordWithHigherFrequency() {
		WordWithFrequency wordWithFrequency = new WordWithFrequency("a", FEWER_FREQUENCY);
		
		String msg = "Word with frequency " + FEWER_FREQUENCY + " should be greater than word with frequency " + HIGHER_FREQUENCY;
		assertTrue(msg, wordWithFrequency.compareTo(new WordWithFrequency("a", HIGHER_FREQUENCY)) > 0);
	}
	
	@Test
	public void wordsShoudBeSortedByFrequencyInDescendingOrder() {
		WordWithFrequency a = new WordWithFrequency("a", FEWER_FREQUENCY);
		WordWithFrequency b = new WordWithFrequency("b", HIGHER_FREQUENCY);
		WordWithFrequency[] words = new WordWithFrequency[] { a, b };
		
		Arrays.sort(words);
		
		assertArrayEquals(new WordWithFrequency[] { b, a },  words);
	}
	
	@Test
	public void wordsWithSameFrequencyShouldBeComparedInNaturalOrder() {
		WordWithFrequency a = new WordWithFrequency("A", HIGHER_FREQUENCY);
		WordWithFrequency b = new WordWithFrequency("B", HIGHER_FREQUENCY);
		
		String msg = "Слово \"A\" с частотой " + HIGHER_FREQUENCY + " должно быть меньше слова \"B\" с частотой " + HIGHER_FREQUENCY;
		
		assertSame(msg, a.compareTo(b), "A".compareTo("B"));
	}
}
