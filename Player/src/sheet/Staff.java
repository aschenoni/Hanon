package sheet;

import image.Clef;
import image.TimeSignature;
import javafx.scene.shape.Rectangle;
import music.NoteLength;
import note.NoteImage;
import note.NoteImageFactory;

import java.util.ArrayList;
import java.util.List;

public class Staff {
  public static final int LINE_GAP = 10;

  private final int x;
  private final int y;
  private int currentX;

  private final List<NoteImage> notes = new ArrayList<NoteImage>();
  private final NoteImageFactory factory;
  private final Clef clef;
  private final TimeSignature timeSignature;

  public Staff(Clef clef, TimeSignature timeSignature, int x, int y) {
    this.clef = clef;
    this.timeSignature = timeSignature;
    factory = new NoteImageFactory(y);
    this.x = x;
    this.y = y;
    currentX = x+100;
  }

  public void draw(Brush brush) {
    clef.draw(brush, x, y-20);
    timeSignature.draw(brush, x, y);

    for (NoteImage n : notes) { n.draw(brush); }
    for (int i = 0; i < 5; i++) { brush.paint(new Rectangle(x, y + LINE_GAP * i, 300, 1)); }
  }

  /**
   * @param line The line is the position on the staff where the note should
   *             lie. The top space is 0, and the line below it is 1, etc. To
   *             go above the line, use negative values.
   */
  public void addNote(NoteLength length, int line) {
    NoteImage im = factory.buildImage(length, currentX, y + 5 * line + 1);
    notes.add(im);
    currentX += length.getSpacing();
  }
}
