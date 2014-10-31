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
import hanon.app.model.music.StaffElementType;

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
    elements.add(0, new MusicNote(new NoteValue(0), NoteLength.QUARTER));
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
    private int elementIndex;
    
    public ColorChanger(MusicSheet sheet) {
      this.sheet = sheet;
      int elementIndex = 0;
      notes = FunctionalList.fromIterable(sheet.getAllNoteImages());
    }

    @Override
    protected Object call() throws Exception {
      return null;
    }

    @Override
    public void inform(MusicNoteEvaluation info) {
      if (info.isPoor()) {
        Platform.runLater(() -> {
        	if(sheet.getSets().get(0).getElements().get(elementIndex).getType() == StaffElementType.NOTE)
        	{
        		((MusicNote) (sheet.getSets().get(0).getElements().get(elementIndex))).setColor(Color.RED);
        		
        		//NASTY workaround, for some reason an extra note is getting added to the beginning of the elements each iteration (maybe from the draw function?)
        		if(sheet.getSets().get(0).getElements().get(0).getType() != StaffElementType.CLEF)
        		{
        			sheet.getSets().get(0).getElements().remove(0);
        		}
        		sheet.redraw(500, 500);
        	}
          
        });
      }
      elementIndex++;
    }
  }
}
