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

  public void draw(GraphicsContext g2, Group root) {
    for (NoteImage n : notes) { n.draw(g2, root); }
    for (int i = 0; i < 5; i++) { root.getChildren().add(new Rectangle(x, y+LINE_GAP*i, 300, 1)); }
  }

  public void addNote(NoteLength length, int x, int line) {
    notes.add(factory.buildImage(length, x, y + 5*line + 1));
  }
}
