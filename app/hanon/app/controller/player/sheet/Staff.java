package hanon.app.controller.player.sheet;

import java.util.ArrayList;
import java.util.List;

public class Staff {
  public static final int LINE_GAP = 10;
  private final int y;

  private final List<StaffPlaceable> elements = new ArrayList<StaffPlaceable>();

  public Staff(int y) {
    this.y = y;
  }

  public void paint(Brush brush) {
    for (StaffPlaceable e : elements) e.paint(brush);
  }

  public void addElement(StaffPlaceable s) {
    elements.add(s);
  }

  public int getY() {
    return y;
  }
}

