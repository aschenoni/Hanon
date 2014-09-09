package sheet;

import javafx.scene.Group;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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
  private final GraphicsContext graphicsContext;
  private final Paint paintColor;

  private Brush(Group group, GraphicsContext graphicsContext, Paint paintColor) {
    this.group = group;
    this.graphicsContext = graphicsContext;
    this.paintColor = paintColor;
  }

  public Brush(Group group, GraphicsContext graphicsContext) {
    this(group, graphicsContext, DEFAULT_COLOR);
  }

  public void paint(Shape shape) {
    shape.setFill(paintColor);
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
    return new Brush(group, graphicsContext, paintColor);
  }
}
