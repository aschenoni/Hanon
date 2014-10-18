package hanon.app.model.analyst.dynamics;

import hanon.app.model.analyst.StoppableTool;
import hanon.app.model.analyst.TimedRecorder;
import hanon.app.model.recorder.Microphone;

public class SoundLevelMeter extends StoppableTool<Double> {

  public static void main(String[] args) {
    SoundLevelMeter meter = new SoundLevelMeter(50);
    meter.register(System.out::println);
    meter.run();
  }

  private final TimedRecorder recorder;

  public SoundLevelMeter(int timeBetweenRecordings) {
    recorder = new TimedRecorder(timeBetweenRecordings, new Microphone());
  }

  @Override
  protected void runLoop() {
    recorder.record();
    informAll(recorder.getVolume());
  }
}

