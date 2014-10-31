package hanon.app.controller;

import hanon.app.MainDriver;
import hanon.app.model.analyst.Observer;
import hanon.app.model.analyst.rhythm.Clicker;
import hanon.app.model.analyst.rhythm.RhythmMachine;
import hanon.app.model.analyst.tuner.IntonationJudge;
import hanon.app.model.analyst.tuner.MusicNoteEvaluation;
import hanon.app.model.music.MusicNote;
import hanon.app.model.music.NoteLength;
import hanon.app.model.music.NoteValue;
import hanon.app.model.music.StaffElement;

import java.util.ArrayList;
import java.util.List;


import hanon.app.model.player.noteimage.NoteImage;
import hanon.app.model.player.sheet.MusicSheet;
import hanon.app.model.util.FunctionalList;
import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
import javafx.scene.paint.Color;

public class RhythmController extends BaseController {
  private RhythmMachine machine;
  private MainDriver mainDriver;

  @FXML public Label rhythmStatus;
  
  @FXML public ToggleButton stopButton;
  private MusicSheet sheet;

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
    machine = RhythmMachine.fromElements(elements, 120);
    machine.register(new Clicker());
    IntonationJudge intonationJudge = new IntonationJudge();
    intonationJudge.register(System.out::println);
    intonationJudge.register(new ColorChanger(sheet));
    machine.register(intonationJudge);

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

  public void setSheet(MusicSheet sheet) {
    this.sheet = sheet;
  }


  class ColorChanger extends Task implements Observer<MusicNoteEvaluation> {
    private final MusicSheet sheet;
    private FunctionalList<NoteImage> notes;

    public ColorChanger(MusicSheet sheet) {
      this.sheet = sheet;
      notes = FunctionalList.fromIterable(sheet.getAllNoteImages());
      notes = notes.prepend(null); // must prepend a dummy note so first note is redrawn
    }

    @Override
    protected Object call() throws Exception {
      return null;
    }

    @Override
    public void inform(MusicNoteEvaluation info) {
      if (info.isPoor()) {
        Platform.runLater(() ->
          notes.head().paint(sheet.getBrush().withColor(Color.RED)));
      } else if (info.isGood()) {
        Platform.runLater(() ->
          notes.head().paint(sheet.getBrush().withColor(Color.YELLOWGREEN)));
      }
      notes = notes.tail();
    }
  }
}
