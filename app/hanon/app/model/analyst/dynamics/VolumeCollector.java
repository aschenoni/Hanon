package hanon.app.model.analyst.dynamics;

import hanon.app.model.analyst.Collector;
import hanon.app.model.analyst.TimedRecorder;
import hanon.app.model.recorder.Microphone;

public class VolumeCollector extends Collector<Double> {
  private final TimedRecorder recorder;


  public VolumeCollector() {
    recorder = new TimedRecorder(50, Microphone.getInstance());
  }

  @Override
  public void run() {
    while (true) {
      addToCollection(recorder.record().getVolume());
      informAll(getMostRecent());
    }
  }
}
