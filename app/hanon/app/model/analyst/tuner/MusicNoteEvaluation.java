package hanon.app.model.analyst.tuner;

import hanon.app.model.music.MusicNote;
import hanon.app.model.music.NoteValue;

public class MusicNoteEvaluation {
  private final MusicNote played;
  private final MusicNote expected;

  public MusicNoteEvaluation(MusicNote played, MusicNote expected) {
    this.played = played;
    this.expected = expected;
  }

  public MusicNote getExpected() {
    return expected;
  }

  public MusicNote getPlayed() {
    return played;
  }

  public boolean isPoor() {
    return compareFrequencies() > NoteValue.FREQ_CONST;
  }

  public boolean isGood() {
    return compareFrequencies() < NoteValue.FREQ_CONST;
  }

  private float compareFrequencies() {
    return Float.max(played.getFrequency() / expected.getFrequency(),
            expected.getFrequency() / played.getFrequency());
  }

  @Override
  public String toString() {
    return "Played: {" + played + "}, Expected:{" + expected + "}";
  }
}
