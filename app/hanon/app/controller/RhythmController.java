package hanon.app.controller;

import hanon.app.MainDriver;
import hanon.app.model.analyst.rhythm.Clicker;
import hanon.app.model.analyst.rhythm.RhythmMachine;
import hanon.app.model.music.StaffElement;

import java.util.List;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class RhythmController extends BaseController {
  private RhythmMachine machine;
  private MainDriver mainDriver;

  @FXML public Label rhythmStatus;
  
  @FXML public Button stopButton;
  
  public RhythmController() {
  }
  
  @FXML public void handleStop() {
	if(rhythmStatus.getText().equals("Playing Rhythm..."))
	{
		stop();
		stopButton.setText("Close");
		rhythmStatus.setText("Rhythm Stopped");
	}
	else
	{
		mainDriver.getHPane().setBottom(null);
	}
	
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
  
  public void setMainDriver(MainDriver driver)
  {
	  this.mainDriver = driver;
  }
}
