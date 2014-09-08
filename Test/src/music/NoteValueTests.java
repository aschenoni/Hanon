package music;

import org.junit.Test;

import static music.NoteValue.*;
import static org.junit.Assert.*;

public class NoteValueTests {

  @Test
  public void testFrequencyEquality() {
    assertEquals(A4, fromFrequency(A4).getFrequency(), .1);

    for (int octave = 0; octave < 8; octave++) {
      for (NoteName name : NoteName.values()) {
        NoteValue n = new NoteValue(name, octave);
        assertEquals(n, NoteValue.fromFrequency(n.getFrequency()));
      }
    }
  }
}
