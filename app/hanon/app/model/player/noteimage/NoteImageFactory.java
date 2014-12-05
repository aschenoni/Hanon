package hanon.app.model.player.noteimage;

import hanon.app.model.music.Clef;
import hanon.app.model.music.MusicNote;

/**
 * The note image factory is responsible for putting together the correct
 * collection of note component into a note image. It makes this decision by
 * looking at the length of the requested note.
 *
 * For instance, a quarter note has a body and a stem, while a HALF note
 * has a body, a stem, and a hole.
 */
public class NoteImageFactory {
  private final int staffY;
  private final Clef clef;

  public NoteImageFactory(int staffY, Clef clef) {
    this.staffY = staffY;
    this.clef = clef;
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
    int y = (note.getStaffPosition(clef)-1)*5 + staffY + 1;
    NoteBody normalBody = new NoteBody(x, y, -20);
    NoteBody wholeBody  = new NoteBody(x, y, 0);
    normalBody.setMusicNote(note);
    wholeBody.setMusicNote(note);
    NoteStem noteStem   = buildStem(x, y, d);
    NoteFlag flag       = NoteFlag.fromPosition(x, y, staffY);
    BodyHole normalHole = new BodyHole(x, y, -20);
    BodyHole wholeHole  = new BodyHole(x, y, 80);
    LedgerLine ledger   = new LedgerLine(x, y, note.getStaffPosition(clef));

    boolean up = goesUp(d, note);
    switch (note.getLength()) {
      case EIGHTH:  return new NoteImage(up, x, y, normalBody, noteStem, flag, ledger);
      case QUARTER: return new NoteImage(up, x, y, normalBody, noteStem, ledger);
      case HALF:    return new NoteImage(up, x, y, normalBody, normalHole, noteStem, ledger);
      case WHOLE:   return new NoteImage(up, x, y, wholeBody, wholeHole, ledger);
      default:      throw new NoSuchNoteLengthException();
        /*
        *  TODO There is no reason this exception should be needed. We should
        *  TODO have type safety since NoteLength is an enum.
        */
    }
  }

  boolean goesUp(StemDirection d, MusicNote... notes) {
    switch (d) {
      case UP: return true;
      case DOWN: return false;
      default: return NoteStem.shouldStemGoUp(clef, notes);
    }
  }

  private NoteStem buildStem(int x, int y, StemDirection d) {
    switch (d) {
      case UP:   return new NoteStem(true, x, y);
      case DOWN: return new NoteStem(false, x, y);
      default:   return NoteStem.fromPosition(x, y, staffY);
    }
  }

  private class NoSuchNoteLengthException extends RuntimeException {}
}