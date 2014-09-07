package components;

import javafx.scene.Group;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Ellipse;
import javafx.scene.transform.Rotate;

public class RotatedEllipse {
  private final int x, y, width, height;
  private final double angle;
  private Paint color = Color.BLACK;

  public RotatedEllipse(int x, int y, int width, int height, double angle) {
    this.x = x;
    this.y = y;
    this.width = width;
    this.height = height;
    this.angle = angle;
  }

  public void setColor(Paint color) {
    this.color = color;
  }

  public void draw(GraphicsContext g2, Group root) {
    Ellipse e = new Ellipse(x+width/2, y+height/2, width/2, height/2);

    Rotate r = new Rotate(angle);
    r.setPivotX(x+width/2);
    r.setPivotY(y+height/2);
    e.getTransforms().add(r);

    e.setFill(color);
    root.getChildren().add(e);
  }
}
