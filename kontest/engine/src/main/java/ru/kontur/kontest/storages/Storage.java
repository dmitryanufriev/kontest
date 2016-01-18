package ru.kontur.kontest.storages;

import java.util.Collection;

import ru.kontur.kontest.words.Prefix;
import ru.kontur.kontest.words.WordWithFrequency;

public interface Storage {

	void put(WordWithFrequency wordWithFrequency);

	Collection<WordWithFrequency> searchWordsBy(Prefix prefix);

}