package hanon.app.controller.player.staff;

import hanon.app.controller.player.sheet.Brush;
import hanon.app.controller.player.sheet.StaffPlaceable;

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
