package hanon.app.model.analyst.dynamics;

import hanon.app.model.music.EvaluableElement;
import hanon.app.model.util.FunctionalList;
import hanon.app.model.util.ThreadedObserverObservable;

public class DynamicsJudge extends ThreadedObserverObservable<EvaluableElement, SoundLevels> {
  private final VolumeCollector collector = new VolumeCollector();
  private boolean isRecording = false;

  public DynamicsJudge() {
    collector.start();
  }

  @Override
  public void consume(EvaluableElement element) {
    if (element != null) {
      if (isRecording && !element.isInCrescendo()) {
        FunctionalList<Double> items = collector.takeCollection();
        SoundLevels levels = new SoundLevels(items, 10);
        informAll(levels);
        isRecording = false;
      } else if (!isRecording && element.isInCrescendo()) {
        collector.takeCollection();
        isRecording = true;
      }
    }
  }
}
