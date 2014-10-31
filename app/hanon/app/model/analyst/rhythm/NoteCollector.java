package hanon.app.model.analyst.rhythm;

import hanon.app.model.analyst.Observable;
import hanon.app.model.analyst.Observer;
import hanon.app.model.analyst.TimedRecorder;
import hanon.app.model.music.MusicNote;
import hanon.app.model.recorder.DataRecording;
import hanon.app.model.recorder.Microphone;
import hanon.app.model.util.FunctionalList;

import java.util.ArrayList;
import java.util.List;

public class NoteCollector extends Thread implements Observable<MusicNote> {
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
    return copy.reverse();
  }

  public synchronized MusicNote getMostRecent() {
    return notes.head();
  }

  @Override
  public void run() {
    while (true) {
      DataRecording rec = recorder.record();
      addNote(MusicNote.fromSoundArr(rec.getFloatArray()));
      informAll(getMostRecent());
    }
  }

  private final List<Observer<MusicNote>> observers = new ArrayList<>();

  @Override
  public void register(Observer<MusicNote> observer) {
    observers.add(observer);
  }

  @Override
  public void informAll(MusicNote info) {
    for (Observer<MusicNote> obs: observers)
      obs.inform(info);
  }
}
