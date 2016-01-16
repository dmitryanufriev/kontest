package ru.kontur.kontest.console.io;

import static org.mockito.Mockito.*;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.junit.*;

import ru.kontur.kontest.console.io.listeners.TestDataListener;
import ru.kontur.kontest.words.Prefix;
import ru.kontur.kontest.words.WordWithFrequency;

public class DataReaderTest {

	@Test
	public void readerShouldReadCountOfWords() throws IOException {
		DataReader dataReader = new DataReader();
		
		InputStream dataStream = new ByteArrayInputStream("1\nword 10".getBytes());
		
		TestDataListener listener = mock(TestDataListener.class);
		dataReader.readFrom(dataStream, listener);
		
		verify(listener).wordsCount(1);
	}
	
	@Test
	public void readerShouldReadAllWords() throws IOException {
		DataReader dataReader = new DataReader();
		
		InputStream dataStream = new ByteArrayInputStream("2\nfirst 10\nsecond 20".getBytes());
		
		TestDataListener listener = mock(TestDataListener.class);
		dataReader.readFrom(dataStream, listener);

		verify(listener).nextWord(new WordWithFrequency("first", 10));
		verify(listener).nextWord(new WordWithFrequency("second", 20));
	}
	
	@Test
	public void readerShouldReadCountOfPrefixes() throws IOException {
		DataReader dataReader = new DataReader();
		
		InputStream dataStream = new ByteArrayInputStream("1\nfirst 10\n2".getBytes());
		
		TestDataListener listener = mock(TestDataListener.class);
		dataReader.readFrom(dataStream, listener);

		verify(listener).prefixesCount(2);
	}
	
	@Test
	public void readerShouldReadAllPrefixes() throws IOException {
		DataReader dataReader = new DataReader();
		
		InputStream dataStream = new ByteArrayInputStream("1\nfirst 10\n2\na\nb".getBytes());
		
		TestDataListener listener = mock(TestDataListener.class);
		dataReader.readFrom(dataStream, listener);

		verify(listener).nextPrefix(new Prefix("a"));
		verify(listener).nextPrefix(new Prefix("b"));
	}
	
	@Test
	public void readerShouldReadExactAmountOfPrefixes() throws IOException {
		DataReader dataReader = new DataReader();
		
		InputStream dataStream = new ByteArrayInputStream("1\nfirst 10\n2\na\nb\nUnexpected".getBytes());
		
		TestDataListener listener = mock(TestDataListener.class);
		dataReader.readFrom(dataStream, listener);

		verify(listener).nextPrefix(new Prefix("a"));
		verify(listener).nextPrefix(new Prefix("b"));
		verify(listener, never()).nextPrefix(new Prefix("Unexpected"));
	}
	
}
