package hanon.app.controller;

import hanon.app.MainDriver;
import hanon.app.model.analyst.Observer;
import hanon.app.model.analyst.tuner.Tuner;
import hanon.app.model.analyst.tuner.TunerInfo;
import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class TunerController {

  private Tuner tuner = new Tuner(200);

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

  class Updater extends Task implements Observer<TunerInfo> {

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
