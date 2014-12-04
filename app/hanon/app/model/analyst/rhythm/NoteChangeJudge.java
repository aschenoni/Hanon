package hanon.app.model.analyst.rhythm;

import hanon.app.model.music.MusicNote;
import hanon.app.model.music.NoteValue;
import hanon.app.model.util.ThreadedObserverObservable;

/**
 * Listens in on the incoming sound and determines when a note change occurs.
 */
public class NoteChangeJudge extends ThreadedObserverObservable<MusicNote, Integer> {

  private final Timer timer = new Timer();
  private MusicNote lastNote = null;

  @Override
  public void consume(MusicNote musicNote) {
    if (noteChanged(musicNote)) {
      informAll(timer.getTime());
      timer.reset();
    }
    if (musicNote.getFrequency() > 0)
      lastNote = musicNote;
  }

  private boolean noteChanged(MusicNote musicNote) {
    if (musicNote.getFrequency() < 0)
      return false;
    else if (lastNote == null)
      return true;
    else if (compareFreqs(musicNote) > (NoteValue.FREQ_CONST))
      return true;
    return false;
  }

  private float compareFreqs(MusicNote musicNote) {
    return Float.max(musicNote.getFrequency() / lastNote.getFrequency(),
                     lastNote.getFrequency() / musicNote.getFrequency());
  }

  private class Timer {
    long startTime = System.nanoTime();

    void reset() {
      startTime = System.nanoTime();
    }

    int getTime() {
      return (int) ((System.nanoTime() - startTime) / 1000000);
    }
  }
}
