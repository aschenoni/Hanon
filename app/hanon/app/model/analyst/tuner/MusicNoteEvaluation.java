package hanon.app.model.analyst.tuner;

import hanon.app.model.music.MusicNote;

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
}
