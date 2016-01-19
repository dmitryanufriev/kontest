package ru.kontur.kontest.io;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

import ru.kontur.kontest.words.WordWithFrequency;

public class OutputWriter {

	public void writeWordsToStream(Iterable<WordWithFrequency> words, OutputStream outputStream) throws IOException {
		StringBuilder stringBuilder = new StringBuilder();
		for (WordWithFrequency word : words) {
			stringBuilder.append(word);
			stringBuilder.append("\n");
		}

		if (stringBuilder.length() > 0) {
			stringBuilder.append('\n');

			BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
			bufferedWriter.write(stringBuilder.toString());
			bufferedWriter.flush();

		}

	}

}
