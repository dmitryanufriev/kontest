package ru.kontur.kontest.words;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import java.util.Arrays;

public class WordWithFrequencyTest {

  @Test
  public void wordWithHigherFrequencyShouldBeLessThanWordWithFewerFrequency() {
    WordWithFrequency wordWithFrequency = new WordWithFrequency("a", HIGHER_FREQUENCY);

    String msg = "Слово с частотой " + HIGHER_FREQUENCY
        + " должно быть меньше, чем слово с частотой " + FEWER_FREQUENCY;
    assertTrue(msg, wordWithFrequency.compareTo(new WordWithFrequency("a", FEWER_FREQUENCY)) < 0);
  }

  @Test
  public void wordWithFewerFrequencyShouldBeGreaterThanWordWithHigherFrequency() {
    WordWithFrequency wordWithFrequency = new WordWithFrequency("a", FEWER_FREQUENCY);

    String msg = "Слово с частотой " + FEWER_FREQUENCY
        + " должно быть больше, чем слово с частотой " + HIGHER_FREQUENCY;
    assertTrue(msg, wordWithFrequency.compareTo(new WordWithFrequency("a", HIGHER_FREQUENCY)) > 0);
  }

  @Test
  public void wordsShoudBeSortedByFrequencyInDescendingOrder() {
    WordWithFrequency a = new WordWithFrequency("a", FEWER_FREQUENCY);
    WordWithFrequency b = new WordWithFrequency("b", HIGHER_FREQUENCY);
    WordWithFrequency[] words = new WordWithFrequency[] { a, b };

    Arrays.sort(words);

    assertArrayEquals(new WordWithFrequency[] { b, a }, words);
  }

  @Test
  public void wordsWithSameFrequencyShouldBeComparedInNaturalOrder() {
    WordWithFrequency a = new WordWithFrequency("A", HIGHER_FREQUENCY);
    WordWithFrequency b = new WordWithFrequency("B", HIGHER_FREQUENCY);

    assertSame(a.compareTo(b), "A".compareTo("B"));
  }

  @Test
  public void wordsWithSameWordsAndFrequenciesShouldBeEquals() {
    assertEquals(new WordWithFrequency("a", HIGHER_FREQUENCY), new WordWithFrequency("a",
        HIGHER_FREQUENCY));
  }

  @Test
  public void wordWithFrequencyAsStringShouldBeEqualToWord() {
    WordWithFrequency wordWithFrequency = new WordWithFrequency("a", 0);

    assertEquals("a", wordWithFrequency.toString());
  }

  @Test
  public void wordShouldReturnItsPrefixes() {
    WordWithFrequency abc = new WordWithFrequency("abc", 10);

    assertArrayEquals(new Prefix[] { new Prefix("a"), new Prefix("ab"), new Prefix("abc") },
        abc.getPrefixes());
  }

  private static final int FEWER_FREQUENCY = 5;
  private static final int HIGHER_FREQUENCY = 10;
}
