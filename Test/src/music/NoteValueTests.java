package music;

import org.junit.Assert;
import org.junit.Test;

import static music.NoteValue.*;
import static org.junit.Assert.*;

public class NoteValueTests {

  @Test
  public void testFrequencyEquality() {
    assertEquals(A4, new NoteValue(A4).getFrequency(), .1);
  }

  @Test
  public void testStaffPosition() {
    assertEquals(5, new NoteValue(A4).getStaffPosition());
    assertEquals(6, NoteValue.fromNameAndOctave(NoteName.G, 4).getStaffPosition());

  }

  @Test
  public void testFromNameAndOctave() {
    assertEquals(110, NoteValue.fromNameAndOctave(NoteName.A, 2).getFrequency(), 1);
    assertEquals(392, NoteValue.fromNameAndOctave(NoteName.G, 4).getFrequency(), 1);
  }
}
