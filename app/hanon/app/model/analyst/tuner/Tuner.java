package hanon.app.model.analyst.tuner;

import hanon.app.model.analyst.StoppableTool;
import hanon.app.model.analyst.TimedRecorder;
import hanon.app.model.music.MusicNote;
import hanon.app.model.recorder.Microphone;

public class Tuner extends StoppableTool<TunerInfo> {
  private final TimedRecorder recorder;

  public Tuner(int timeBetweenReadings) {
    recorder = new TimedRecorder(timeBetweenReadings, new Microphone());
  }

  @Override
  protected void runLoop() {
    MusicNote note = MusicNote.fromSoundArr(recorder.record().getFloatArray());
    informAll(new TunerInfo(
            note.getFrequency(),
            note.getName(),
            note.getOctave(),
            note.getFrequencyOffset()));
  }
}
