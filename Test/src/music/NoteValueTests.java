package music;

import hanon.app.model.music.Clef;
import hanon.app.model.music.NoteValue;
import org.junit.Test;

import static hanon.app.model.music.NoteValue.*;
import static hanon.app.model.music.NoteValue.fromNameAndOctave;
import static org.junit.Assert.assertEquals;

public class NoteValueTests {

  @Test
  public void testFrequencyEquality() {
    assertEquals(A4, new NoteValue(A4).getFrequency(), .1);
  }

  @Test
  public void testStaffPosition() {
    assertEquals(5, new NoteValue(A4).getStaffPosition(Clef.TREBLE));
    assertEquals(6, fromNameAndOctave(NoteName.G, 4).getStaffPosition(Clef.TREBLE));
  }

  @Test
  public void testFromNameAndOctave() {
    assertEquals(110, fromNameAndOctave(NoteName.A, 2).getFrequency(), 1);
    assertEquals(392, fromNameAndOctave(NoteName.G, 4).getFrequency(), 1);
  }
}
