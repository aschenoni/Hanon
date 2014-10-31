package hanon.app.model.analyst.rhythm;

import hanon.app.model.analyst.TimedRecorder;
import hanon.app.model.music.MusicNote;
import hanon.app.model.recorder.DataRecording;
import hanon.app.model.recorder.Microphone;
import hanon.app.model.util.FunctionalList;

public class NoteCollector extends Thread {
  private FunctionalList<MusicNote> notes;
  private final TimedRecorder recorder;

  public NoteCollector() {
    this.setDaemon(true);
    notes = FunctionalList.empty();
    recorder = new TimedRecorder(50, new Microphone());
  }

  private synchronized void addNote(MusicNote note) {
    notes = notes.prepend(note);
  }

  /**
   * Gets the collection of music notes and resets the one in the collector.
   */
  public synchronized FunctionalList<MusicNote> takeCollection() {
    FunctionalList<MusicNote> copy = notes;
    notes = FunctionalList.empty();
    return copy;
  }

  @Override
  public void run() {
    while (true) {
      DataRecording rec = recorder.record();
      addNote(MusicNote.fromSoundArr(rec.getFloatArray()));
    }
  }
}
