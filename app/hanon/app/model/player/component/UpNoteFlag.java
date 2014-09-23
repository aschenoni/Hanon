package hanon.app.model.player.component;

import hanon.app.model.player.sheet.Brush;
import javafx.scene.image.Image;

import java.io.File;

public class UpNoteFlag extends NoteFlag {

  private static final File FILE = new File("res\\images\\UpNoteFlag.png");
  private static final Image IMAGE = new Image(FILE.toURI().toString(), (3/4.0)*NoteBody.WIDTH, 100, true, true);

  private final int x;
  private final int y;

  public UpNoteFlag(int x, int y) {
    this.x = x + NoteBody.WIDTH;
    this.y = y - NoteStem.HEIGHT + NoteBody.HEIGHT/2 + 1;
  }

  @Override
  public void paint(Brush brush) {
    brush.paint(IMAGE, x, y);
  }
}
