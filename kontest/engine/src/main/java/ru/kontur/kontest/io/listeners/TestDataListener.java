package ru.kontur.kontest.io.listeners;

import ru.kontur.kontest.words.Prefix;
import ru.kontur.kontest.words.WordWithFrequency;

/**
 * Обработчик поступающих тестовых данных
 * @author Дмитрий Ануфриев
 *
 */
public interface TestDataListener {

  /**
   * Обработать количество слов с частотами
   * @param count Количество слов с частотами
   */
  public void wordsCount(int count);

  /**
   * Обработать очередное слово с частотой
   * @param wordWithFrequency {@link WordWithFrequency}
   */
  public void nextWord(WordWithFrequency wordWithFrequency);

  /**
   * Обработать количество префиксов
   * @param count Количество префиксов
   */
  public void prefixesCount(int count);

  /**
   * Обработать очередной префикс
   * @param prefix {@link Prefix}
   */
  public void nextPrefix(Prefix prefix);

}
