package player;

import hanon.app.controller.music.Clef;
import hanon.app.controller.music.MusicNote;
import hanon.app.controller.music.NoteLength;

public class PositionedNote extends MusicNote {
  private final int position;

  public PositionedNote(int position) {
    this.position = position;
  }

  @Override
  public int getStaffPosition(Clef clef) {
    return position;
  }

  @Override
  public float getFrequency() {
    return 0;
  }

  @Override
  public NoteLength getLength() {
    return null;
  }
}
