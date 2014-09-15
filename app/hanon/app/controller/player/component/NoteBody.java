package hanon.app.controller.player.component;

import hanon.app.controller.player.sheet.Brush;
import hanon.app.controller.player.staff.NoteComponent;
import hanon.app.controller.player.staff.Staff;
import javafx.scene.shape.Ellipse;


public class NoteBody implements NoteComponent {
  public static final int HEIGHT = Staff.LINE_GAP-1;
  public static final int WIDTH = (int) (1.6* HEIGHT);

  private final Ellipse ellipse;

  public NoteBody(int x, int y, int angle) {
    ellipse = RotatedEllipse.buildEllipse(x, y, WIDTH, HEIGHT, angle);
  }

  public void draw(Brush brush) {
    brush.paint(ellipse);
  }
}