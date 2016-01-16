package ru.kontur.kontest.console.io.listeners;

import ru.kontur.kontest.words.WordWithFrequency;

public interface TestDataListener {

	public void wordsCount(int count);

	public void nextWord(WordWithFrequency wordWithFrequency);

	public void prefixesCount(int i);

}
