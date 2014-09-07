package notes;

import components.BodyHole;
import components.NoteBody;
import javafx.scene.canvas.GraphicsContext;

public class WholeNoteImage implements NoteImage {
  private final NoteBody body;
  private final BodyHole bodyHole;

  public WholeNoteImage(int x, int y, float scale) {
    body = new NoteBody(x, y, scale);
    bodyHole = new BodyHole(x, y, scale);
  }

  public WholeNoteImage(int x, int y) {
    this(x, y, 1);
  }

  public void draw(GraphicsContext g2) {
    body.draw(g2);
    bodyHole.draw(g2);
  }
}

