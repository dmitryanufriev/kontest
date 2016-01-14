package ru.kontur.kontest.storage;

import static org.junit.Assert.*;

import org.junit.*;

public class PrefixTest {

	@Test
	public void prefixesShouldBeEqualsForSameStrings() {
		Prefix prefix = new Prefix("a");
		
		assertEquals("Два префикса с одинаковыми словами должны быть эквивалентны", new Prefix("a"), prefix);
	}
	
}
