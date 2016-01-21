package ru.kontur.kontest.io;

import ru.kontur.kontest.words.WordWithFrequency;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

/**
 * Класс для записи частотных слов в <code>outputStream</code>
 * @author Дмитрий Ануфриев
 *
 */
public class OutputWriter {

  /**
   * Записать слова в <code>outputStream</code>
   * @param words Итерируемый набор {@link WordWithFrequency}
   * @param outputStream Выходной поток
   * @throws IOException Ошибка ввода/вывода
   */
  public void writeWordsToStream(Iterable<WordWithFrequency> words, OutputStream outputStream)
      throws IOException {
    StringBuilder stringBuilder = new StringBuilder();
    for (WordWithFrequency word : words) {
      stringBuilder.append(word);
      stringBuilder.append("\n");
    }

    if (stringBuilder.length() > 0) {
      stringBuilder.append('\n');

      BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
      bufferedWriter.write(stringBuilder.toString());
      bufferedWriter.flush();

    }
  }
}
