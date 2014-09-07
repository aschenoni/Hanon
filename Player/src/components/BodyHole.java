package components;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.*;
import javafx.scene.paint.Paint;
import sheet.SheetPanel;

import java.awt.*;

public class BodyHole {
  public static final int BASE_HEIGHT_OFFSET = 1;
  public static final int BASE_WIDTH_OFFSET = 4;
  public static final int BASE_HOLE_HEIGHT = NoteBody.BASE_OVAL_HEIGHT - 2*BASE_HEIGHT_OFFSET;
  public static final int BASE_HOLE_WIDTH = NoteBody.BASE_OVAL_WIDTH - 2*BASE_WIDTH_OFFSET;

  private final int baseX;
  private final int baseY;
  private final float scale;

  public BodyHole(int x, int y, float scale) {
    this.baseX = x;
    this.baseY = y;
    this.scale = scale;
  }

  public int x() {
    return baseX + widthOffset();
  }

  public int y() {
    return baseY + heightOffset();
  }

  public int width() {
    return (int) (BASE_HOLE_WIDTH * scale);
  }

  public int height() {
    return (int) (BASE_HOLE_HEIGHT * scale);
  }

  private int widthOffset() {
    return (int)(BASE_WIDTH_OFFSET*scale);
  }

  private int heightOffset() {
    return (int)(BASE_HEIGHT_OFFSET*scale);
  }

  public void draw(GraphicsContext g2) {
    Paint c = g2.getFill();
    g2.setFill(SheetPanel.BACKGROUND_COLOR);
    g2.fillOval(x(), y()+1, width(), height());
    g2.setFill(c);
  }


}
