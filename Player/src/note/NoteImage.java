package note;

import music.NoteLength;
import sheet.Brush;

/**
 * A Note Image is nothing more than the collection of different note components
 * that make up a given image.
 *
 * For instance, a whole note is a Note Body and a Body Hole.
 */
public class NoteImage {
  private final NoteComponent[] components;

  public NoteImage(NoteComponent... components) {
    this.components = components;
  }

  public void draw(Brush brush) {
    for (NoteComponent c : components) { c.draw(brush); }
  }
}
