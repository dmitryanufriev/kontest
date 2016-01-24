package ru.kontur.kontest.words;

/**
 * Слово с частотой
 * 
 * @author Дмитрий Ануфриев
 */
public class WordWithFrequency implements Comparable<WordWithFrequency> {

  /**
   * Конструктор
   * 
   * @param word Слово
   * @param frequency Частота повторения
   */
  public WordWithFrequency(String word, int frequency) {
    this.word = word;
    this.frequency = frequency;
  }

  /**
   * Получить префиксы слова
   * 
   * @return Массив {@link Prefix}
   */
  public Prefix[] getPrefixes() {
    final int prefixesCount = word.length();
    Prefix[] prefixes = new Prefix[prefixesCount];
    for (int i = 1; i <= prefixesCount; i++) {
      prefixes[i - 1] = new Prefix(word.substring(0, i));
    }

    return prefixes;
  }

  public int compareTo(WordWithFrequency wordWithFrequency) {
    int frequenciesComparisonResult = wordWithFrequency.frequency - frequency;

    if (frequenciesComparisonResult == 0) { // Частоты равны, сравниваем
                                            // слова
      return word.compareTo(wordWithFrequency.word);
    }

    return frequenciesComparisonResult;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + frequency;
    result = prime * result + ((word == null) ? 0 : word.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }

    if (obj == null) {
      return false;
    }

    if (getClass() != obj.getClass()) {
      return false;
    }

    WordWithFrequency other = (WordWithFrequency) obj;
    if (frequency != other.frequency) {
      return false;
    }

    if (word == null) {
      if (other.word != null) {
        return false;
      }
    } else if (!word.equals(other.word)) {
      return false;
    }

    return true;
  }

  @Override
  public String toString() {
    return word;
  }
  
  private final String word;
  private final int frequency;
}
