package player;

import music.MusicNote;
import music.NoteLength;

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
