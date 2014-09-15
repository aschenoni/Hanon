package util;

import hanon.app.controller.composer.util.StringOps;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class StringOpsTests {

  @Test
  public void testGroupIntoSets() {
    String[] lines = {"a", "{", "hello", "}", "b"};
    String[] grouped = {"a", "{\nhello\n}", "b"};
    assertArrayEquals(grouped, StringOps.groupIntoSets(lines));
  }
}
