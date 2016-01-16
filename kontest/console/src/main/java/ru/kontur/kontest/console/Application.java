package ru.kontur.kontest.console;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Collection;

import ru.kontur.kontest.console.io.InputReader;
import ru.kontur.kontest.console.io.OutputWriter;
import ru.kontur.kontest.console.io.listeners.TestDataListener;
import ru.kontur.kontest.storages.SortedSetStorage;
import ru.kontur.kontest.words.Prefix;
import ru.kontur.kontest.words.WordWithFrequency;

public class Application {

	private static final int WORDS_COUNT = 10;

	public void execute(InputStream inputStream, final OutputStream outputStream) throws IOException {
		InputReader inputReader = new InputReader();
		inputReader.readFrom(inputStream, new TestDataListener() {
			private final OutputWriter outputWriter = new OutputWriter();
			private final SortedSetStorage sortedSetStorage = new SortedSetStorage();
			
			@Override
			public void wordsCount(int count) {
			}
			
			@Override
			public void prefixesCount(int count) {
			}
			
			@Override
			public void nextWord(WordWithFrequency wordWithFrequency) {
				sortedSetStorage.put(wordWithFrequency);				
			}
			
			@Override
			public void nextPrefix(Prefix prefix) {
				Collection<WordWithFrequency> foundWords = sortedSetStorage.searchWordsBy(prefix, WORDS_COUNT);
				try {
					outputWriter.writeWordsToStream(foundWords, outputStream);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});
	}
	
}
