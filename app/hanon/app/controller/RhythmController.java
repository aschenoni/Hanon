package hanon.app.controller;

import hanon.app.MainDriver;
import hanon.app.model.analyst.rhythm.RhythmMachine;
import hanon.app.model.analyst.rhythm.RhythmObservers;
import hanon.app.model.music.StaffElement;

import java.util.List;

import org.controlsfx.control.SegmentedButton;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.AnchorPane;

public class RhythmController extends BaseController {
  private RhythmMachine machine;
  private MainDriver mainDriver;

  @FXML public Label rhythmStatus;
  
  @FXML public ToggleButton stopButton;
  
  public RhythmController() {
  }
  
  @FXML public void handleStop() {
	if(rhythmStatus.getText().equals("Playing Rhythm...")) {
		stop();
		stopButton.setText("Close");
		rhythmStatus.setText("Rhythm Stopped");
	}
	else {
		mainDriver.getHPane().setBottom(null);
	}
	
  }
  
  public void handleRhythm(List<StaffElement> elements) {
    machine = RhythmMachine.fromElements(elements, 140);
    machine.register(RhythmObservers.clicker);
    machine.register(RhythmObservers.pitchEvaluator);

    ensureClickerReady();
    Thread thread = new Thread(machine);
    thread.setDaemon(true);
    thread.start();
  }

  private void ensureClickerReady() {
    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  @Override
  @FXML protected void stop() {
    machine.stop();
  }
  
  public void setMainDriver(MainDriver driver)
  {
	  this.mainDriver = driver;
  }

}
