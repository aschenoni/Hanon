package sheet;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Shape;

/**
 * A brush is the tool used to add shapes to a scene's group of shapes. The
 * group should be created and set as the scene for the stage of the canvas:
 *
 *   Group group = new Group();
 *   Canvas canvas = new Canvas(WIDTH, HEIGHT);
 *   group.getChildren().add(canvas);
 *   stage.setScene(new Scene(group));
 *   stage.show();
 *   Brush brush = new Brush(group);
 *
 * In this manner the brush can be used to draw shapes onto the canvas.
 */
public class Brush {
  public static final Color DEFAULT_COLOR = Color.BLACK;

  private final Group group;
  private final Paint paintColor;

  private Brush(Group group, Paint paintColor) {
    this.group = group;
    this.paintColor = paintColor;
  }

  public Brush(Group group) {
    this(group, DEFAULT_COLOR);
  }

  public void paint(Shape shape) {
    shape.setFill(paintColor);
    group.getChildren().add(shape);
  }

  /**
   * Create a new brush that draws to the same shape group, but in a different
   * color.
   */
  public Brush withColor(Paint paintColor) {
    return new Brush(group, paintColor);
  }
}
