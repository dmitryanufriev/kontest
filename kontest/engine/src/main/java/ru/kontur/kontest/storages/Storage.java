package ru.kontur.kontest.storages;

import ru.kontur.kontest.words.Prefix;
import ru.kontur.kontest.words.WordWithFrequency;

import java.util.Collection;

public interface Storage {

  void put(WordWithFrequency wordWithFrequency);

  Collection<WordWithFrequency> searchWordsBy(Prefix prefix);

}