package image;

import javafx.scene.image.Image;
import sheet.Brush;
import sheet.StaffPlaceable;

import java.io.File;

public class Clef implements StaffPlaceable {
  private static final File FILE = new File("Player\\res\\images\\TrebleClef.png");
  private static final Image IMAGE = new Image(FILE.toURI().toString(), 50, 100, true, true);

  private final int x;
  private final int y;

  public Clef(int x, int y) {
    this.x = x;
    this.y = y;
  }

  public void paint(Brush brush) {
    brush.paint(IMAGE, x, y);
  }

  @Override
  public int getSpacing() {
    return 50;
  }
}
