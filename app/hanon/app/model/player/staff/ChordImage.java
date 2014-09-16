package hanon.app.model.player.staff;

import hanon.app.model.player.sheet.Brush;
import hanon.app.model.player.sheet.StaffPlaceable;

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
