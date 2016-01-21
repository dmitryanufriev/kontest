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
 * @author Дмитрий Ануфриев
 *
 */
public class InputReader {

  /**
   * Прочитать тестовые данные из <code>stream</code>
   * @param stream Поток, содержащий тестовые данные
   * @param testDataListener Объект, реализующий интерфейс {@link TestDataListener}
   * @throws IOException Ошибка ввода/вывода
   */
  public void readFrom(InputStream stream, TestDataListener testDataListener) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(stream));

    int lineIndex = 0; // Индекс текущей строки
    int wordsCount = 0; // Количество слов
    int prefixesCount = 0; // Количество префиксов

    String line = null;
    while ((line = bufferedReader.readLine()) != null) {
      if (lineIndex == 0) { // Строка с количеством слов

        wordsCount = Integer.parseInt(line);
        testDataListener.wordsCount(wordsCount);

      } else if (lineIndex <= wordsCount) { // Строка, которая содержит слово с
                                            // частотой

        String[] lineParts = line.split("\\s{1,1}");
        String word = lineParts[0];
        int frequency = Integer.parseInt(lineParts[1]);
        testDataListener.nextWord(new WordWithFrequency(word, frequency));

      } else if (lineIndex == wordsCount + 1) { // Строка с количеством
                                                // префиксов

        prefixesCount = Integer.parseInt(line);
        testDataListener.prefixesCount(prefixesCount);

      } else if (lineIndex <= wordsCount + 1 + prefixesCount) { // Строка с
                                                                // префиксом

        testDataListener.nextPrefix(new Prefix(line));

      } else { // Конец тестовых данных

        break;

      }

      lineIndex++;
    }
  }
}
