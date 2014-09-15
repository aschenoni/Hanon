package hanon.app.controller.player.staff;

import hanon.app.controller.player.sheet.Brush;
import hanon.app.controller.player.sheet.StaffPlaceable;
import javafx.scene.shape.Rectangle;

class MeasureLine implements StaffPlaceable {
  private final Rectangle rectangle;

  public MeasureLine(int x, int y, int height) {
    rectangle = new Rectangle(x, y, 1, height);
  }

  @Override
  public void paint(Brush brush) {
    brush.paint(rectangle);
  }
}
