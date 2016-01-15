package ru.kontur.kontest.console.io;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.junit.*;

public class DataReaderTest {

	@Test
	public void readerShouldReadFirstLineAsCountOfWords() {
		DataReader dataReader = new DataReader();
		
		InputStream inputStream = new ByteArrayInputStream("1\nsome line 10".getBytes());
		
		dataReader.readFrom(inputStream);
	}
	
}
