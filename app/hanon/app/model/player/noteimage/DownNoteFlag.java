package hanon.app.model.player.noteimage;

import hanon.app.model.player.sheet.Brush;
import javafx.scene.image.Image;

import java.io.File;

class DownNoteFlag extends NoteFlag {

  public static final int WIDTH = (int) (3/4.0*NoteBody.WIDTH);

  private static final File FILE = new File("res\\images\\DownNoteFlag.png");
  private static final Image IMAGE = new Image(FILE.toURI().toString(), WIDTH, 100, true, true);

  private final int x;
  private final int y;

  public DownNoteFlag(int x, int y) {
    this.x = x - WIDTH;
    this.y = (int) (y + NoteStem.HEIGHT - IMAGE.getHeight() + NoteBody.HEIGHT/2 + 1);
  }

  @Override
  public void paint(Brush brush) {
    brush.paint(IMAGE, x, y);
  }
}
