package recorder;

import hanon.app.model.recorder.Recording;

import javax.sound.sampled.TargetDataLine;

public class MockRecording implements Recording {
  @Override
  public void record(TargetDataLine targetDataLine) {

  }

  @Override
  public void setVolume(double volume) {

  }

  @Override
  public double getVolume() {
    return 0;
  }
}
