package components;

import javafx.scene.canvas.GraphicsContext;


public class RotatedEllipse {
  private final int x, y, width, height;
  private final double angle;

  public RotatedEllipse(int x, int y, int width, int height, double angle) {
    this.x = x;
    this.y = y;
    this.width = width;
    this.height = height;
    this.angle = angle;
  }

  public void draw(GraphicsContext g2) {
    g2.fillOval(x, y, width, height);
  }
}
