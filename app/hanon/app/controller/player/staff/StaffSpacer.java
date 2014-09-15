package hanon.app.controller.player.staff;

import hanon.app.controller.music.NoteLength;

class StaffSpacer {
  private static final int MEASURE_LINE_SPACING = 30;
  private static final int TIME_SIGNATURE_SPACING = 50;
  private static final int CLEF_SPACING = 50;

  private int x;

  public StaffSpacer(int startX) {
    x = startX;
  }

  public int getX() {
    return x;
  }

  public void spaceForClef() {
    x += CLEF_SPACING;
  }

  public void spaceForTimeSignature() {
    x += TIME_SIGNATURE_SPACING;
  }

  public void spaceForMeasureLine() {
    x += MEASURE_LINE_SPACING;
  }

  public void spaceForNote(NoteLength length) {
    x += getNoteSpacing(length);
  }

  public void spaceForChord(NoteLength... lengths) {
    int maxSpacing = 0;
    for (NoteLength len : lengths)
      if (getNoteSpacing(len) > maxSpacing)
        maxSpacing = getNoteSpacing(len);
    x += maxSpacing;
  }

  private int getNoteSpacing(NoteLength length) {
    switch (length) {
      case sixteenth: return 20;
      case eighth:    return 30;
      case quarter:   return 50;
      case half:      return 80;
      case whole:     return 120;
      default:        return 20;
    }
  }
}
