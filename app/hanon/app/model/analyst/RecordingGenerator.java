package hanon.app.model.analyst;

import hanon.app.model.recorder.DataRecording;

public class RecordingGenerator extends StoppableTool<DataRecording> {
  private DataRecording recording;

  private static RecordingGenerator instance = new RecordingGenerator();

  public static RecordingGenerator getInstance() {
    return instance;
  }

  private RecordingGenerator() {
  }

  private synchronized void setRecording(DataRecording recording) {
    this.recording = recording;
  }

  public synchronized DataRecording getRecording() {
    return recording;
  }

  @Override
  protected void runLoop() {
    setRecording(TimedRecorder.getMicInstance().record());
    try {
      Thread.sleep(50);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}
