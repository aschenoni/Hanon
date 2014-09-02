package notes;

import java.awt.*;

public abstract class NoteStem {
  public static final int BASE_STEM_WIDTH = 2;
  public static final int BASE_STEM_HEIGHT = 30;

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

}
