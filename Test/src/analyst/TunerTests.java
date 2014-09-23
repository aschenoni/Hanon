package analyst;

import hanon.app.model.music.MusicNote;
import hanon.app.model.music.NoteValue;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TunerTests {

  @Test
  public void testPositiveFrequencyOffset() {
    MusicNote played = new MusicNote(new NoteValue(450.0f), null);
    assertEquals(10.0f, played.getFrequencyOffset(), .1f);
  }

  @Test
  public void testNegativeFrequencyOffset() {
    MusicNote played = new MusicNote(new NoteValue(430.0f), null);
    assertEquals(-10.0f, played.getFrequencyOffset(), .1f);
  }

}