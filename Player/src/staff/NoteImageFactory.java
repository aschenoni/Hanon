package staff;

import component.*;
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

  private enum StemDirection {
    UP,
    DOWN,
    NORMAL
  }

  public NoteImage buildImage(MusicNote note, int x) {
    return doBuildImage(note, x, StemDirection.NORMAL);
  }

  public NoteImage buildUpImage(MusicNote note, int x) {
    return doBuildImage(note, x, StemDirection.UP);
  }


  public NoteImage buildDownImage(MusicNote note, int x) {
    return doBuildImage(note, x, StemDirection.DOWN);
  }

  private NoteImage doBuildImage(MusicNote note, int x, StemDirection d) {
    int y = (note.getStaffPosition()-1)*5 + staffY + 1;
    NoteBody normalBody = new NoteBody(x, y, -20);
    NoteBody wholeBody  = new NoteBody(x, y, 0);
    NoteStem noteStem   = buildStem(x, y, d);
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

  private NoteStem buildStem(int x, int y, StemDirection d) {
    switch (d) {
      case UP:   return new UpNoteStem(x, y);
      case DOWN: return new DownNoteStem(x, y);
      default:   return NoteStem.fromPosition(x, y, staffY);
    }
  }

  private class NoSuchNoteLengthException extends RuntimeException {}
}