package recorder;

public class MockSoundDevice implements SoundDevice {
  private final Recording rec;

  public MockSoundDevice(Recording rec) {
    this.rec = rec;
  }

  @Override
  public Recording getSound() {
    return rec;
  }
}
