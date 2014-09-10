package staff;

import component.NoteStem;
import music.MusicNote;
import music.NoteLength;
import music.TimeSignature;
import sheet.Staff;

/**
 * The Staff Placeable Factory is responsible for building any elements that
 * could be drawn on the music staff.
 */
public class StaffPlaceableFactory {
  public static final int MEASURE_LINE_SPACING = 30;
  public static final int TIME_SIGNATURE_SPACING = 50;
  public static final int CLEF_SPACING = 50;

  public static int getNoteSpacing(NoteLength length) {
    switch (length) {
      case sixteenth: return 20;
      case eighth:    return 30;
      case quarter:   return 50;
      case half:      return 80;
      case whole:     return 120;
      default:        return 20;
    }
  }


  private final int originalX;
  private final int staffY;
  private int currentX;

  private final NoteImageFactory noteFactory;

  public StaffPlaceableFactory(int currentX, int staffY) {
    this.originalX = currentX;
    this.currentX  = currentX;
    this.staffY    = staffY;
    noteFactory    = new NoteImageFactory(staffY);
  }

  public ClefImage buildClef() {
    ClefImage c =  new ClefImage(currentX, staffY-20);
    currentX += CLEF_SPACING;
    return c;
  }

  public TimeSignatureImage buildTimeSignature(int beatsPerMeasure, int whichGetsBeat) {
    TimeSignatureImage t = new TimeSignatureImage(
            new TimeSignature(beatsPerMeasure, whichGetsBeat),
            currentX,
            staffY);
    currentX += TIME_SIGNATURE_SPACING;
    return t;
  }

  public NoteImage buildNote(MusicNote note) {
    NoteImage n = noteFactory.buildImage(note, currentX);
    currentX += n.getSpacing();
    return n;
  }

  public ChordImage buildChord(MusicNote... notes) {
    boolean up = NoteStem.shouldStemGoUp(notes);
    NoteImage[] images = new NoteImage[notes.length];
    for (int i = 0; i < notes.length; i++)
      if (up) images[i] = noteFactory.buildUpImage(notes[i], currentX);
      else    images[i] = noteFactory.buildDownImage(notes[i], currentX);

    ChordImage c = new ChordImage(images);
    currentX += c.getSpacing();
    return c;
  }

  public MeasureLine buildMeasureLine() {
    MeasureLine l = new MeasureLine(currentX, staffY, 4* Staff.LINE_GAP);
    currentX += MEASURE_LINE_SPACING;
    return l;
  }

  /**
   * Staff lines should be added to a staff AFTER everything else so that they
   * appear drawn over them.
   */
  public StaffLines buildStaffLines(int width) {
    return new StaffLines(originalX, staffY, width);
  }
}
