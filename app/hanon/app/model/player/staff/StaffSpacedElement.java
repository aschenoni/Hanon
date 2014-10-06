package hanon.app.model.player.staff;

import hanon.app.model.music.StaffElement;
import hanon.app.model.music.StaffElementType;

public class StaffSpacedElement {
  private final StaffElement element;
  private final int x;

  public StaffSpacedElement(StaffElement element, int x) {
    this.element = element;
    this.x = x;
  }

  public int getX() {
    return x;
  }

  public StaffSpacedElement moveX(int diff) {
    return new StaffSpacedElement(element, x + diff);
  }

  public StaffElement getElement() {
    return element;
  }

  public boolean isStaffLine() {
    return element.getType().equals(StaffElementType.MEASURE_LINE);
  }

  @Override
  public String toString() {
    return "Element: [" + element.toString() + "], x: [" + x + "]";
  }
}
