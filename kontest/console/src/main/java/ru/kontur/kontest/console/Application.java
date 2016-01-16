package ru.kontur.kontest.console;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Collection;

import ru.kontur.kontest.console.io.InputReader;
import ru.kontur.kontest.console.io.OutputWriter;
import ru.kontur.kontest.console.io.listeners.TestDataListener;
import ru.kontur.kontest.storages.HashMapStorage;
import ru.kontur.kontest.words.Prefix;
import ru.kontur.kontest.words.WordWithFrequency;

public class Application {

	private static final int WORDS_COUNT = 10;

	public void execute(InputStream inputStream, final OutputStream outputStream) throws IOException {
		InputReader inputReader = new InputReader();
		inputReader.readFrom(inputStream, new TestDataListener() {
			private final OutputWriter outputWriter = new OutputWriter();
			private HashMapStorage storage;
			
			@Override
			public void wordsCount(int count) {
				storage = new HashMapStorage(count, WORDS_COUNT);
			}
			
			@Override
			public void prefixesCount(int count) {
			}
			
			@Override
			public void nextWord(WordWithFrequency wordWithFrequency) {
				storage.put(wordWithFrequency);				
			}
			
			@Override
			public void nextPrefix(Prefix prefix) {
				Collection<WordWithFrequency> foundWords = storage.searchWordsBy(prefix);
				try {
					outputWriter.writeWordsToStream(foundWords, outputStream);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});
	}
	
}
