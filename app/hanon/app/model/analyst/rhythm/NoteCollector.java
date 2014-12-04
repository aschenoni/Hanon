package hanon.app.model.analyst.rhythm;

import hanon.app.model.analyst.*;
import hanon.app.model.music.MusicNote;
import hanon.app.model.recorder.DataRecording;
import hanon.app.model.recorder.Microphone;
import hanon.app.model.util.FunctionalList;

import java.util.ArrayList;
import java.util.List;

public class NoteCollector extends Collector<MusicNote> {
  private final RecordingGenerator generator = RecordingGenerator.getInstance();

  @Override
  protected void runLoop() {
    DataRecording rec = generator.getRecording();
    if (rec != null) {
      addToCollection(MusicNote.fromSoundArr(rec.getFloatArray()));
      informAll(getMostRecent());
      try {
        Thread.sleep(50);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }
}
