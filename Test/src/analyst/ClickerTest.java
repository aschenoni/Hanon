package analyst;

import hanon.app.model.analyst.rhythm.Clicker;
import hanon.app.model.analyst.rhythm.RhythmMachine;
import hanon.app.model.music.NoteLength;
import hanon.app.view.TwinkleTwinkleLittleStar;

import java.util.ArrayList;
import java.util.List;

public class ClickerTest {

  public static void main(String[] args) {
    List<NoteLength> lengths = new ArrayList<NoteLength>();
    lengths.add(NoteLength.QUARTER);
    lengths.add(NoteLength.HALF);
    lengths.add(NoteLength.WHOLE);
    lengths.add(NoteLength.HALF);

    RhythmMachine machine = RhythmMachine.fromElements(TwinkleTwinkleLittleStar.elements, 140);
    Clicker c = new Clicker();
    c.run();
    machine.register(c);
    machine.run();
  }
}
