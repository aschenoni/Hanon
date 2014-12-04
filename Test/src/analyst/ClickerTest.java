package analyst;

import hanon.app.model.analyst.rhythm.RhythmMachine;
//import hanon.app.model.analyst.rhythm.RhythmObservers;
import hanon.app.musicpiece.TwinkleTwinkleLittleStar;

class ClickerTest {

  public static void main(String[] args) {
    RhythmMachine machine = RhythmMachine.fromElements(TwinkleTwinkleLittleStar.elements, 140);
    //machine.register(RhythmObservers.clicker);
    Thread th = new Thread(machine);
    th.setDaemon(true);
    th.start();
  }
}
