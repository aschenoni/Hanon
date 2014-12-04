package hanon.app.model.analyst.dynamics;

import hanon.app.model.music.EvaluableElement;
import hanon.app.model.util.FunctionalList;
import hanon.app.model.util.ThreadedObserverObservable;

public class DynamicsJudge extends ThreadedObserverObservable<EvaluableElement, SoundLevels> {
  private final VolumeCollector collector = new VolumeCollector();
  private boolean isRecording = false;
  private boolean inCrescendo = false;
  private boolean inDecrescendo = false;

  @Override
  public void stop() {
    super.stop();
    collector.stop();
  }

  @Override
  public void consume(EvaluableElement element) {
    if (element != null) {
      if (isRecording && inCrescendo && element.isInDecrescendo()) {
        FunctionalList<Double> items = collector.takeCollection();
        SoundLevels levels = new SoundLevels(items, 10);
        informAll(levels);
        inCrescendo = false;
        inDecrescendo = true;
      }
      else if (isRecording && inDecrescendo && element.isInCrescendo()) {
        FunctionalList<Double> items = collector.takeCollection();
        SoundLevels levels = new SoundLevels(items, 10);
        informAll(levels);
        inCrescendo = true;
        inDecrescendo = false;
      }
      else if (isRecording && !element.isInCrescendo() && !element.isInDecrescendo()) {
        FunctionalList<Double> items = collector.takeCollection();
        SoundLevels levels = new SoundLevels(items, 10);
        informAll(levels);
        isRecording = false;
        inCrescendo = false;
        inDecrescendo = false;
      }
      else if (!isRecording && element.isInCrescendo()) {
        collector.takeCollection();
        isRecording = true;
        inCrescendo = true;
      }
      else if (!isRecording && element.isInDecrescendo()) {
        collector.takeCollection();
        isRecording = true;
        inDecrescendo = true;
      }
    } else {
      stop();
    }
  }
}
