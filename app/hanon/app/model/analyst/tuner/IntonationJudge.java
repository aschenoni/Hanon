package hanon.app.model.analyst.tuner;

import hanon.app.model.analyst.rhythm.NoteCollector;
import hanon.app.model.music.EvaluableElement;
import hanon.app.model.music.MusicNote;
import hanon.app.model.util.ThreadedObserverObservable;

import static hanon.app.model.music.MusicNote.average;

public class IntonationJudge extends ThreadedObserverObservable<EvaluableElement, EvaluableElement> {
  private final NoteCollector collector = new NoteCollector();

  public IntonationJudge() {
    collector.start();
  }

  @Override
  public void consume(EvaluableElement element) {
    MusicNote average = average(collector.takeCollection());
    informAll(average);
  }
}
