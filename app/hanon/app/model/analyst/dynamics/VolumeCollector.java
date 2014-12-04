package hanon.app.model.analyst.dynamics;

import hanon.app.model.analyst.Collector;
import hanon.app.model.analyst.RecordingGenerator;
import hanon.app.model.analyst.TimedRecorder;
import hanon.app.model.recorder.DataRecording;
import hanon.app.model.recorder.Microphone;

public class VolumeCollector extends Collector<Double> {
  private final RecordingGenerator generator = RecordingGenerator.getInstance();

  @Override
  protected void runLoop() {
    DataRecording rec = generator.getRecording();
    if (rec != null) {
      addToCollection(rec.getVolume());
      informAll(getMostRecent());
      try {
        Thread.sleep(50);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }
}
