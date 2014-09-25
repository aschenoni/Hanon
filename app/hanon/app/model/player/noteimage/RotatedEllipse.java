package hanon.app.model.player.noteimage;

import javafx.scene.shape.Ellipse;
import javafx.scene.transform.Rotate;

class RotatedEllipse {

  /**
   * Constructs an ellipse that has been rotated about its center by 'angle'
   * degrees.
   */
  public static Ellipse buildEllipse(int x, int y, int width, int height, int angle) {
    Ellipse ellipse = new Ellipse(x+width/2, y+height/2, width/2, height/2);
    Rotate r = buildRotation(x, y, width, height, angle);
    ellipse.getTransforms().add(r);
    return ellipse;
  }

  private static Rotate buildRotation(int x, int y, int width, int height, int angle) {
    Rotate r = new Rotate(angle);
    r.setPivotX(x + width / 2);
    r.setPivotY(y + height / 2);
    return r;
  }
}
