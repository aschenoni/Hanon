package hanon.app.model.player.staff;

import hanon.app.model.music.NoteLength;
import hanon.app.model.music.Rest;
import hanon.app.model.player.sheet.Brush;
import hanon.app.model.player.sheet.StaffPlaceable;
import javafx.scene.image.Image;

import java.io.File;

public class RestImage implements StaffPlaceable {
  private static final File QUARTER_REST_FILE = new File("res\\images\\QuarterRest.png");
  private static final Image QUARTER_REST_IMAGE = new Image(QUARTER_REST_FILE.toURI().toString(), 50, 35, true, true);

  public static RestImage fromRest(Rest rest, int x, int y) {
    return new RestImage(x, y, getImage(rest.getLength()));
  }

  private static Image getImage(NoteLength length) {
    switch (length) {
      case QUARTER: return QUARTER_REST_IMAGE;
      default:      throw new RuntimeException("No such rest length");
    }
  }

  private final int x, y;
  private final Image image;

  public RestImage(int x, int y, Image image) {
    this.x = x;
    this.y = y;
    this.image = image;
  }

  @Override
  public void paint(Brush brush) {
    brush.paint(image, x, y+2);
  }
}
