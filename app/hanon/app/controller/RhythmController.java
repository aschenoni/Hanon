package hanon.app.controller;

import hanon.app.MainDriver;
import hanon.app.model.analyst.rhythm.Clicker;
import hanon.app.model.analyst.rhythm.RhythmMachine;
import hanon.app.model.analyst.tuner.PitchEvaluator;
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
    Thread clickThread = new Thread(clicker);
    clickThread.setDaemon(true);
    clickThread.run();


    PitchEvaluator pe = new PitchEvaluator();
    machine.register(pe);

    ensureClickerReady();
    new Thread(machine).start();
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
