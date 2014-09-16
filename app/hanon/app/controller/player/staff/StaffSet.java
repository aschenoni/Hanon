package hanon.app.controller.player.staff;

import hanon.app.controller.music.Chord;
import hanon.app.controller.music.GeneralStaffElement;
import hanon.app.controller.music.MusicNote;
import hanon.app.controller.music.StaffElement;
import hanon.app.controller.music.TimeSignature;
import hanon.app.controller.player.component.NoteStem;
import hanon.app.controller.player.sheet.StaffPlaceable;

import java.util.ArrayList;
import java.util.List;

/**
 * The Staff Placeable Factory is responsible for building any elements that
 * could be drawn on the music staff.
 */
public class StaffSet {
  private final int x;
  private int y;
  private final int width;
  private NoteImageFactory noteFactory;

  public StaffSet(int x, int y, int width) {
    this.x = x;
    this.y = y;
    this.width = width;
  }

  /**
   * Takes a list of Staff Elements and correctly places their images on a
   * staff.
   */
  public List<Staff> placeElements(List<StaffElement> elements) {
    List<Staff> staffs = new ArrayList<Staff>();
    while (!elements.isEmpty()) {
      elements.add(0, GeneralStaffElement.clef());
      staffs.add(buildStaff(elements));
      elements = new StaffSpacer(width, elements).getUnspacedElements();
      y += 100;
    }
    return staffs;
  }

  private Staff buildStaff(List<StaffElement> elements) {
    List<Integer> spacings = new StaffSpacer(width, elements).getAllocatedSpacings();
    List<StaffPlaceable> placeables = new ArrayList<StaffPlaceable>();
    for (int i = 0; i < spacings.size(); i++)
      placeables.add(placeElement(spacings.get(i), elements.get(i)));
    return new Staff(placeables, x, y, width);
  }

  private StaffPlaceable placeElement(int x, StaffElement element) {
    x += this.x;
    noteFactory = new NoteImageFactory(y);
    switch (element.getType()) {
      case NOTE:           return noteFactory.buildImage((MusicNote) element, x);
      case CHORD:          return new ChordImage(getNoteImages(x, ((Chord)element).getNotes()));
      case TIME_SIGNATURE: return new TimeSignatureImage((TimeSignature)element, x, y);
      case CLEF:           return new ClefImage(x, y -20);
      case MEASURE_LINE:   return new MeasureLine(x, y, 4* Staff.LINE_GAP);
      case STAFF_LINES:    return new StaffLines(this.x, y, width);
      default:             throw new NoSuchStaffElementException();
    }
  }

  private NoteImage[] getNoteImages(int x, MusicNote[] notes) {
    boolean up = NoteStem.shouldStemGoUp(notes);
    NoteImage[] images = new NoteImage[notes.length];
    for (int i = 0; i < notes.length; i++)
      if (up) images[i] = noteFactory.buildUpImage(notes[i], x);
      else    images[i] = noteFactory.buildDownImage(notes[i], x);
    return images;
  }
}
