package hanon.app.controller.player.staff;

import hanon.app.controller.music.Clef;
import hanon.app.controller.music.MusicNote;
import hanon.app.controller.player.component.BodyHole;
import hanon.app.controller.player.component.DownNoteStem;
import hanon.app.controller.player.component.NoteBody;
import hanon.app.controller.player.component.NoteStem;
import hanon.app.controller.player.component.UpNoteStem;
import hanon.app.controller.player.component.*;

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
    NoteStem noteStem   = buildStem(x, y, d);
    NoteFlag flag       = NoteFlag.fromPosition(x, y, staffY);
    BodyHole normalHole = new BodyHole(x, y, -20);
    BodyHole wholeHole  = new BodyHole(x, y, 80);
    LedgerLine ledger   = new LedgerLine(x, y, note.getStaffPosition(clef));

    switch (note.getLength()) {
      case EIGHTH:  return new NoteImage(normalBody, noteStem, flag, ledger);
      case QUARTER: return new NoteImage(normalBody, noteStem, ledger);
      case HALF:    return new NoteImage(normalBody, normalHole, noteStem, ledger);
      case WHOLE:   return new NoteImage(wholeBody, wholeHole, ledger);
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