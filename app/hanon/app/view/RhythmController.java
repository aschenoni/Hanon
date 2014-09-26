package hanon.app.view;

import hanon.app.MainDriver;
import hanon.app.model.analyst.rhythm.Clicker;
import hanon.app.model.analyst.rhythm.RhythmMachine;
import hanon.app.model.music.StaffElement;

import java.util.List;

public class RhythmController {

  private RhythmMachine machine;
  private MainDriver mainDriver;

  public RhythmController() {
  }

  public void handleRhythm(List<StaffElement> elements) {
    machine = RhythmMachine.fromElements(elements, 140);
    Clicker c = new Clicker();
    machine.register(c);
    new Thread(c).run();
  }

  public void setMainDriver(MainDriver mainDriver) {
    this.mainDriver = mainDriver;
  }
}
