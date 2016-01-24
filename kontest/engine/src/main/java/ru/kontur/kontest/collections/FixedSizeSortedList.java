package ru.kontur.kontest.collections;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * Коллекция на фиксированное количество элементов. Обеспечивает хранение элементов в
 * отсортированном порядке.
 * 
 * @author Дмитрий Ануфриев
 * @param <T> Тип элементов коллекции
 */
public class FixedSizeSortedList<T> {

  /**
   * Конструктор
   * 
   * @param size Максимально допустимое количество элементов в коллекции.
   */
  public FixedSizeSortedList(int size) {
    this.size = size;
    this.sortedSet = new TreeSet<T>();
  }

  /**
   * Добавить элемент в коллекцию
   * 
   * @param item Элемент коллекции
   */
  public void add(T item) {
    sortedSet.add(item);
    if (sortedSet.size() > size) {
      sortedSet.remove(sortedSet.last());
    }
  }

  /**
   * Вернуть содержимое коллекции в виде {@link Collection}
   * 
   * @return Объект, реализующий {@link Collection<T>}
   */
  public Collection<T> asCollection() {
    return sortedSet;
  }

  /**
   * Вернуть содержимое коллекции в виде массива
   * 
   * @param a Тип массива
   * @return {@link Array}
   */
  public T[] toArray(T[] a) {
    return asCollection().toArray(a);
  }
  
  private final SortedSet<T> sortedSet;
  private final int size;
}
