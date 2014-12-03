package hanon.app.model.analyst;

import hanon.app.model.recorder.DataRecording;
import hanon.app.model.recorder.Microphone;
import hanon.app.model.recorder.SoundDevice;

public class TimedRecorder {
  private final int timeBetweenReadings;
  private final SoundDevice device;

  private static TimedRecorder micInstance = new TimedRecorder(50, Microphone.getInstance());

  public static TimedRecorder getMicInstance() {
    return micInstance;
  }

  public TimedRecorder(int timeBetweenReadings, SoundDevice device) {
    this.timeBetweenReadings = timeBetweenReadings;
    this.device = device;
  }

  public DataRecording record() {
    DataRecording sound = new DataRecording();
    recordOverSound(sound);
    return sound;
  }

  private void recordOverSound(DataRecording sound) {
    device.startRecording(sound);
    safeSleep(timeBetweenReadings);
    device.stopRecording();
  }

  private void safeSleep(int millis) {
    try {
      Thread.sleep(millis);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}
