package player;

import hanon.app.controller.music.MusicNote;
import hanon.app.controller.music.NoteLength;
import hanon.app.controller.music.NoteValue;

public class PositionedNote extends MusicNote {
  private final int position;

  public PositionedNote(int position) {
    super(null, null);
    this.position = position;
  }

  @Override
  public int getStaffPosition() {
    return position;
  }
}
