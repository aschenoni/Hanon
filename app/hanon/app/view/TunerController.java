package hanon.app.view;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import hanon.app.MainDriver;
import hanon.app.model.analyst.tuner.Tuner;
import hanon.app.model.analyst.tuner.TunerInfo;
import hanon.app.model.analyst.tuner.TunerObserver;

public class TunerController implements TunerObserver {

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
	
	@Override
	public void inform(TunerInfo info) {
		tunerVal = info;
		noteName.setText(tunerVal.getName().toString());
		octave.setText(new Integer(tunerVal.getOctave()).toString());
		//frequency.setText(new Float(tunerVal.getFrequency()).toString());
		//difference.setText(new Float(tunerVal.getDifference()).toString());
	}

	public Stage getPrimaryStage(){
		return this.primaryStage;
	}

	public void handleTuner() throws InterruptedException {
		Tuner tuner = new Tuner(500);
		tuner.register(this);
		new Thread(tuner).start();
		Thread.sleep(1000);
		tuner.stop();
	}

	public void setMainDriver(MainDriver mainDriver) {
		this.mainDriver = mainDriver;
		
	}
}
