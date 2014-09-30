package analyst;

import hanon.app.model.analyst.rhythm.Clicker;
import hanon.app.model.analyst.rhythm.RhythmMachine;
import hanon.app.model.music.NoteLength;
import hanon.app.musicpiece.TwinkleTwinkleLittleStar;

import java.util.ArrayList;
import java.util.List;

class ClickerTest {

  public static void main(String[] args) {
    RhythmMachine machine = RhythmMachine.fromElements(TwinkleTwinkleLittleStar.elements, 140);
    Clicker c = new Clicker();
    c.run();
    machine.register(c);
    machine.run();
  }
}
