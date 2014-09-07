package notes;

import components.BodyHole;
import components.NoteBody;
import components.NoteStem;
import music.NoteLength;

public class NoteImageFactory {
  private final int staffY;

  public NoteImageFactory(int staffY) {
    this.staffY = staffY;
  }

  public NoteImage buildImage(NoteLength length, int x, int y) {
    NoteBody body = new NoteBody(x, y, 1);
    NoteStem stem = NoteStem.fromPosition(x, y, 1, staffY);
    BodyHole hole = new BodyHole(x, y, 1);
    NoteImage i = null;
    switch (length) {
      case quarter:
        i = new NoteImage(body, stem);
        break;
      case half:
        i = new NoteImage(body, hole, stem);
        break;
    }
    return i;
  }
}
