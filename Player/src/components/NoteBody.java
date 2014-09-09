package components;

import javafx.scene.Group;
import javafx.scene.canvas.GraphicsContext;
import sheet.Brush;
import sheet.Staff;

import java.awt.*;

public class NoteBody implements NoteComponent {
  public static final int BASE_OVAL_HEIGHT = Staff.LINE_GAP-1;
  public static final int BASE_OVAL_WIDTH = (int) (1.6*BASE_OVAL_HEIGHT);

  private final int x, y;
  private final float scale;

  public static int adjustedWidth(float scale) {
    return (int) (BASE_OVAL_WIDTH*scale);
  }

  public static int adjustedHeight(float scale) {
    return (int) (BASE_OVAL_HEIGHT *scale);
  }

  public NoteBody(int x, int y) {
    this.x = x;
    this.y = y;
    this.scale = (float) 1;
  }

  int x() {
    return x;
  }

  int y() {
    return y;
  }

  int width() {
    return adjustedWidth(scale);
  }

  int height() {
    return adjustedHeight(scale);
  }

  public void draw(Brush brush) {
    RotatedEllipse e = new RotatedEllipse(x(), y(), width(), height(), -20);
    e.draw(brush);
  }
}
