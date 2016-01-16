package ru.kontur.kontest.console.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import ru.kontur.kontest.console.io.listeners.TestDataListener;
import ru.kontur.kontest.words.WordWithFrequency;

public class DataReader {

	public void readFrom(InputStream dataStream, TestDataListener testDataListener) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(dataStream));
		
		int lineIndex = 0; // ������ ������
		int wordsCount = 0; // ���������� ���� � ���������
		
		String line = null;
		while((line = bufferedReader.readLine()) != null) {
			if (lineIndex == 0) { // ���������� ���� � ���������
				
				wordsCount = Integer.parseInt(line);
				testDataListener.wordsCount(wordsCount);
				
			} else if (lineIndex <= wordsCount) { // ����� � ��������
				
				String[] lineParts = line.split("\\s{1,1}"); // ��������� ������ ��������� ����� � �������
				String word = lineParts[0];
				int frequency = Integer.parseInt(lineParts[1]);
				testDataListener.nextWord(new WordWithFrequency(word, frequency));
			
			}
			
			lineIndex++;
		}
	}

}
