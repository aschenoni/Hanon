package hanon.app.model.recorder;

public interface SoundDevice {
  Recording getSound();

  void startRecording(Recording sound);

  Recording stopRecording();

  double getVolume();
}
