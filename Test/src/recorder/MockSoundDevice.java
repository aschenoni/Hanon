package recorder;

import hanon.app.model.recorder.Recording;
import hanon.app.model.recorder.SoundDevice;

public class MockSoundDevice implements SoundDevice {
  private final Recording rec;

  public MockSoundDevice(Recording rec) {
    this.rec = rec;
  }

  @Override
  public Recording getSound() {
    return rec;
  }

  @Override
  public void startRecording(Recording sound) {

  }

  @Override
  public Recording stopRecording() {
    return null;
  }
}
