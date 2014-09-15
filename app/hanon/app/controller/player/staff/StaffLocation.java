package hanon.app.controller.player.staff;

import hanon.app.controller.music.Chord;
import hanon.app.controller.music.MusicNote;
import hanon.app.controller.music.StaffElement;

import java.util.ArrayList;
import java.util.List;

public class StaffLocation {
  private static final int MEASURE_LINE_SPACING = 30;
  private static final int TIME_SIGNATURE_SPACING = 50;
  private static final int CLEF_SPACING = 50;

  private static class SpacingResult {
    private final List<Integer> spacings;
    private final List<StaffElement> unallocatedElements;

    private SpacingResult(List<Integer> spacings, List<StaffElement> unallocatedElements) {
      this.spacings = spacings;
      this.unallocatedElements = unallocatedElements;
    }
  }

  public static List<Integer> spaceLineOfNotes(List<StaffElement> elements, int maxWidth) {
    return doSpaceLineOfNotes(elements, maxWidth).spacings;
  }

  public static List<StaffElement> getUnspacedElements(List<StaffElement> originalElements, int maxWidth) {
    return doSpaceLineOfNotes(originalElements, maxWidth).unallocatedElements;
  }

  public static SpacingResult doSpaceLineOfNotes(List<StaffElement> elements, int maxWidth) {
    int x = 0;
    List<Integer> spacings = new ArrayList<Integer>();
    for (StaffElement e : elements) {
      spacings.add(x);
      x += getSpacing(e);
    }

    List<Integer> underMaxWidth = getUnderMaxWidth(maxWidth, spacings);

    List<StaffElement> remaining = new ArrayList<StaffElement>();
    for (int i = underMaxWidth.size(); i < elements.size(); i++) {
      remaining.add(elements.get(i));
    }

    return new SpacingResult(underMaxWidth, remaining);
  }


  private static List<Integer> getUnderMaxWidth(int maxWidth, List<Integer> spacings) {
    List<Integer> underMaxWidth = new ArrayList<Integer>();
    for (int i : spacings)
      if (i < maxWidth)
        underMaxWidth.add(i);
    return underMaxWidth;
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