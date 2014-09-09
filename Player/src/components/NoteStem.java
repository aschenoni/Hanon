package components;

import javafx.scene.Group;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.shape.*;
import javafx.scene.shape.Rectangle;
import sheet.Brush;
import sheet.Staff;

import java.awt.*;

@SuppressWarnings("SameParameterValue")
public abstract class NoteStem implements NoteComponent {
  private static final int BASE_STEM_WIDTH = 1;
  private static final int BASE_STEM_HEIGHT = 35;

  protected abstract float scale();

  protected abstract int x();

  protected abstract int y();

  int width() {
    return (int)(BASE_STEM_WIDTH *scale());
  }

  int height() {
    return (int)(BASE_STEM_HEIGHT *scale());
  }

  public void draw(Brush brush) {
    brush.paint(new Rectangle(x(), y(), width(), height()));
  }

  public static NoteStem fromPosition(int x, int y, float scale, int staffY) {
    if (y < staffY + 2*Staff.LINE_GAP)
      return new DownNoteStem(x, y, scale);
    else
      return new UpNoteStem(x, y, scale);
  }

}
