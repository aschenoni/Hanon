package hanon.app.model.player.staff;

import hanon.app.model.player.sheet.Brush;
import hanon.app.model.player.sheet.StaffPlaceable;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;
import java.util.List;

class StaffLines implements StaffPlaceable {
  private final List<Rectangle> rectangles = new ArrayList<>();

  public StaffLines(int x, int y, int width) {
    for (int i = 0; i < 5; i++)
      rectangles.add(new Rectangle(x, y + Staff.LINE_GAP*i, width, 1));
  }

  @Override
  public void paint(Brush brush) {
    for (Rectangle r : rectangles) brush.paint(r);
  }

}
