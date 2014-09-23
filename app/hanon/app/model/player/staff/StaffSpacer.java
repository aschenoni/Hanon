package hanon.app.model.player.staff;

import hanon.app.model.music.*;

import java.util.ArrayList;
import java.util.List;

public class StaffSpacer {
  private static final int MEASURE_LINE_SPACING = 30;
  private static final int TIME_SIGNATURE_SPACING = 50;
  private static final int CLEF_SPACING = 50;

  private class SpacingResult {

    private final List<Integer> spacings;

    private final List<StaffElement> unallocatedElements;
    private SpacingResult(List<Integer> spacings, List<StaffElement> unallocatedElements) {
      this.spacings = spacings;
      this.unallocatedElements = unallocatedElements;
    }
  }

  private final int width;
  private final List<StaffElement> elements;

  public StaffSpacer(int width, List<StaffElement> elements) {
    this.width = width;
    this.elements = elements;
  }

  public List<Integer> getAllocatedSpacings() {
    return allocateSpacings().spacings;
  }

  public List<StaffElement> getUnspacedElements() {
    return allocateSpacings().unallocatedElements;
  }


  private SpacingResult allocateSpacings() {
    List<Integer> spacings = getAllSpacings();

    int closest = getClosestMeasureToWidthSpacing(spacings);
    int diff = width-closest;
    int ind = getIndexOfSpecifiedSpacing(spacings, closest);
    List<Integer> revisedSpacings = reviseSpacings(spacings, diff, ind);

    return getSpacingResult(revisedSpacings);
  }


  /**
   * Given a list of spacings, find the measure spacing which is closest to the
   * width of the staff.
   */
  private int getClosestMeasureToWidthSpacing(List<Integer> spacings) {
    List<Integer> measureSpacings = getMeasureSpacings(spacings);
    return getClosestMeasurePositionToWidth(measureSpacings);
  }

  private int getIndexOfSpecifiedSpacing(List<Integer> spacings, int specifiedSpacing) {
    for(int i = 0; i < spacings.size(); i++)
      if (specifiedSpacing == spacings.get(i)) return i;
    return -1;
  }

  /**
   * Reallocate the spacings so that they appropriately fit into the staff width.
   *
   * @param spacings The original set of spacings.
   * @param diff The difference between the last element to be fit into the
   *             staff and the staff width.
   * @param ind The index of the last element to be fit into the staff.
   */
  private List<Integer> reviseSpacings(List<Integer> spacings, int diff, int ind) {
    List<Integer> revisedSpacings = new ArrayList<Integer>();
    for (int i = 0; i < spacings.size(); i++) {
      int newSpacing = (int) (spacings.get(i) + diff*(i/(float)ind));
      revisedSpacings.add(newSpacing);
    }
    return revisedSpacings;
  }

  /**
   * Acquire an unadjusted spacing of the elements that is based purely on each
   * elements default spacing.
   */
  private List<Integer> getAllSpacings() {
    int x = 0;
    List<Integer> spacings = new ArrayList<Integer>();
    for (StaffElement e : elements) {
      spacings.add(x);
      x += getSpacing(e);
    }
    return spacings;
  }

  /**
   * Given a set of spacings, give a list of spacings that are only for measure
   * lines.
   */
  private List<Integer> getMeasureSpacings(List<Integer> spacings) {
    List<Integer> sp = new ArrayList<Integer>();
    for (int i = 0; i < spacings.size(); i++)
      if (elements.get(i).getType() == StaffElementType.MEASURE_LINE)
        sp.add(spacings.get(i));
    return sp;
  }

  /**
   * Given a set of measure spacings, get the spacing that is closest to the
   * width of the staff.
   */
  public int getClosestMeasurePositionToWidth(List<Integer> measureSpacings) {
    int dist = Integer.MAX_VALUE;
    int closest = Integer.MAX_VALUE;
    for (int i : measureSpacings) {
      if (Math.abs(width - i) < dist) {
        dist = Math.abs(width - i);
        closest = i;
      }
    }
    return closest;
  }

  /**
   * Form the spacing result. The spacing result includes the list of spacings
   * for the most recent line and the list of elements that do not yet have
   * spacings allocated.
   */
  private SpacingResult getSpacingResult(List<Integer> spacings) {
    List<Integer> underMaxWidth = getUnderMaxWidth(spacings);
    List<StaffElement> remaining = new ArrayList<StaffElement>();
    for (int i = underMaxWidth.size(); i < elements.size(); i++)
      remaining.add(elements.get(i));
    return new SpacingResult(underMaxWidth, remaining);
  }

  /**
   * Given a set of spacings, return a new set of spacings that only includes
   * those spacings that are inside the width of the staff.
   */
  private List<Integer> getUnderMaxWidth(List<Integer> spacings) {
    List<Integer> underMaxWidth = new ArrayList<Integer>();
    for (int i : spacings)
      if (i <= width)
        underMaxWidth.add(i);
    return underMaxWidth;
  }

  private int getSpacing(StaffElement element) {
    switch (element.getType()) {
      case NOTE:           return getNoteSpacing((MusicNote) element);
      case REST:           return getNoteLengthSpacing(((Rest) element).getLength());
      case CHORD:          return getChordSpacing((Chord) element);
      case TIME_SIGNATURE: return TIME_SIGNATURE_SPACING;
      case CLEF:           return CLEF_SPACING;
      case MEASURE_LINE:   return MEASURE_LINE_SPACING;
      case STAFF_LINES:    return 0;
      default:             throw new RuntimeException("No such staff element type");
    }
  }

  private int getChordSpacing(Chord chord) {
    int maxSpacing = 0;
    for (MusicNote n : chord.getNotes())
      if (getNoteSpacing(n) > maxSpacing)
        maxSpacing = getNoteSpacing(n);
    return maxSpacing;
  }

  private int getNoteSpacing(MusicNote note) {
    return getNoteLengthSpacing(note.getLength());
  }

  private int getNoteLengthSpacing(NoteLength length) {
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
