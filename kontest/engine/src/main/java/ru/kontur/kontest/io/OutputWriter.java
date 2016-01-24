package ru.kontur.kontest.io;

import ru.kontur.kontest.words.WordWithFrequency;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

/**
 * Класс для записи частотных слов в <code>outputStream</code>
 * 
 * @author Дмитрий Ануфриев
 */
public class OutputWriter {

  /**
   * Записать слова в <code>outputStream</code>
   * 
   * @param words Итерируемый набор {@link WordWithFrequency}
   * @param stream Выходной поток
   * @throws IOException Ошибка ввода/вывода
   */
  public void writeWordsToStream(Iterable<WordWithFrequency> words, OutputStream stream)
      throws IOException {
    toStream(stream, getSingleLineFrom(words));
  }

  private static String getSingleLineFrom(Iterable<WordWithFrequency> words) {
    StringBuilder builder = new StringBuilder();
    for (WordWithFrequency word : words) {
      builder.append(word).append("\n");
    }
    
    if (builder.length() > 0) {
      builder.append("\n");
    }
    
    return builder.toString();
  }

  private static void toStream(OutputStream stream, String words) throws IOException {
    if (words.length() < 1) {
      return;
    }

    OutputStreamWriter writer = new OutputStreamWriter(stream);
    BufferedWriter bufferedWriter = new BufferedWriter(writer);
    bufferedWriter.write(words);
    bufferedWriter.flush();
  }
}
