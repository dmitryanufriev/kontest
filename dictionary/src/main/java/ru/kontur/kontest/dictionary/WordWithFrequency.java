package ru.kontur.kontest.dictionary;

public class WordWithFrequency implements Comparable<WordWithFrequency> {

	private String word;
	private Integer frequency;

	public WordWithFrequency(String word, int frequency) {
		this.word = word;
		this.frequency = frequency;
	}

	public int compareTo(WordWithFrequency wordWithFrequency) {
		return wordWithFrequency.frequency - frequency;
	}

	@Override
	public String toString() {
		return String.format("Word: %s, Frequency: %d", word, frequency);
	}

}
