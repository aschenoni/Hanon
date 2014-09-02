package recorder;

import javax.sound.sampled.AudioFileFormat;

public class MockSoundDevice implements SoundDevice {
  private Recording rec;

  public MockSoundDevice(Recording rec) {
    this.rec = rec;
  }

  @Override
  public Recording getSound() {
    return rec;
  }
}
