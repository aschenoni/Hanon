package hanon.app.model.player.staff;

import hanon.app.model.music.*;
import hanon.app.model.player.noteimage.NoteImage;
import hanon.app.model.player.noteimage.NoteImageFactory;
import hanon.app.model.player.noteimage.NoteStem;
import hanon.app.model.player.sheet.Brush;
import hanon.app.model.player.sheet.StaffPlaceable;

import java.util.ArrayList;
import java.util.List;

public class Staff {
  public static final int LINE_GAP = 10;

  private final List<StaffElement> elements;
  private final StaffInfo info;
  private NoteImageFactory noteFactory;

  public Staff(StaffInfo info, List<StaffElement> elements) {
    this.info = info;
    this.elements = elements;
  }

  public List<StaffPlaceable> getPlaceableElements() {
    List<Integer> spacings = new StaffSpacer(info.getWidth(), elements).getAllocatedSpacings();
    List<StaffPlaceable> placeables = new ArrayList<StaffPlaceable>();
    for (int i = 0; i < spacings.size(); i++)
      placeables.add(placeElement(spacings.get(i), elements.get(i)));
    placeables.add(0, new MeasureLine(info.getX(), info.getY(), info.getMeasureLineHeight()));
    placeables.add(0, new StaffLines(info.getX(), info.getY(), info.getWidth()));
    return placeables;
  }

  private StaffPlaceable placeElement(int x, StaffElement element) {
    x += info.getX();
    noteFactory = new NoteImageFactory(info.getY(), info.getClef());
    switch (element.getType()) {
      case NOTE:           return noteFactory.buildImage((MusicNote) element, x);
      case CHORD:          return new ChordImage(getNoteImages(x, ((Chord)element).getNotes()));
      case TIME_SIGNATURE: return new TimeSignatureImage((TimeSignature)element, x, info.getY());
      case CLEF:           return getClef(x);
      case MEASURE_LINE:   return new MeasureLine(x, info.getY(), info.getMeasureLineHeight());
      case STAFF_LINES:    return new StaffLines(info.getX(), info.getX(), info.getWidth());
      default:             throw new NoSuchStaffElementException();
    }
  }

  private StaffPlaceable getClef(int x) {
    if (info.getClef() == Clef.TREBLE)
      return new ClefImage(Clef.TREBLE, x, info.getY());
    else
      return new ClefImage(Clef.BASS, x, info.getY());
  }

  private NoteImage[] getNoteImages(int x, MusicNote[] notes) {
    boolean up = NoteStem.shouldStemGoUp(info.getClef(), notes);
    NoteImage[] images = new NoteImage[notes.length];
    for (int i = 0; i < notes.length; i++)
      if (up) images[i] = noteFactory.buildUpImage(notes[i], x);
      else    images[i] = noteFactory.buildDownImage(notes[i], x);
    return images;
  }

  public void paint(Brush brush) {
    for (StaffPlaceable e : getPlaceableElements()) e.paint(brush);
  }
}
