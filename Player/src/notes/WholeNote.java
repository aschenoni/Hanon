package notes;

import java.awt.*;

public class WholeNote {
  private final NoteBody body;
  private final BodyHole bodyHole;

  public WholeNote(int x, int y, float scale) {
    body = new NoteBody(x, y, scale);
    bodyHole = new BodyHole(x, y, scale);
  }

  public WholeNote(int x, int y) {
    this(x, y, 1);
  }

  public void draw(Graphics2D g2) {
    body.draw(g2);
    bodyHole.draw(g2);
  }
}

