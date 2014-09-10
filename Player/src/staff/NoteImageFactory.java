package staff;

import component.BodyHole;
import component.NoteBody;
import component.NoteStem;
import music.MusicNote;
import music.NoteLength;

/**
 * The note image factory is responsible for putting together the correct
 * collection of note component into a note image. It makes this decision by
 * looking at the length of the requested note.
 *
 * For instance, a quarter note has a body and a stem, while a half note
 * has a body, a stem, and a hole.
 */
public class NoteImageFactory {
  private final int staffY;

  public NoteImageFactory(int staffY) {
    this.staffY = staffY;
  }

  public NoteImage buildImage(MusicNote note, int x) {
    int y = note.getStaffPosition()*5 + staffY + 1;
    NoteBody normalBody = new NoteBody(x, y, -20);
    NoteBody wholeBody  = new NoteBody(x, y, 0);
    NoteStem noteStem   = NoteStem.fromPosition(x, y, staffY);
    BodyHole normalHole = new BodyHole(x, y, -20);
    BodyHole wholeHole  = new BodyHole(x, y, 80);

    switch (note.getLength()) {
      case quarter: return new NoteImage(NoteLength.quarter, normalBody, noteStem);
      case half:    return new NoteImage(NoteLength.half, normalBody, normalHole, noteStem);
      case whole:   return new NoteImage(NoteLength.whole, wholeBody, wholeHole);
      default:      throw new NoSuchNoteLengthException();
        /*
        *  TODO There is no reason this exception should be needed. We should
        *  TODO have type safety since NoteLength is an enum.
        */
    }
  }

  private class NoSuchNoteLengthException extends RuntimeException {}
}