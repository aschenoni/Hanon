package components;

import javafx.scene.shape.Rectangle;
import sheet.Brush;
import sheet.Staff;

/**
 * In this case, a note stem refers only to a stem for a single note.
 * Note Stem is not intended to be extended! It should only be
 * extended by the classes UpNoteStem and DownNoteStem.
 */
public abstract class NoteStem implements NoteComponent {
  public static final int WIDTH = 1;
  public static final int HEIGHT = 35;


  /**
   * Factory method for generating a note stem in the correct direction. If the
   * note appears on the third line or higher, the stem should point down.
   * Otherwise, it should point up.
   *
   * The x and y coordinates of the body hole should be the same as the
   * coordinates of the note that it belongs to.
   */
  public static NoteStem fromPosition(int x, int y, int staffY) {
    if (y < staffY + 2*Staff.LINE_GAP)
      return new DownNoteStem(x, y);
    else
      return new UpNoteStem(x, y);
  }

  /**
   * Since the x and y coordinates passed for the construction of a note stem
   * are the same as the x and y coordinates of the note itself, there needs to
   * be some adjustment to correctly place the stem.
   */
  protected abstract int adjustedX();
  protected abstract int adjustedY();

  public void draw(Brush brush) {
    brush.paint(new Rectangle(adjustedX(), adjustedY(), WIDTH, HEIGHT));
  }
}
