package ru.kontur.kontest.storage;

import java.util.SortedSet;
import java.util.TreeSet;

public class FixedSizeSortedSet<T> {

	private final SortedSet<T> sortedSet;
	private final int size;
	
	public FixedSizeSortedSet(int size) {
		this.size = size;
		this.sortedSet = new TreeSet<T>();
	}

	public void add(T item) {
		sortedSet.add(item);
		if (sortedSet.size() > size) {
			sortedSet.remove(sortedSet.last());
		}
	}

	@SuppressWarnings("unchecked")
	public T[] toArray() {
		return (T[]) sortedSet.toArray();
	}

}
