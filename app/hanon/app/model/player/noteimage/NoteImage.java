package hanon.app.model.player.noteimage;

import javafx.scene.paint.Color;
import hanon.app.model.player.sheet.Brush;
import hanon.app.model.player.sheet.StaffPlaceable;

/**
 * A Note Image is nothing more than the collection of different note components
 * that make up a given image.
 *
 * For instance, a whole note is a Note Body and a Body Hole.
 */
public class NoteImage implements StaffPlaceable {
  private final boolean up;
  private final int x;
  private final int y;
  private final NoteComponent[] components;

  NoteImage(boolean up, int x, int y, NoteComponent... components) {
    this.up = up;
    this.x = x;
    this.y = y;
    this.components = components;
  }

  public void paint(Brush brush) {
    for (NoteComponent c : components) { c.paint(brush); }
  }

  public int x() {
    return x;
  }

  public int y() {
    return y;
  }

  public boolean goesUp() {
    return up;
  }

  public boolean hasStem() {
    for (NoteComponent c : components) {
      if (c instanceof NoteStem) return true;
    }
    return false;
  }

  public int top() {
    if (goesUp() && hasStem())
      return y - NoteStem.HEIGHT;
    else
      return y;
  }

  public int bottom() {
    if (!goesUp() && hasStem())
      return y + NoteBody.HEIGHT + NoteStem.HEIGHT;
    else
      return y + NoteBody.HEIGHT;
  }
}
