package staff;

import music.*;

import java.util.ArrayList;
import java.util.List;

class StaffSpace {
  private static final int MEASURE_LINE_SPACING = 30;
  private static final int TIME_SIGNATURE_SPACING = 50;
  private static final int CLEF_SPACING = 50;

  public static List<Integer> spaceNotesFrom(int x, List<StaffElement> elements) {
    List<Integer> spacings = new ArrayList<Integer>();
    for (StaffElement e : elements) {
      spacings.add(x);
      x += getSpacing(e);
    }
    return spacings;
  }

  private static int getSpacing(StaffElement element) {
    switch (element.getType()) {
      case NOTE:           return getNoteSpacing((MusicNote) element);
      case CHORD:          return getChordSpacing((Chord) element);
      case TIME_SIGNATURE: return TIME_SIGNATURE_SPACING;
      case CLEF:           return CLEF_SPACING;
      case MEASURE_LINE:   return MEASURE_LINE_SPACING;
      case STAFF_LINES:    return 0;
      default:             throw new NoSuchStaffElementException();
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
    switch (note.getLength()) {
      case sixteenth: return 20;
      case eighth:    return 30;
      case quarter:   return 50;
      case half:      return 80;
      case whole:     return 120;
      default:        return 20;
    }
  }
}
