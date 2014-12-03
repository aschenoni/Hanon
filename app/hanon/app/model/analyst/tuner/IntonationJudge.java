package hanon.app.model.analyst.tuner;

import hanon.app.model.analyst.rhythm.NoteCollector;
import hanon.app.model.music.EvaluableElement;
import hanon.app.model.music.MusicNote;
import hanon.app.model.music.NoteLength;
import hanon.app.model.music.NoteValue;
import hanon.app.model.util.ThreadedObserverObservable;

import static hanon.app.model.music.MusicNote.average;

public class IntonationJudge extends ThreadedObserverObservable<EvaluableElement, MusicNoteEvaluation> {
  private final NoteCollector collector = new NoteCollector();
  private MusicNote note = new MusicNote(new NoteValue(440f), NoteLength.QUARTER);
  private boolean isFirst = true;

  public IntonationJudge() {
    collector.start();
  }

  @Override
  public void consume(EvaluableElement element) {
    if (!isFirst) {
      MusicNote average = average(collector.takeCollection());
      informAll(new MusicNoteEvaluation(average, note));
    } else {
      isFirst = false;
    }
    note = (MusicNote)element;
  }
}