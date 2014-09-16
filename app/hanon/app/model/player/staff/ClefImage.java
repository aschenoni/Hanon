package hanon.app.model.player.staff;

import hanon.app.model.player.sheet.Brush;
import hanon.app.model.player.sheet.StaffPlaceable;
import javafx.scene.image.Image;

import java.io.File;

class ClefImage implements StaffPlaceable {
  private static final File FILE = new File("res\\images\\TrebleClef.png");
  private static final Image IMAGE = new Image(FILE.toURI().toString(), 50, 100, true, true);

  private final int x;
  private final int y;

  public ClefImage(int x, int y) {
    this.x = x;
    this.y = y;
  }

  public void paint(Brush brush) {
    brush.paint(IMAGE, x, y);
  }

}
