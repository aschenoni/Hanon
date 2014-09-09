package notes;

import components.NoteComponent;
import sheet.Brush;

public class NoteImage {
  private final NoteComponent[] components;

  public NoteImage(NoteComponent... components) {
    this.components = components;
  }

  public void draw(Brush brush) {
    for (NoteComponent c : components) { c.draw(brush); }
  }
}
