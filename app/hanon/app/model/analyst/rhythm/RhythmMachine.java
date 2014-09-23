package hanon.app.model.analyst.rhythm;

import hanon.app.model.music.NoteLength;

import java.util.ArrayList;
import java.util.List;

public class RhythmMachine implements Runnable {
  private final List<RhythmObserver> observers = new ArrayList<RhythmObserver>();
  private volatile boolean running = false;

  private final List<NoteLength> rhythm;
  private final NoteLength lengthWithBeat;
  private final int bpm;

  public RhythmMachine(List<NoteLength> rhythm, int bpm, NoteLength lengthWithBeat) {
    this.rhythm = rhythm;
    this.bpm = bpm;
    this.lengthWithBeat = lengthWithBeat;
  }

  public RhythmMachine(List<NoteLength> rhythm, int bpm) {
    this(rhythm, bpm, NoteLength.QUARTER);
  }

  public void register(RhythmObserver o) {
    observers.add(o);
  }

  @Override
  public void run() {
    running = true;
    while (running) {
      for (NoteLength n : rhythm) {
        waitForLength(n);
        informAll();
      }
    }
  }

  private void waitForLength(NoteLength n) {

    n.lengthRelativeTo256th();
  }

  private void informAll() {
    for (RhythmObserver o : observers)
      o.inform();
  }
}
