package hanon.app.view;

import javafx.fxml.FXML;
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
	String noteName;
	@FXML
	String octave;
	@FXML
	String frequency;
	@FXML
	String difference;
	
	Stage primaryStage;
	MainDriver mainDriver;
	
	@Override
	public void inform(TunerInfo info) {
		tunerVal = info;
		noteName = tunerVal.getName().toString();
		octave = new Integer(tunerVal.getOctave()).toString();
		frequency = new Float(tunerVal.getFrequency()).toString();
		difference = new Float(tunerVal.getDifference()).toString();
	}

	public Stage getPrimaryStage(){
		return this.primaryStage;
	}

	public void handleTuner() throws InterruptedException {
		Tuner tuner = new Tuner(500);
		tuner.register(this);
		new Thread(tuner).start();
		Thread.sleep(10000);
		tuner.stop();
	}

	public void setMainDriver(MainDriver mainDriver) {
		this.mainDriver = mainDriver;
		
	}
}
