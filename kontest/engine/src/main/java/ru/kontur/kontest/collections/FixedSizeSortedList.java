package ru.kontur.kontest.collections;

import java.util.Collection;
import java.util.SortedSet;
import java.util.TreeSet;

public class FixedSizeSortedList<T> {

  public FixedSizeSortedList(int size) {
    this.size = size;
    this.sortedSet = new TreeSet<T>();
  }

  public void add(T item) {
    sortedSet.add(item);
    if (sortedSet.size() > size) {
      sortedSet.remove(sortedSet.last());
    }
  }

  public Collection<T> asCollection() {
    return sortedSet;
  }

  public T[] toArray(T[] a) {
    return asCollection().toArray(a);
  }

  private final SortedSet<T> sortedSet;
  private final int size;
}
