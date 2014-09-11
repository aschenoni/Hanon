package staff;

import component.NoteStem;
import music.*;
import sheet.StaffPlaceable;

import java.util.ArrayList;
import java.util.List;

/**
 * The Staff Placeable Factory is responsible for building any elements that
 * could be drawn on the music staff.
 */
public class Staff {
  public static final int LINE_GAP = 10;

  private final NoteImageFactory noteFactory;
  private final int x;
  private final int y;

  public Staff(int x, int y) {
    this.x = x;
    this.y = y;
    noteFactory = new NoteImageFactory(y);
  }

  public List<StaffPlaceable> placeElements(List<StaffElement> elements) {
    List<Integer> spacings = StaffSpace.spaceNotesFrom(x, elements);

    List<StaffPlaceable> placeables = new ArrayList<StaffPlaceable>();
    for (int i = 0; i < elements.size(); i++)
      placeables.add(placeElement(spacings.get(i), elements.get(i)));
    return placeables;
  }

  private StaffPlaceable placeElement(int x, StaffElement element) {
    System.out.println(x);
    switch (element.getType()) {
      case NOTE:           return noteFactory.buildImage((MusicNote) element, x);
      case CHORD:          return new ChordImage(getNoteImages(x, ((Chord)element).getNotes()));
      case TIME_SIGNATURE: return new TimeSignatureImage((TimeSignature)element, x, y);
      case CLEF:           return new ClefImage(x, y -20);
      case MEASURE_LINE:   return new MeasureLine(x, y, 4* LINE_GAP);
      case STAFF_LINES:    return buildStaffLines(800);
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

  /**
   * Staff lines should be added to a staff AFTER everything else so that they
   * appear drawn over them.
   */
  private StaffLines buildStaffLines(int width) {
    return new StaffLines(this.x, y, width);
  }

}
