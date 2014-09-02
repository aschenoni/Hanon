package notes;

import java.awt.*;

public class QuarterNote {
  private final NoteBody body;
  private final NoteStem stem;

  public QuarterNote(int x, int y, float scale) {
    body = new NoteBody(x, y, scale);
    stem = new UpNoteStem(x, y, scale);
  }

  public QuarterNote(int x, int y) {
    this(x, y, 1);
  }

  public void draw(Graphics2D g2) {
    body.draw(g2);
    stem.draw(g2);
  }
}

