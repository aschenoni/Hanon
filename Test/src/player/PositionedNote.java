package player;

import hanon.app.model.music.MusicNote;
import hanon.app.model.music.NoteLength;

public class PositionedNote extends MusicNote {
  private final int position;

  public PositionedNote(int position) {
    this.position = position;
  }

  @Override
  public int getStaffPosition() {
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
