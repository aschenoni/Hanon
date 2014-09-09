package components;

import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import sheet.Brush;

public class BodyHole implements NoteComponent {
  private static final int BASE_HEIGHT_OFFSET = 1;
  private static final int BASE_WIDTH_OFFSET = 4;
  private static final int BASE_HOLE_HEIGHT = NoteBody.BASE_OVAL_HEIGHT - 2*BASE_HEIGHT_OFFSET;
  private static final int BASE_HOLE_WIDTH = NoteBody.BASE_OVAL_WIDTH - 2*BASE_WIDTH_OFFSET;

  private final int baseX;
  private final int baseY;
  private final float scale;

  public BodyHole(int x, int y) {
    this.baseX = x;
    this.baseY = y;
    this.scale = (float) 1;
  }

  int x() {
    return baseX + widthOffset();
  }

  int y() {
    return baseY + heightOffset();
  }

  int width() {
    return (int) (BASE_HOLE_WIDTH * scale);
  }

  int height() {
    return (int) (BASE_HOLE_HEIGHT * scale);
  }

  private int widthOffset() {
    return (int)(BASE_WIDTH_OFFSET*scale);
  }

  private int heightOffset() {
    return (int)(BASE_HEIGHT_OFFSET*scale);
  }

  public void draw(Brush brush) {
    RotatedEllipse e = new RotatedEllipse(x(), y(), width(), height(), -20);
    Paint p = brush.getPaintColor();
    brush.setPaintColor(Color.WHITE);
    e.draw(brush);
    brush.setPaintColor(p);
  }
}
