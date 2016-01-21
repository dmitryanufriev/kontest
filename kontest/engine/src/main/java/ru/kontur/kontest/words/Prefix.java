package ru.kontur.kontest.words;

/**
 * Префикс слова.
 * Набор символов с начала строки. Может включать в себя всю строку.
 * @author Дмитрий Ануфриев
 *
 */
public class Prefix {

  /**
   * Конструктор
   * @param prefix {@link String} Префикс слова
   */
  public Prefix(String prefix) {
    this.prefix = prefix;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((prefix == null) ? 0 : prefix.hashCode());
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

    Prefix other = (Prefix) obj;
    if (prefix == null) {
      if (other.prefix != null) {
        return false;
      }
    } else if (!prefix.equals(other.prefix)) {
      return false;
    }

    return true;
  }

  @Override
  public String toString() {
    return prefix;
  }
  
  private final String prefix;
}
