package ru.kontur.kontest.console.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import ru.kontur.kontest.console.io.listeners.TestDataListener;
import ru.kontur.kontest.words.Prefix;
import ru.kontur.kontest.words.WordWithFrequency;

public class InputReader {
	
	public void readFrom(InputStream stream, TestDataListener testDataListener) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(stream));
		
		int lineIndex = 0; // ������ ������
		int wordsCount = 0; // ���������� ���� � ���������
		int prefixesCount = 0; // ���������� ���������
		
		String line = null;
		while((line = bufferedReader.readLine()) != null) {
			if (lineIndex == 0) { // ������ � ����������� ���� � ���������
				
				wordsCount = Integer.parseInt(line);
				testDataListener.wordsCount(wordsCount);
				
			} else if (lineIndex <= wordsCount) { // ������ �� ������ � ��������
				
				String[] lineParts = line.split("\\s{1,1}"); // ��������� ������ ��������� ����� � �������
				String word = lineParts[0];
				int frequency = Integer.parseInt(lineParts[1]);
				testDataListener.nextWord(new WordWithFrequency(word, frequency));
			
			} else if (lineIndex == wordsCount + 1) { // ������ � ����������� ���������
				
				prefixesCount = Integer.parseInt(line);
				testDataListener.prefixesCount(prefixesCount);
				
			} else if (lineIndex <= wordsCount + 1 + prefixesCount) { // ������ � ���������
				
				testDataListener.nextPrefix(new Prefix(line));
				
			} else { // �������� ������ ������ ���
				
				break;
				
			}
			
			lineIndex++;
		}
	}

}
