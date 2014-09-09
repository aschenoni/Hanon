package image;

import javafx.scene.image.Image;
import sheet.Brush;

import java.io.File;

public class Clef {
  private static final File FILE = new File("Player\\res\\images\\TrebleClef.png");
  private static final Image IMAGE = new Image(FILE.toURI().toString(), 50, 100, true, true);

  public void draw(Brush brush, int x, int y) {
    System.out.println(FILE.isFile());
    brush.paint(IMAGE, x, y);
  }
}
