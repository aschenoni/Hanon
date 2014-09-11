package staff;

import sheet.Brush;
import sheet.StaffPlaceable;

import java.util.List;

public class Staff {
  public static final int LINE_GAP = 10;

  private final List<StaffPlaceable> elements;
  private final StaffLines lines;
  private final MeasureLine startOfStaff;

  public Staff(List<StaffPlaceable> elements, int x, int y, int width) {
    this.elements = elements;
    lines = new StaffLines(x, y, width);
    startOfStaff = new MeasureLine(x, y, 4* LINE_GAP);
  }

  public void paint(Brush brush) {
    for (StaffPlaceable e : elements) e.paint(brush);
    lines.paint(brush);
    startOfStaff.paint(brush);
  }
}
