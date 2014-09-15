package hanon.app.controller.player.component;

import hanon.app.controller.player.sheet.Brush;
import hanon.app.controller.player.staff.NoteComponent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;

/**
 * A body hole is the white gap of a half or whole note in sheet music.
 */
public class BodyHole implements NoteComponent {

  /**
   * The height and width of the actual ellipse should be set in by some offset.
   * This is because the passed adjustedX and adjustedY coordinates should be that of the actual
   * note, and not of the hole.
   */
  private static final int HEIGHT_OFFSET = 1;
  private static final int WIDTH_OFFSET = 4;

  private static final int HEIGHT = NoteBody.HEIGHT - 2* HEIGHT_OFFSET;
  private static final int WIDTH = NoteBody.WIDTH - 2* WIDTH_OFFSET;

  private final Ellipse ellipse;

  /**
   * The x and y coordinates of the body hole should be the same as the
   * coordinates of the note that it belongs to.
   */
  public BodyHole(int x, int y, int angle) {
    ellipse = RotatedEllipse.buildEllipse(
            x + WIDTH_OFFSET,
            y + HEIGHT_OFFSET,
            WIDTH,
            HEIGHT,
            angle);
  }

  public void draw(Brush brush) {
    Brush whiteBrush = brush.withColor(Color.WHITE);
    whiteBrush.paint(ellipse);
  }
}
