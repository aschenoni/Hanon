package components;

import sheet.Staff;

import java.awt.*;

public class NoteBody {
  public static final int BASE_OVAL_HEIGHT = Staff.BASE_LINE_GAP - 1;
  public static final int BASE_OVAL_WIDTH = (int) (1.8*BASE_OVAL_HEIGHT);

  private final int x, y;
  private final float scale;

  public static int adjustedWidth(float scale) {
    return (int) (BASE_OVAL_WIDTH*scale);
  }

  public static int adjustedHeight(float scale) {
    return (int) (BASE_OVAL_HEIGHT *scale);
  }

  public NoteBody(int x, int y, float scale) {
    this.x = x;
    this.y = y;
    this.scale = scale;
  }

  public int x() {
    return x;
  }

  public int y() {
    return y;
  }

  public int width() {
    return adjustedWidth(scale);
  }

  public int height() {
    return adjustedHeight(scale);
  }

  public void draw(Graphics2D g2) {
    RotatedEllipse e = new RotatedEllipse(x(), y()+3, width(), height(), -Math.PI/12);
    e.draw(g2);
    //g2.fillOval(x(), y() + 1, width(), height());
  }
}
