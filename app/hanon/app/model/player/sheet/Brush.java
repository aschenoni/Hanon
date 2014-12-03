package hanon.app.model.player.sheet;

import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Line;
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
 * In this manner the brush can be used to paint shapes onto the canvas.
 */
public class Brush {
  private static final Color DEFAULT_COLOR = Color.BLACK;

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
    if (shape instanceof Line)
      shape.setStroke(paintColor);
    else
      shape.setFill(paintColor);
    if (group.getChildren().contains(shape))
      group.getChildren().remove(shape);
    group.getChildren().add(shape);
  }

  public void paint(Image image, int x, int y) {
    ImageView im = new ImageView(image);
    im.setX(x);
    im.setY(y);
    group.getChildren().add(im);
  }

  /**
   * Create a new brush that draws to the same shape group, but in a different
   * color.
   */
  public Brush withColor(Paint paintColor) {
    return new Brush(group, paintColor);
  }
}
