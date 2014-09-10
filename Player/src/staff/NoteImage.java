package staff;

import sheet.Brush;
import sheet.StaffPlaceable;

/**
 * A Note Image is nothing more than the collection of different note components
 * that make up a given image.
 *
 * For instance, a whole note is a Note Body and a Body Hole.
 */
class NoteImage implements StaffPlaceable {
  private final NoteComponent[] components;

  public NoteImage(NoteComponent... components) {
    this.components = components;
  }

  public void paint(Brush brush) {
    for (NoteComponent c : components) { c.draw(brush); }
  }
}
