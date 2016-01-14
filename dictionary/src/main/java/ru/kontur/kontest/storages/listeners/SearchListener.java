package ru.kontur.kontest.storages.listeners;

import ru.kontur.kontest.words.WordWithFrequency;

public interface SearchListener {

	void foundWord(WordWithFrequency wordWithFrequency);

}
