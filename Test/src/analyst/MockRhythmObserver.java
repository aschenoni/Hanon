package analyst;

import hanon.app.model.analyst.rhythm.RhythmMachine;
import hanon.app.model.analyst.rhythm.RhythmObserver;
import hanon.app.model.music.NoteLength;

import java.util.ArrayList;
import java.util.List;

public class MockRhythmObserver implements RhythmObserver {
  @Override
  public void inform() {
    System.out.println("Beat!");
  }

  public static void main(String[] args) {
    List<NoteLength> lengths = new ArrayList<NoteLength>();
    lengths.add(NoteLength.QUARTER);
    lengths.add(NoteLength.HALF);
    lengths.add(NoteLength.WHOLE);
    lengths.add(NoteLength.HALF);

    RhythmMachine machine = new RhythmMachine(lengths, 140);
    machine.register(new MockRhythmObserver());
    machine.run();
  }
}
