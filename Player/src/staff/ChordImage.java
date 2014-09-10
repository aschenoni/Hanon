package staff;

import sheet.Brush;
import sheet.StaffPlaceable;

class ChordImage implements StaffPlaceable{
  private final NoteImage[] notes;

  ChordImage(NoteImage[] notes) {
    this.notes = notes;
  }

  @Override
  public void paint(Brush brush) {
    for (NoteImage n : notes) n.paint(brush);
  }

  public int getSpacing() {
    int max = 0;
    for (NoteImage n : notes)
      if (n.getSpacing() > max)
        max = n.getSpacing();
    return max;
  }
}
