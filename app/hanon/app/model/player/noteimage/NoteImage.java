package hanon.app.model.player.noteimage;

import hanon.app.model.player.sheet.Brush;
import hanon.app.model.player.sheet.StaffPlaceable;

/**
 * A Note Image is nothing more than the collection of different note components
 * that make up a given image.
 *
 * For instance, a whole note is a Note Body and a Body Hole.
 */
public class NoteImage implements StaffPlaceable {
  private final NoteComponent[] components;

  NoteImage(NoteComponent... components) {
    this.components = components;
  }

  public void paint(Brush brush) {
    for (NoteComponent c : components) { c.paint(brush); }
  }

}
