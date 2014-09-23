package hanon.app.model.analyst;

import hanon.app.model.music.MusicNote;
import hanon.app.model.recorder.DataRecording;
import hanon.app.model.recorder.Microphone;

import java.util.ArrayList;
import java.util.List;

public class Tuner implements Runnable {

  private final List<TunerObserver> observers = new ArrayList<TunerObserver>();
  private final int timeBetweenReadings;
  private volatile boolean isRunning = false;

  public Tuner(int timeBetweenReadings) {
    this.timeBetweenReadings = timeBetweenReadings;
  }

  public void register(TunerObserver observer) {
    observers.add(observer);
  }

  @Override
  public void run() {
    isRunning = true;
    while (isRunning) {
      MusicNote note = getMusicNote();
      informAll(new TunerInfo(
              note.getFrequency(),
              note.getName(),
              note.getOctave(),
              note.getFrequencyOffset()));
    }
  }

  private MusicNote getMusicNote() {
    DataRecording sound = new DataRecording();
    recordOnMicrophone(sound);
    return MusicNote.fromSoundArr(sound.getFloatArray());
  }

  private void recordOnMicrophone(DataRecording sound) {
    Microphone mic = new Microphone(sound);
    mic.startRecord();
    safeSleep(timeBetweenReadings);
    mic.stopRecording();
  }

  private void informAll(TunerInfo info) {
    for (TunerObserver observer:observers) {
      observer.inform(info);
    }
  }

  private void safeSleep(int millis) {
    try {
      Thread.sleep(millis);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  public void stop() {
    isRunning = false;
  }
}
