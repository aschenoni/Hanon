package hanon.app.view;

import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import hanon.app.MainDriver;
import hanon.app.model.analyst.tuner.Tuner;
import hanon.app.model.analyst.tuner.TunerInfo;
import hanon.app.model.analyst.tuner.TunerObserver;

public class TunerController {

	@FXML
	TunerInfo tunerVal;
	@FXML
	Label noteName;
	@FXML
	Label octave;
	@FXML
	Label frequency;
	@FXML
	Label difference;
	
	Stage primaryStage;
	MainDriver mainDriver;

	public Stage getPrimaryStage(){
		return this.primaryStage;
	}

	public void handleTuner() throws InterruptedException {
		Tuner tuner = new Tuner(200);
		
    Updater u = new Updater();
		tuner.register(u);

    Thread th = new Thread(u);
    th.setDaemon(true);
    th.start();
    new Thread(tuner).start();
	}

	public void setMainDriver(MainDriver mainDriver) {
		this.mainDriver = mainDriver;
		
	}

  class Updater extends Task implements TunerObserver {

    @Override
    public void run() {

    }

    @Override
    public void inform(TunerInfo info) {
      tunerVal = info;
      Platform.runLater(new Runnable() {
        @Override
        public void run() {
          noteName.setText(tunerVal.getName().toString());
          octave.setText(new Integer(tunerVal.getOctave()).toString());
        }
      });
    }

    @Override
    protected Object call() throws Exception {
      return null;
    }
  }
}
