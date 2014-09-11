package component;

import javafx.scene.shape.Rectangle;
import music.MusicNote;
import staff.NoteComponent;
import sheet.Brush;
import staff.Staff;

/**
 * In this case, a note stem refers only to a stem for a single note.
 * Note Stem is not intended to be extended! It should only be
 * extended by the classes UpNoteStem and DownNoteStem.
 */
public abstract class NoteStem implements NoteComponent {
  private static final int CENTER_POSITION = 4;

  static final int WIDTH = 1;
  static final int HEIGHT = 35;

  /**
   * Factory method for generating a note stem in the correct direction. If the
   * note appears on the third line or higher, the stem should point down.
   * Otherwise, it should point up.
   *
   * The x and getY coordinates of the body hole should be the same as the
   * coordinates of the note that it belongs to.
   */
  public static NoteStem fromPosition(int x, int y, int staffY) {
    if (y < staffY + 2* Staff.LINE_GAP)
      return new DownNoteStem(x, y);
    else
      return new UpNoteStem(x, y);
  }

  /**
   * Since the x and getY coordinates passed for the construction of a note stem
   * are the same as the x and getY coordinates of the note itself, there needs to
   * be some adjustment to correctly place the stem.
   */
  protected abstract int adjustedX();
  protected abstract int adjustedY();

  public void draw(Brush brush) {
    brush.paint(new Rectangle(adjustedX(), adjustedY(), WIDTH, HEIGHT));
  }

  /**
   * "To determine the direction for a stem in a chord containing notes both
   * above and below the middle line, the direction of the note farthest from
   * that line governs. When the highest and the lowest notes are equidistant
   * from the center of the staff, a down stem is used."
   */
  public static boolean shouldStemGoUp(MusicNote... notes) {
    int farthestFromCenter = CENTER_POSITION;
    for (MusicNote n : notes)
      if (fartherFromCenter(farthestFromCenter, n))
        farthestFromCenter = n.getStaffPosition();
      else if (equidistantFromCenter(farthestFromCenter, n) && isAboveCenter(n))
        farthestFromCenter = n.getStaffPosition();
    return farthestFromCenter >= CENTER_POSITION;
  }

  private static boolean equidistantFromCenter(int farthestFromCenter, MusicNote n) {
    return distFromCenter(n.getStaffPosition()) == distFromCenter(farthestFromCenter);
  }

  private static boolean fartherFromCenter(int farthestFromCenter, MusicNote n) {
    return distFromCenter(n.getStaffPosition()) > distFromCenter(farthestFromCenter);
  }

  private static int distFromCenter(int position) {
    return Math.abs(position - CENTER_POSITION);
  }

  private static boolean isAboveCenter(MusicNote n) {
    return n.getStaffPosition() < CENTER_POSITION;
  }
}
