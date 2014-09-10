package staff;

import javafx.scene.shape.Rectangle;
import sheet.Brush;
import sheet.StaffPlaceable;

class MeasureLine implements StaffPlaceable {
  private final Rectangle rectangle;

  public MeasureLine(int x, int y, int height) {
    rectangle = new Rectangle(x, y, 1, height);
  }

  @Override
  public void paint(Brush brush) {
    brush.paint(rectangle);
  }

  @Override
  public int getSpacing() {
    return 30;
  }
}
