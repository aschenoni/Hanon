package hanon.app.model.analyst.rhythm;

import hanon.app.model.analyst.StoppableTool;
import hanon.app.model.music.*;

import java.util.List;

public class RhythmMachine extends StoppableTool<EvaluableElement> {
  private final List<StaffElement> elements;
  private final NoteLength lengthWithBeat;
  private final int bpm;

  private int crescendoNoteCount = 0;

  public static RhythmMachine fromElements(List<StaffElement> elements, int bpm) {
    return new RhythmMachine(elements, bpm);
  }

  private RhythmMachine(List<StaffElement> elements, int bpm, NoteLength lengthWithBeat) {
    this.elements = elements;
    this.bpm = bpm;
    this.lengthWithBeat = lengthWithBeat;
  }

  private RhythmMachine(List<StaffElement> elements, int bpm) {
    this(elements, bpm, NoteLength.QUARTER);
  }

  @Override
  protected void runLoop() {
    for (StaffElement e : elements) {
      if (isStopped()) break;
      else if (e.getType() == StaffElementType.NOTE) {
        EvaluableElement n = (EvaluableElement)e;

        if (crescendoNoteCount > 0) {
          n.setInCrescendo();
          crescendoNoteCount--;
        }

        informAll(n);
        waitForLength(n.getLength());
      } else if (e.getType() == StaffElementType.CRESCENDO) {
        Crescendo c = (Crescendo)e;
        crescendoNoteCount = c.getNumNotes();
      }
    }
    informAll(null); // done
    stop();
  }

  private void waitForLength(NoteLength n) {
    float bps = bpm / 60;
    float spb = 1 / bps;
    float mspb = spb * 1000;
    float time = (mspb * n.lengthRelativeTo256th()) / lengthWithBeat.lengthRelativeTo256th();
    safeSleep((int) time);
  }

  private void safeSleep(int time1) {
    try {
      Thread.sleep(time1);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}
