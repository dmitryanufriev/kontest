package ru.kontur.kontest.storages;

import ru.kontur.kontest.collections.FixedSizeSortedList;
import ru.kontur.kontest.words.Prefix;
import ru.kontur.kontest.words.WordWithFrequency;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;

/**
 * Хранилище слов с частотами на основе {@link HashMap}
 * @author Дмитрий Ануфриев
 */
public class HashMapStorage implements Storage {

  /**
   * Конструктор
   * @param countOfWordsForPrefix Количество хранимых слов по каждому префиксу
   */
  public HashMapStorage(int countOfWordsForPrefix) {
    storage = new HashMap<Prefix, FixedSizeSortedList<WordWithFrequency>>();
    this.countOfWordsForPrefix = countOfWordsForPrefix;
  }

  /**
   * Конструктор
   * @param storageSize Размер хранилища
   * @param countOfWordsForPrefix Количество хранимых слов по каждому префиксу
   */
  public HashMapStorage(int storageSize, int countOfWordsForPrefix) {
    storage = new HashMap<Prefix, FixedSizeSortedList<WordWithFrequency>>(storageSize);
    this.countOfWordsForPrefix = countOfWordsForPrefix;
  }

  @Override
  public void put(WordWithFrequency wordWithFrequency) {
    Prefix[] prefixes = wordWithFrequency.getPrefixes();
    for (Prefix prefix : prefixes) {
      if (!storage.containsKey(prefix)) {
        storage.put(prefix, new FixedSizeSortedList<WordWithFrequency>(countOfWordsForPrefix));
      }

      storage.get(prefix).add(wordWithFrequency);
    }
  }

  @Override
  public Collection<WordWithFrequency> searchWordsBy(Prefix prefix) {
    if (!storage.containsKey(prefix)) {
      return Collections.emptyList();
    }

    return storage.get(prefix).asCollection();
  }
  
  private final HashMap<Prefix, FixedSizeSortedList<WordWithFrequency>> storage;
  private final int countOfWordsForPrefix;
}
