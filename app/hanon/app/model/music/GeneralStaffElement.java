package hanon.app.model.music;

import static hanon.app.model.music.StaffElementType.*;

public class GeneralStaffElement implements StaffElement {
  private final StaffElementType type;

  public static GeneralStaffElement clef() {
    return new GeneralStaffElement(CLEF);
  }

  public static GeneralStaffElement measureLine() {
    return new GeneralStaffElement(MEASURE_LINE);
  }

  public static GeneralStaffElement staffLines() {
    return new GeneralStaffElement(STAFF_LINES);
  }

  private GeneralStaffElement(StaffElementType type) {
    this.type = type;
  }

  @Override
  public StaffElementType getType() {
    return type;
  }
}
