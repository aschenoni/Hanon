package hanon.app.model.player.noteimage;

import hanon.app.model.music.Clef;
import hanon.app.model.music.MusicNote;
import hanon.app.model.player.sheet.Brush;
import hanon.app.model.player.staff.Staff;
import javafx.scene.shape.Rectangle;

/**
 * In this case, a note stem refers only to a stem for a single note.
 * Note Stem is not intended to be extended! It should only be
 * extended by the classes UpNoteStem and DownNoteStem.
 */
public class NoteStem implements NoteComponent {
  private static final int CENTER_POSITION = 4;

  private static final int WIDTH = 1;
  static final int HEIGHT = 35;

  private final boolean isUp;
  private final int x;
  private final int y;

  /**
   * Factory method for generating a note stem in the correct direction. If the
   * note appears on the third line or higher, the stem should point down.
   * Otherwise, it should point up.
   *
   * The x and getY coordinates of the body hole should be the same as the
   * coordinates of the note that it belongs to.
   */
  static NoteStem fromPosition(int x, int y, int staffY) {
    if (y < staffY + 2* Staff.LINE_GAP)
      return new NoteStem(false, x, y);
    else
      return new NoteStem(true, x, y);
  }

  NoteStem(boolean isUp, int x, int y) {
    this.isUp = isUp;
    this.x = x;
    this.y = y;
  }

  /**
   * Since the x and getY coordinates passed for the construction of a note stem
   * are the same as the x and getY coordinates of the note itself, there needs to
   * be some adjustment to correctly place the stem.
   */
  private int adjustedX() {
    if (isUp)
      return x - NoteStem.WIDTH + NoteBody.WIDTH;
    else
      return x;
  }
  private int adjustedY() {
    if (isUp)
      return y - NoteStem.HEIGHT + (NoteBody.HEIGHT / 2);
    else
      return y + (NoteBody.HEIGHT / 2) + 1;
  }

  public void paint(Brush brush) {
    brush.paint(new Rectangle(adjustedX(), adjustedY(), WIDTH, HEIGHT));
  }

  /**
   * "To determine the direction for a stem in a chord containing notes both
   * above and below the middle line, the direction of the note farthest from
   * that line governs. When the highest and the lowest notes are equidistant
   * from the center of the staff, a down stem is used."
   */
  public static boolean shouldStemGoUp(Clef clef, MusicNote... notes) {
    int farthestFromCenter = CENTER_POSITION;
    for (MusicNote n : notes)
      if (fartherFromCenter(clef, farthestFromCenter, n))
        farthestFromCenter = n.getStaffPosition(clef);
      else if (equidistantFromCenter(clef, farthestFromCenter, n) && isAboveCenter(clef, n))
        farthestFromCenter = n.getStaffPosition(clef);
    return farthestFromCenter >= CENTER_POSITION;
  }

  private static boolean equidistantFromCenter(Clef clef, int farthestFromCenter, MusicNote n) {
    return distFromCenter(n.getStaffPosition(clef)) == distFromCenter(farthestFromCenter);
  }

  private static boolean fartherFromCenter(Clef clef, int farthestFromCenter, MusicNote n) {
    return distFromCenter(n.getStaffPosition(clef)) > distFromCenter(farthestFromCenter);
  }

  private static int distFromCenter(int position) {
    return Math.abs(position - CENTER_POSITION);
  }

  private static boolean isAboveCenter(Clef clef, MusicNote n) {
    return n.getStaffPosition(clef) < CENTER_POSITION;
  }
}
