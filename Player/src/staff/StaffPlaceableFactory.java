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
  private final NoteImageFactory noteFactory;
  private final StaffSpacer spacer;
  private final int y;
  private final int x;

  public StaffPlaceableFactory(int x, int y) {
    this.x = x;
    this.y = y;
    noteFactory = new NoteImageFactory(y);
    spacer = new StaffSpacer(x);
  }

  public ClefImage buildClef() {
    ClefImage c =  new ClefImage(spacer.getX(), y -20);
    spacer.spaceForClef();
    return c;
  }

  public TimeSignatureImage buildTimeSignature(int beatsPerMeasure, int whichGetsBeat) {
    TimeSignatureImage t = new TimeSignatureImage(
            new TimeSignature(beatsPerMeasure, whichGetsBeat),
            spacer.getX(),
            y);
    spacer.spaceForTimeSignature();
    return t;
  }

  public MeasureLine buildMeasureLine() {
    MeasureLine l = new MeasureLine(spacer.getX(), y, 4* Staff.LINE_GAP);
    spacer.spaceForMeasureLine();
    return l;
  }

  public NoteImage buildNote(MusicNote note) {
    NoteImage n = noteFactory.buildImage(note, spacer.getX());
    spacer.spaceForNote(note.getLength());
    return n;
  }

  public ChordImage buildChord(MusicNote... notes) {
    NoteImage[] images = getNoteImages(notes);
    NoteLength[] lengths = getNoteLengths(notes);

    ChordImage c = new ChordImage(images);
    spacer.spaceForChord(lengths);
    return c;
  }

  private NoteImage[] getNoteImages(MusicNote[] notes) {
    boolean up = NoteStem.shouldStemGoUp(notes);
    NoteImage[] images = new NoteImage[notes.length];
    for (int i = 0; i < notes.length; i++)
      if (up) images[i] = noteFactory.buildUpImage(notes[i], spacer.getX());
      else    images[i] = noteFactory.buildDownImage(notes[i], spacer.getX());
    return images;
  }

  private NoteLength[] getNoteLengths(MusicNote[] notes) {
    NoteLength lengths[] = new NoteLength[notes.length];
    for (int i = 0; i < notes.length; i++)
      lengths[i] = notes[i].getLength();
    return lengths;
  }

  /**
   * Staff lines should be added to a staff AFTER everything else so that they
   * appear drawn over them.
   */
  public StaffLines buildStaffLines(int width) {
    return new StaffLines(x, y, width);
  }
}
