package hanon.app.controller.music;

import java.util.List;

public class StaffElementSet {
  private final Clef clef;
  private final List<StaffElement> elements;

  public StaffElementSet(Clef clef, List<StaffElement> elements) {
    this.clef = clef;
    this.elements = elements;
  }

  public List<StaffElement> getElements() {
    return elements;
  }

  public Clef getClef() {
    return clef;
  }
}
