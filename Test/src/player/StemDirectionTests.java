package player;

import hanon.app.model.music.Clef;

import hanon.app.model.music.MusicNote;
import hanon.app.model.player.noteimage.NoteStem;
import org.junit.Test;

import static org.junit.Assert.*;

public class StemDirectionTests {

  private static final MusicNote POSITION_2 = new PositionedNote(2);
  private static final MusicNote POSITION_3 = new PositionedNote(3);
  // Note that the center is at position 4
  private static final MusicNote POSITION_5 = new PositionedNote(5);
  private static final MusicNote POSITION_6 = new PositionedNote(6);

  @Test
  public void testShouldGoUp() {
    assertTrue(NoteStem.shouldStemGoUp(Clef.TREBLE, POSITION_3, POSITION_6));
  }

  @Test
  public void testShouldGoDown() {
    assertFalse(NoteStem.shouldStemGoUp(Clef.TREBLE, POSITION_2, POSITION_5));
  }

  @Test
  public void testEquidistantGoesDown() {
    assertFalse(NoteStem.shouldStemGoUp(Clef.TREBLE, POSITION_3, POSITION_5));
  }

}
