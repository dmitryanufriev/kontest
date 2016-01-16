package ru.kontur.kontest.console.io;

import static org.mockito.Mockito.*;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.junit.*;

import ru.kontur.kontest.console.io.listeners.TestDataListener;

public class DataReaderTest {

	@Test
	public void readerShouldReadFirstLineAsCountOfWords() throws IOException {
		DataReader dataReader = new DataReader();
		
		InputStream dataStream = new ByteArrayInputStream("1\nword 10".getBytes());
		
		TestDataListener listener = mock(TestDataListener.class);
		dataReader.readFrom(dataStream, listener);
		
		verify(listener).wordsCount(1);
	}
	
}
