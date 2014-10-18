package hanon.app.controller;

import hanon.app.model.analyst.rhythm.Clicker;
import hanon.app.model.analyst.rhythm.RhythmMachine;
import hanon.app.model.music.StaffElement;

import java.util.List;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class RhythmController extends BaseController {
  private RhythmMachine machine;

  @FXML Label rhythmStatus;
  
  public RhythmController() {
  }
  
  @FXML public void handleStop() {
	stop();
	rhythmStatus.setText("Rhythm Stopped");
  }
  
  public void handleRhythm(List<StaffElement> elements) {
    machine = RhythmMachine.fromElements(elements, 140);
    Clicker clicker = new Clicker();
    machine.register(clicker);
    new Thread(clicker).run();
    new Thread(machine).start();  }

  @Override
 @FXML protected void stop() {
    machine.stop();
  }
}
