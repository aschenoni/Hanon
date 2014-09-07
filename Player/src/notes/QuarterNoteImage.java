package notes;

import components.NoteBody;
import components.NoteStem;
import javafx.scene.canvas.GraphicsContext;

public class QuarterNoteImage implements NoteImage {
  private final NoteBody body;
  private final NoteStem stem;

  public QuarterNoteImage(int x, int y, float scale) {
    body = new NoteBody(x, y, scale);
    stem = NoteStem.fromPosition(x, y, scale, 25);
  }

  public QuarterNoteImage(int x, int y) {
    this(x, y, 1);
  }

  public void draw(GraphicsContext g2) {
    body.draw(g2);
    stem.draw(g2);
  }
}

