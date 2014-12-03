package hanon.app.model.analyst.rhythm;

import hanon.app.model.analyst.Collector;
import hanon.app.model.analyst.Observable;
import hanon.app.model.analyst.Observer;
import hanon.app.model.analyst.TimedRecorder;
import hanon.app.model.music.MusicNote;
import hanon.app.model.recorder.DataRecording;
import hanon.app.model.recorder.Microphone;
import hanon.app.model.util.FunctionalList;

import java.util.ArrayList;
import java.util.List;

public class NoteCollector extends Collector<MusicNote> {
  private final TimedRecorder recorder;

  public NoteCollector() {
    recorder = TimedRecorder.getMicInstance();
  }

  @Override
  public void run() {
    while (true) {
      DataRecording rec = recorder.record();
      addToCollection(MusicNote.fromSoundArr(rec.getFloatArray()));
      informAll(getMostRecent());
    }
  }
}
