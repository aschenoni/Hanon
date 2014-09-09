package notes;

import components.BodyHole;
import components.NoteBody;
import components.NoteStem;
import music.NoteLength;

public class NoteImageFactory {
  private final int staffY;

  public NoteImageFactory(int staffY) {
    this.staffY = staffY;
  }

  public NoteImage buildImage(NoteLength length, int x, int y) {
    NoteBody noteBody = buildNoteBody(x, y);
    NoteStem noteStem = buildStem(x, y);

    switch (length) {
      case quarter: return new NoteImage(noteBody, noteStem);
      case half:    return new NoteImage(noteBody, buildHole(x, y), noteStem);
      default:      throw new NoSuchNoteLengthException();
    }
  }

  private BodyHole buildHole(int x, int y) {
    return new BodyHole(x, y);
  }

  private NoteStem buildStem(int x, int y) {
    return NoteStem.fromPosition(x, y, 1, staffY);
  }

  private NoteBody buildNoteBody(int x, int y) {
    return new NoteBody(x, y);
  }
}

class NoSuchNoteLengthException extends RuntimeException { }