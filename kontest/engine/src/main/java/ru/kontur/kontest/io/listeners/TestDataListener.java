package ru.kontur.kontest.io.listeners;

import ru.kontur.kontest.words.Prefix;
import ru.kontur.kontest.words.WordWithFrequency;

public interface TestDataListener {

  public void wordsCount(int count);

  public void nextWord(WordWithFrequency wordWithFrequency);

  public void prefixesCount(int count);

  public void nextPrefix(Prefix prefix);

}
