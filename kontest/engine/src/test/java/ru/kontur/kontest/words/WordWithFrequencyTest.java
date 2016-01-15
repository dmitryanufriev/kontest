package ru.kontur.kontest.words;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.*;

import ru.kontur.kontest.words.Prefix;
import ru.kontur.kontest.words.WordWithFrequency;

public class WordWithFrequencyTest {
	
	private static final int FEWER_FREQUENCY = 5;
	private static final int HIGHER_FREQUENCY = 10;

	@Test
	public void wordWithHigherFrequencyShouldBeLessThanWordWithFewerFrequency() {
		WordWithFrequency wordWithFrequency = new WordWithFrequency("a", HIGHER_FREQUENCY);
		
		String msg = "Слово с частотой " + HIGHER_FREQUENCY + " должно быть меньше, чем слово с частотой " + FEWER_FREQUENCY;
		assertTrue(msg, wordWithFrequency.compareTo(new WordWithFrequency("a", FEWER_FREQUENCY)) < 0);
	}
	
	@Test
	public void wordWithFewerFrequencyShouldBeGreaterThanWordWithHigherFrequency() {
		WordWithFrequency wordWithFrequency = new WordWithFrequency("a", FEWER_FREQUENCY);
		
		String msg = "Слово с частотой " + FEWER_FREQUENCY + " должно быть больше, чем слово с частотой " + HIGHER_FREQUENCY;
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
		
	@Test
	public void wordsWithSameWordsAndFrequenciesShouldBeEquals() {		
		assertEquals(new WordWithFrequency("a", HIGHER_FREQUENCY), new WordWithFrequency("a", HIGHER_FREQUENCY));
	}
	
	@Test
	public void wordWithFrequencyAsStringShouldBeEqualToWord() {
		WordWithFrequency wordWithFrequency = new WordWithFrequency("a", 0);
		
		assertEquals("a", wordWithFrequency.toString());
	}
	
	@Test
	public void wordShouldMatchToSameAsWordPrefix() {
		WordWithFrequency wordWithFrequency = new WordWithFrequency("a", HIGHER_FREQUENCY);
		Prefix prefix = new Prefix("a");
		
		assertTrue("Слово " + wordWithFrequency + " должно соответствовать префиксу " + prefix, wordWithFrequency.isMatchTo(prefix));
	}
	
	@Test
	public void wordShouldMathToStartOfWordPrefix() {
		WordWithFrequency wordWithFrequency = new WordWithFrequency("word", HIGHER_FREQUENCY);
		Prefix prefix = new Prefix("wo");
		
		assertTrue("Слово " + wordWithFrequency + " должно соответствовать префиксу " + prefix, wordWithFrequency.isMatchTo(prefix));
	}
}
