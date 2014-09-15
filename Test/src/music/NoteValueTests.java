package music;

import hanon.app.controller.music.NoteValue;

import org.junit.Test;

import static hanon.app.controller.music.NoteValue.*;
import static org.junit.Assert.*;

public class NoteValueTests {

  @Test
  public void testFrequencyEquality() {
    assertEquals(A4, new NoteValue(A4).getFrequency(), .1);
  }

  @Test
  public void testStaffPosition() {
    assertEquals(5, new NoteValue(A4).getStaffPosition());
  }
}
