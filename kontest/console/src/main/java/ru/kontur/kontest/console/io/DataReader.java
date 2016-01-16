package ru.kontur.kontest.console.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import ru.kontur.kontest.console.io.listeners.TestDataListener;

public class DataReader {

	public void readFrom(InputStream dataStream, TestDataListener testDataListener) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(dataStream));
		int lineIndex = 0;
		String line = null;
		while((line = bufferedReader.readLine()) != null) {
			if (lineIndex == 0) { // Количество слов с частотами
				testDataListener.wordsCount(Integer.parseInt(line));
				lineIndex++;
			}
		}
	}

}
