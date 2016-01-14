package ru.kontur.kontest.storage;

import static org.junit.Assert.*;

import org.junit.*;

public class PrefixTest {

	@Test
	public void prefixesShouldBeEqualsForSameStrings() {
		Prefix prefix = new Prefix("a");
		
		assertEquals("��� �������� � ����������� ������� ������ ���� ������������", new Prefix("a"), prefix);
	}
	
}
