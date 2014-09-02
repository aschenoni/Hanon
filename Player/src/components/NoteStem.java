package components;

import sheet.Staff;

import java.awt.*;

public abstract class NoteStem {
  public static final int BASE_STEM_WIDTH = 1;
  public static final int BASE_STEM_HEIGHT = 35;

  public abstract float scale();

  protected abstract int x();

  protected abstract int y();

  public int width() {
    return (int)(BASE_STEM_WIDTH *scale());
  }

  public int height() {
    return (int)(BASE_STEM_HEIGHT *scale());
  }

  public void draw(Graphics2D g2) {
    g2.fillRect(x(), y(), width(), height());
  }

  public static NoteStem fromPosition(int x, int y, float scale, int staffY) {
    if (y < staffY + 2  * (scale)*Staff.BASE_LINE_GAP)
      return new DownNoteStem(x, y, scale);
    else
      return new UpNoteStem(x, y, scale);
  }

}
