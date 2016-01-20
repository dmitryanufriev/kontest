package ru.kontur.kontest.console;

import ru.kontur.kontest.io.InputReader;
import ru.kontur.kontest.io.OutputWriter;
import ru.kontur.kontest.io.listeners.TestDataListener;
import ru.kontur.kontest.storages.HashMapStorage;
import ru.kontur.kontest.storages.Storage;
import ru.kontur.kontest.words.Prefix;
import ru.kontur.kontest.words.WordWithFrequency;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Collection;

public class Application {

  public static void main(String[] args) {
    Application application = new Application();
    try {
      application.execute(System.in, System.out);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void execute(InputStream inputStream, final OutputStream outputStream) throws IOException {
    InputReader inputReader = new InputReader();
    inputReader.readFrom(inputStream, new TestDataListener() {
      private final OutputWriter outputWriter = new OutputWriter();
      private Storage storage;

      @Override
      public void wordsCount(int count) {
        storage = new HashMapStorage(count, WORDS_COUNT);
      }

      @Override
      public void prefixesCount(int count) {
      }

      @Override
      public void nextWord(WordWithFrequency wordWithFrequency) {
        storage.put(wordWithFrequency);
      }

      @Override
      public void nextPrefix(Prefix prefix) {
        Collection<WordWithFrequency> foundWords = storage.searchWordsBy(prefix);
        try {
          outputWriter.writeWordsToStream(foundWords, outputStream);
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    });
  }
  
  private static final int WORDS_COUNT = 10;
}
