package hanon.app.model.player.staff;

import hanon.app.model.music.Clef;
import hanon.app.model.player.sheet.Brush;
import hanon.app.model.player.sheet.StaffPlaceable;
import javafx.scene.image.Image;

import java.io.File;

class ClefImage implements StaffPlaceable {
  private static final File TREBLE_CLEF_FILE = new File("res\\images\\TrebleClef.png");
  private static final File BASS_CLEF_FILE = new File("res\\images\\BassClef.png");

  private static final Image TREBLE_IMAGE = new Image(TREBLE_CLEF_FILE.toURI().toString(), 50, 100, true, true);
  private static final Image BASS_IMAGE =   new Image(BASS_CLEF_FILE.toURI().toString(), 50, 35, true, true);

  private final int x;
  private final int y;
  private final Image image;

  public ClefImage(Clef type, int x, int y) {
    if (type == Clef.BASS) {
      this.x = x+4;
      this.y = y;
      image = BASS_IMAGE;
    }
    else {
      this.x = x - 5;
      this.y = y-20;
      image = TREBLE_IMAGE;
    }
  }

  public void paint(Brush brush) {
    brush.paint(image, x, y);
  }

}
