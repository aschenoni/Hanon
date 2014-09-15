package hanon.app.controller.player.staff;

import hanon.app.controller.music.*;
import hanon.app.controller.music.Chord;
import hanon.app.controller.music.MusicNote;
import hanon.app.controller.music.NoteLength;
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
public class StaffPlaceableFactory {
  public static final int LINE_GAP = 10;

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

  public List<StaffPlaceable> buildPlaceables(List<StaffElement> elements) {
    List<StaffPlaceable> placeables = new ArrayList<StaffPlaceable>();
    for (StaffElement e : elements)
      placeables.add(buildPlaceable(e));
    return placeables;
  }

  private StaffPlaceable buildPlaceable(StaffElement element) {
    switch (element.getType()) {
      case NOTE:           return buildNote((MusicNote) element);
      case CHORD:          return buildChord(((Chord)element).getNotes());
      case TIME_SIGNATURE: return buildTimeSignature((TimeSignature)element);
      case CLEF:           return buildClef();
      case MEASURE_LINE:   return buildMeasureLine();
      case STAFF_LINES:    return buildStaffLines(800);
      default:             throw new NoSuchStaffElementException();
    }
  }

  private ClefImage buildClef() {
    ClefImage c = new ClefImage(spacer.getX(), y -20);
    spacer.spaceForClef();
    return c;
  }

  private TimeSignatureImage buildTimeSignature(TimeSignature sig) {
    TimeSignatureImage t = new TimeSignatureImage(
            sig,
            spacer.getX(),
            y);
    spacer.spaceForTimeSignature();
    return t;
  }

  private MeasureLine buildMeasureLine() {
    MeasureLine l = new MeasureLine(spacer.getX(), y, 4* LINE_GAP);
    spacer.spaceForMeasureLine();
    return l;
  }

  private NoteImage buildNote(MusicNote note) {
    NoteImage n = noteFactory.buildImage(note, spacer.getX());
    spacer.spaceForNote(note.getLength());
    return n;
  }

  private ChordImage buildChord(MusicNote... notes) {
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
  private StaffLines buildStaffLines(int width) {
    return new StaffLines(x, y, width);
  }

  private class NoSuchStaffElementException extends RuntimeException {
  }
}
