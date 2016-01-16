package ru.kontur.kontest.console.io;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Arrays;

import org.junit.*;

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
	
}
