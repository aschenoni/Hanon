package hanon.app.model.player.staff;

import hanon.app.model.music.*;

public class Spacing {
  private static final int MEASURE_LINE_SPACING = 30;
  private static final int TIME_SIGNATURE_SPACING = 50;
  private static final int CLEF_SPACING = 50;

  public static Integer getSpacing(StaffElement element) {
    switch (element.getType()) {
      case NOTE:           return getNoteSpacing((MusicNote) element);
      case REST:           return getNoteLengthSpacing(((Rest) element).getLength());
      case CHORD:          return getChordSpacing((Chord) element);
      case TIME_SIGNATURE: return TIME_SIGNATURE_SPACING;
      case CLEF:           return CLEF_SPACING;
      case MEASURE_LINE:   return MEASURE_LINE_SPACING;
      case STAFF_LINES:    return 0;
      case TIE:            return 0;
      case SLUR:           return 0;
      default:             throw new RuntimeException("No such staff element type");
    }
  }

  private static int getChordSpacing(Chord chord) {
    int maxSpacing = 0;
    for (MusicNote n : chord.getNotes())
      if (getNoteSpacing(n) > maxSpacing)
        maxSpacing = getNoteSpacing(n);
    return maxSpacing;
  }

  private static int getNoteSpacing(MusicNote note) {
    return getNoteLengthSpacing(note.getLength());
  }

  private static int getNoteLengthSpacing(NoteLength length) {
    switch (length) {
      case sixteenth: return 20;
      case EIGHTH:    return 30;
      case QUARTER:   return 50;
      case HALF:      return 80;
      case WHOLE:     return 120;
      default:        return 20;
    }
  }
}
