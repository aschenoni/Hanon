package notes;

import components.NoteComponent;
import javafx.scene.Group;
import javafx.scene.canvas.GraphicsContext;

public class NoteImage {
  private final NoteComponent[] components;

  public NoteImage(NoteComponent... components) {
    this.components = components;
  }

  public void draw(GraphicsContext g2, Group root) {
    for (NoteComponent c : components) { c.draw(g2, root); }
  }
}
