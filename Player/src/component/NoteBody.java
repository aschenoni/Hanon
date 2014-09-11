package component;

import javafx.scene.shape.Ellipse;
import staff.NoteComponent;
import sheet.Brush;
import staff.StaffPlaceableFactory;


public class NoteBody implements NoteComponent {
  public static final int HEIGHT = StaffPlaceableFactory.LINE_GAP-1;
  public static final int WIDTH = (int) (1.6* HEIGHT);

  private final Ellipse ellipse;

  public NoteBody(int x, int y, int angle) {
    ellipse = RotatedEllipse.buildEllipse(x, y, WIDTH, HEIGHT, angle);
  }

  public void draw(Brush brush) {
    brush.paint(ellipse);
  }
}
