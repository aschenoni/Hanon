package components;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;

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

  public void draw(Graphics2D g2) {
    Shape e = AffineTransform.getRotateInstance(angle)
            .createTransformedShape(new Ellipse2D.Float(0, 0, width, height));
    e = AffineTransform.getTranslateInstance(x, y).createTransformedShape(e);
    g2.fill(e);
  }
}
