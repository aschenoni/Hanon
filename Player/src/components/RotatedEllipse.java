package components;

import javafx.scene.shape.Ellipse;
import javafx.scene.transform.Rotate;
import sheet.Brush;

class RotatedEllipse {
  private final int x, y, width, height;
  private final double angle;

  public RotatedEllipse(int x, int y, int width, int height, double angle) {
    this.x = x;
    this.y = y;
    this.width = width;
    this.height = height;
    this.angle = angle;
  }

  public void draw(Brush brush) {
    Ellipse e = new Ellipse(x+width/2, y+height/2, width/2, height/2);

    Rotate r = new Rotate(angle);
    r.setPivotX(x+width/2);
    r.setPivotY(y+height/2);
    e.getTransforms().add(r);
    brush.paint(e);
  }
}
