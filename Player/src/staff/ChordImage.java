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
}
