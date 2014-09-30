package hanon.app.controller;

import hanon.app.model.analyst.Observer;
import hanon.app.model.analyst.tuner.Tuner;
import hanon.app.model.analyst.tuner.TunerInfo;
import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class TunerController extends BaseController {

  private final Tuner tuner = new Tuner(200);

	@FXML	private Label noteName;
	@FXML	private Label octave;
	@FXML	private Label frequency;
	@FXML	private Label difference;

	public void handleTuner() {
    Updater u = new Updater();
		tuner.register(u);

    Thread th = new Thread(u);
    th.setDaemon(true);
    th.start();
    new Thread(tuner).start();
	}

  @Override
  protected void stop() {
    tuner.stop();
  }

  class Updater extends Task implements Observer<TunerInfo> {

    @Override
    public void run() { }

    @Override
    public void inform(final TunerInfo info) {
      Platform.runLater(new Runnable() {
        @Override
        public void run() {
          noteName.setText(info.getName().toString());
          octave.setText(Integer.toString(info.getOctave()));
          frequency.setText(Float.toString(info.getFrequency()));
          difference.setText(Float.toString(info.getDifference()));
        }
      });
    }

    @Override
    protected Object call() throws Exception {
      return null;
    }
  }
}
