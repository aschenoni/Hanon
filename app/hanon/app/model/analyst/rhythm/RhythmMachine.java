package hanon.app.model.analyst.rhythm;

import hanon.app.model.analyst.StoppableTool;
import hanon.app.model.music.*;

import java.util.ArrayList;
import java.util.List;

public class RhythmMachine extends StoppableTool<EvaluableElement> {
  private final List<EvaluableElement> rhythm;
  private final NoteLength lengthWithBeat;
  private final int bpm;

  public static RhythmMachine fromElements(List<StaffElement> elements, int bpm) {
    List<EvaluableElement> lengths = new ArrayList<>();
    for (StaffElement e : elements)
      if (e.getType() == StaffElementType.NOTE)
        lengths.add((EvaluableElement) e);
    return new RhythmMachine(lengths, bpm);
  }

  private RhythmMachine(List<EvaluableElement> rhythm, int bpm, NoteLength lengthWithBeat) {
    this.rhythm = rhythm;
    this.bpm = bpm;
    this.lengthWithBeat = lengthWithBeat;
  }

  private RhythmMachine(List<EvaluableElement> rhythm, int bpm) {
    this(rhythm, bpm, NoteLength.QUARTER);
  }

  @Override
  protected void runLoop() {
    for (EvaluableElement n : rhythm) {
      if (isStopped()) break;
      informAll(n);
      waitForLength(n.getLength());
    }
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
