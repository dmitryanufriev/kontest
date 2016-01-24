package ru.kontur.kontest.io;

import ru.kontur.kontest.io.listeners.TestDataListener;
import ru.kontur.kontest.words.Prefix;
import ru.kontur.kontest.words.WordWithFrequency;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Класс для чтения тестовых данных
 * 
 * @author Дмитрий Ануфриев
 */
public class InputReader {

  /**
   * Прочитать тестовые данные из <code>stream</code>
   * 
   * @param stream Поток, содержащий тестовые данные
   * @param listener Объект, реализующий интерфейс {@link TestDataListener}
   * @throws IOException Ошибка ввода/вывода
   */
  public void readFrom(InputStream stream, TestDataListener listener) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(stream));

    int lineIndex = 0; // Индекс текущей строки
    int wordsCount = 0; // Количество слов
    int prefixesCount = 0; // Количество префиксов

    String line = null;
    while ((line = bufferedReader.readLine()) != null) { // Проходим по всем строкам
      switch (getPosition(lineIndex, wordsCount, prefixesCount)) {
        case WORDS_COUNT:
          wordsCount = Integer.parseInt(line);
          listener.wordsCount(wordsCount);
          break;
        case WORD_WITH_FREQUENCY:
          String[] lineParts = line.split("\\s{1,1}");
          String word = lineParts[0];
          int frequency = Integer.parseInt(lineParts[1]);
          listener.nextWord(new WordWithFrequency(word, frequency));
          break;
        case PREFIXES_COUNT:
          prefixesCount = Integer.parseInt(line);
          listener.prefixesCount(prefixesCount);
          break;
        case PREFIX:
          listener.nextPrefix(new Prefix(line));
          break;
        default:
          break;
      }

      lineIndex++;
    }
  }

  private enum Position {
    UNKNOWN, WORDS_COUNT, WORD_WITH_FREQUENCY, PREFIXES_COUNT, PREFIX
  };

  private static Position getPosition(int lineIndex, int wordsCount, int prefixesCount) {
    if (lineIndex == 0) {
      return Position.WORDS_COUNT;
    }

    if (lineIndex <= wordsCount) {
      return Position.WORD_WITH_FREQUENCY;
    }

    if (lineIndex == wordsCount + 1) {
      return Position.PREFIXES_COUNT;
    }

    if (lineIndex <= wordsCount + 1 + prefixesCount) {
      return Position.PREFIX;
    }

    return Position.UNKNOWN;
  }
}
