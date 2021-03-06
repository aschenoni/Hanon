package hanon.app.model.player.staff;

import hanon.app.model.music.*;
import hanon.app.model.player.noteimage.NoteImage;
import hanon.app.model.player.noteimage.NoteImageFactory;
import hanon.app.model.player.noteimage.NoteStem;
import hanon.app.model.player.sheet.StaffPlaceable;
import hanon.app.model.util.FunctionalList;
import hanon.app.model.util.Pair;

import java.util.Stack;

public class StaffPlaceableFactory {
  private final StaffInfo info;
  private final NoteImageFactory noteFactory;
  private final TieRepository tieRepository = new TieRepository();

  public StaffPlaceableFactory(StaffInfo info) {
    this.info = info;
    noteFactory = new NoteImageFactory(info.getY(), info.getClef());
  }

  public StaffPlaceable placeElement(int x, StaffElement element) {
    switch (element.getType()) {
      case NOTE:           NoteImage image = noteFactory.buildImage((MusicNote) element, x);
                           tieRepository.addNote(image);
                           return image;
      case TIE:            return new TieImage(tieRepository.getLastTwoNotes());
      case SLUR:           return new SlurImage(tieRepository.getLastNNotes(((Slur)element).getNumNotes()));
      case CRESCENDO:      return new CrescendoImage(tieRepository.getLastNNotes(((Crescendo)element).getNumNotes()), info.getY());
      case DECRESCENDO:    return new DecrescendoImage(tieRepository.getLastNNotes(((Decrescendo)element).getNumNotes()), info.getY());
      case REST:           return RestImage.fromRest((Rest) element, x, info.getY());
      case CHORD:          return new ChordImage(getNoteImages(x, ((Chord)element).getNotes()));
      case TIME_SIGNATURE: return new TimeSignatureImage((TimeSignature)element, x, info.getY());
      case CLEF:           return getClef(x);
      case MEASURE_LINE:   return new MeasureLine(x, info.getY(), info.getMeasureLineHeight());
      case STAFF_LINES:    return new StaffLines(info.getX(), info.getX(), info.getWidth());
      default:             throw new RuntimeException("No such staff element type");
    }
  }

  private NoteImage[] getNoteImages(int x, MusicNote[] notes) {
    boolean up = NoteStem.shouldStemGoUp(info.getClef(), notes);
    NoteImage[] images = new NoteImage[notes.length];
    for (int i = 0; i < notes.length; i++)
      if (up) images[i] = noteFactory.buildUpImage(notes[i], x);
      else    images[i] = noteFactory.buildDownImage(notes[i], x);
    return images;
  }

  private StaffPlaceable getClef(int x) {
    if (info.getClef() == Clef.TREBLE)
      return new ClefImage(Clef.TREBLE, x, info.getY());
    else
      return new ClefImage(Clef.BASS, x, info.getY());
  }

  class TieRepository {
    private FunctionalList<NoteImage> images = FunctionalList.empty();

    Pair<NoteImage, NoteImage> getLastTwoNotes() {
      FunctionalList<NoteImage> lastTwo = images.take(2);
      return new Pair<>(lastTwo.head(), lastTwo.tail().head());
    }

    FunctionalList<NoteImage> getLastNNotes(int n) {
      return images.take(n);
    }

    void addNote(NoteImage image) {
      images = images.prepend(image);
    }
  }
}
