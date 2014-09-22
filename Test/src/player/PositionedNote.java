package player;

import hanon.app.model.music.Clef;

public class PositionedNote extends hanon.app.model.music.MusicNote {
  private final int position;

  public PositionedNote(int position) {
    super(null, null);
    this.position = position;
  }

  @Override
  public int getStaffPosition(Clef clef) {
    return position;
  }
}
