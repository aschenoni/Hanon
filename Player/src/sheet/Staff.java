package sheet;

import javafx.scene.Group;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.shape.Rectangle;
import music.NoteLength;
import notes.NoteImage;
import notes.NoteImageFactory;

import java.util.ArrayList;
import java.util.List;

public class Staff {
  public static final int LINE_GAP = 10;

  private final int x;
  private final int y;
  private final List<NoteImage> notes = new ArrayList<NoteImage>();
  private final NoteImageFactory factory;

  public Staff(int x, int y) {
    this.x = x;
    this.y = y;
    factory = new NoteImageFactory(y);
  }

  public void draw(Brush brush) {
    for (NoteImage n : notes) { n.draw(brush); }
    for (int i = 0; i < 5; i++) { brush.paint(new Rectangle(x, y+LINE_GAP*i, 300, 1)); }
  }

  /**
   * @param line The line is the position on the staff where the note should
   *             lie. The top space is 0, and the line below it is 1, etc. To
   *             go above the line, use negative values.
   */
  public void addNote(NoteLength length, int x, int line) {
    notes.add(factory.buildImage(length, x, y + 5*line + 1));
  }


}
