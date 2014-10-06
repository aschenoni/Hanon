package hanon.app.model.player.staff;

import hanon.app.model.player.noteimage.NoteImage;
import hanon.app.model.player.sheet.Brush;
import hanon.app.model.player.sheet.StaffPlaceable;

import java.util.Optional;

public class TieImage implements StaffPlaceable {
  private final NoteImage note1;
  private final NoteImage note2;
  private final Optional<MeasureLine> measureLine;

  public TieImage(NoteImage note1, NoteImage note2, Optional<MeasureLine> measureLine) {
    this.note1 = note1;
    this.note2 = note2;
    this.measureLine = measureLine;
  }

  @Override
  public void paint(final Brush brush) {
    note1.paint(brush);
    note2.paint(brush);
    if (measureLine.isPresent()) {
      measureLine.get().paint(brush);
    }
  }
}
