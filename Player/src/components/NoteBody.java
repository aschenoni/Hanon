package components;

import javafx.scene.shape.Ellipse;
import sheet.Brush;
import sheet.Staff;


public class NoteBody implements NoteComponent {
  public static final int HEIGHT = Staff.LINE_GAP-1;
  public static final int WIDTH = (int) (1.6* HEIGHT);
  public static final int ANGLE = -20;

  private final Ellipse ellipse;

  public NoteBody(int x, int y) {
    ellipse = RotatedEllipse.buildEllipse(x, y, WIDTH, HEIGHT, ANGLE);
  }

  public void draw(Brush brush) {
    brush.paint(ellipse);
  }
}
