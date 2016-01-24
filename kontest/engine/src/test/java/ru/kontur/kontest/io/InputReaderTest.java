package ru.kontur.kontest.io;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

import ru.kontur.kontest.io.listeners.TestDataListener;
import ru.kontur.kontest.words.Prefix;
import ru.kontur.kontest.words.WordWithFrequency;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

public class InputReaderTest {

  @Before
  public void setUp() {
    inputReader = new InputReader();
    testDataListener = mock(TestDataListener.class);
  }

  @Test
  public void readerShouldReadCountOfWords() throws IOException {
    InputStream dataStream = new ByteArrayInputStream("1\nword 10".getBytes());

    inputReader.readFrom(dataStream, testDataListener);

    verify(testDataListener).wordsCount(1);
  }

  @Test
  public void readerShouldReadAllWords() throws IOException {
    InputStream dataStream = new ByteArrayInputStream("2\nfirst 10\nsecond 20".getBytes());

    inputReader.readFrom(dataStream, testDataListener);

    verify(testDataListener).nextWord(new WordWithFrequency("first", 10));
    verify(testDataListener).nextWord(new WordWithFrequency("second", 20));
  }

  @Test
  public void readerShouldReadCountOfPrefixes() throws IOException {
    InputStream dataStream = new ByteArrayInputStream("1\nfirst 10\n2".getBytes());

    inputReader.readFrom(dataStream, testDataListener);

    verify(testDataListener).prefixesCount(2);
  }

  @Test
  public void readerShouldReadAllPrefixes() throws IOException {
    InputStream dataStream = new ByteArrayInputStream("1\nfirst 10\n2\na\nb".getBytes());

    inputReader.readFrom(dataStream, testDataListener);

    verify(testDataListener).nextPrefix(new Prefix("a"));
    verify(testDataListener).nextPrefix(new Prefix("b"));
  }

  @Test
  public void readerShouldReadExactAmountOfPrefixes() throws IOException {
    InputStream dataStream = new ByteArrayInputStream("1\nfirst 10\n2\na\nb\nUnexpected".getBytes());

    inputReader.readFrom(dataStream, testDataListener);

    verify(testDataListener).nextPrefix(new Prefix("a"));
    verify(testDataListener).nextPrefix(new Prefix("b"));
    verify(testDataListener, never()).nextPrefix(new Prefix("Unexpected"));
  }

  private InputReader inputReader;
  private TestDataListener testDataListener;
}
