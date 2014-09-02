package notes;

import java.awt.*;

public class HalfNote {
  private final NoteBody body;
  private final NoteStem stem;
  private final BodyHole bodyHole;

  public HalfNote(int x, int y, float scale) {
    body = new NoteBody(x, y, scale);
    stem = new UpNoteStem(x, y, scale);
    bodyHole = new BodyHole(x, y, scale);
  }

  public HalfNote(int x, int y) {
    this(x, y, 1);
  }

  public void draw(Graphics2D g2) {
    body.draw(g2);
    stem.draw(g2);
    bodyHole.draw(g2);
  }
}

