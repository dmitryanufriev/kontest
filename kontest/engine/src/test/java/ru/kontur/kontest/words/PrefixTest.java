package ru.kontur.kontest.words;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class PrefixTest {

  @Test
  public void prefixesShouldBeEqualsForSameStrings() {
    Prefix prefix = new Prefix("a");

    assertEquals("Не совпадают префиксы с одинаковыми словами", new Prefix("a"), prefix);
  }

  @Test
  public void prefixAsStringShouldBeEqualToPrefix() {
    Prefix prefix = new Prefix("a");

    assertEquals("a", prefix.toString());
  }
}
