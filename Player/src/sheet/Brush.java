package sheet;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Shape;

public class Brush {
  private final Group group;
  private Paint paintColor;

  public Brush(Group group) {
    this.group = group;
    this.paintColor = Color.BLACK;
  }

  public void paint(Shape shape) {
    shape.setFill(paintColor);
    group.getChildren().add(shape);
  }

  public Paint getPaintColor() {
    return paintColor;
  }

  public void setPaintColor(Paint paintColor) {
    this.paintColor = paintColor;
  }
}
