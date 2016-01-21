package ru.kontur.kontest.storages;

import ru.kontur.kontest.words.Prefix;
import ru.kontur.kontest.words.WordWithFrequency;

import java.util.Collection;

/**
 * Хранилище слов с частотами
 * @author danufriev
 */
public interface Storage {

  /**
   * Поместить слово с частотой в хранилище
   * @param wordWithFrequency {@link WordWithFrequency}
   */
  void put(WordWithFrequency wordWithFrequency);

  /**
   * Найти слова, соответствующие префиксу <code>prefix</code>
   * @param prefix {@link Prefix}
   * @return {@link Collection}, содержащая {@link WordWithFrequency}
   */
  Collection<WordWithFrequency> searchWordsBy(Prefix prefix);

}