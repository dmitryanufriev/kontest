package ru.kontur.kontest.io;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;

import org.junit.*;

import ru.kontur.kontest.io.OutputWriter;
import ru.kontur.kontest.words.WordWithFrequency;

public class OutputWriterTest {

	@Test
	public void outputWriterShouldWriteWordsToOutputWithNewLineAtTheEnd() throws IOException {
		WordWithFrequency a = new WordWithFrequency("a", 10);
		WordWithFrequency b = new WordWithFrequency("b", 10);
		WordWithFrequency[] words = new WordWithFrequency[] { a, b };
		
		OutputWriter outputWriter = new OutputWriter();
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		
		outputWriter.writeWordsToStream(Arrays.asList(words), outputStream);
		
		assertEquals("a\nb\n\n", outputStream.toString());
	}
	
	@Test
	public void outputWriterShouldWriteNothingWhenNoFoundWords() throws IOException {
		OutputWriter outputWriter = new OutputWriter();
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		
		outputWriter.writeWordsToStream(Collections.<WordWithFrequency>emptyList(), outputStream);
		
		assertEquals(0, outputStream.size());
	}
	
}
