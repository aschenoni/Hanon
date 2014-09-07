package components;

import javafx.scene.canvas.GraphicsContext;

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

  public void draw(GraphicsContext g2) {
    g2.fillRect(x(), y(), width(), height());
  }

  public static NoteStem fromPosition(int x, int y, float scale, int staffY) {
    return new DownNoteStem(x, y, scale);
  }

}
