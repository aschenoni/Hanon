package hanon.app.controller;

import hanon.app.model.analyst.rhythm.Clicker;
import hanon.app.model.analyst.rhythm.RhythmMachine;
import hanon.app.model.music.StaffElement;

import java.util.List;

public class RhythmController extends BaseController {
  private RhythmMachine machine;

  public RhythmController() {
  }

  public void handleRhythm(List<StaffElement> elements) {
    machine = RhythmMachine.fromElements(elements, 140);
    Clicker clicker = new Clicker();
    machine.register(clicker);
    new Thread(clicker).run();
    new Thread(machine).start();  }

  @Override
  protected void stop() {
    machine.stop();
  }
}
