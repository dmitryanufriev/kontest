package ru.kontur.kontest.words;

import static org.junit.Assert.*;

import org.junit.*;

import ru.kontur.kontest.words.Prefix;

public class PrefixTest {

	@Test
	public void prefixesShouldBeEqualsForSameStrings() {
		Prefix prefix = new Prefix("a");
		
		assertEquals("��� �������� � ����������� ������� ������ ���� ������������", new Prefix("a"), prefix);
	}
	
	@Test
	public void prefixAsStringShouldBeEqualToPrefix() {
		Prefix prefix = new Prefix("a");
		
		assertEquals("a", prefix.toString());
	}
	
}
