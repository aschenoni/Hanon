package notes;

import components.BodyHole;
import components.NoteBody;
import components.NoteStem;
import javafx.scene.canvas.GraphicsContext;

public class HalfNoteImage implements NoteImage {
  private final NoteBody body;
  private final NoteStem stem;
  private final BodyHole bodyHole;

  public HalfNoteImage(int x, int y, float scale) {
    body = new NoteBody(x, y, scale);
    stem = NoteStem.fromPosition(x, y, scale, 25);
    bodyHole = new BodyHole(x, y, scale);
  }

  public HalfNoteImage(int x, int y) {
    this(x, y, 1);
  }

  public void draw(GraphicsContext g2) {
    body.draw(g2);
    stem.draw(g2);
    bodyHole.draw(g2);
  }
}

