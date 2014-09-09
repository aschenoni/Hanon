package notes;

import components.BodyHole;
import components.NoteBody;
import components.NoteStem;
import music.NoteLength;

/**
 * The note image factory is responsible for putting together the correct
 * collection of note components into a note image. It makes this decision by
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

  public NoteImage buildImage(NoteLength length, int x, int y) {
    NoteBody noteBody = new NoteBody(x, y);
    NoteStem noteStem = NoteStem.fromPosition(x, y, staffY);
    BodyHole bodyHole = new BodyHole(x, y);

    switch (length) {
      case quarter: return new NoteImage(noteBody, noteStem);
      case half:    return new NoteImage(noteBody, bodyHole, noteStem);
      default:      throw new NoSuchNoteLengthException();
        /*
        *  TODO There is no reason this exception should be needed. We should
        *  TODO have type safety since NoteLength is an enum.
        */
    }
  }

  private class NoSuchNoteLengthException extends RuntimeException {}
}