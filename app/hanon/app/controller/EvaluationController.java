package hanon.app.controller;

import hanon.app.MainDriver;
import hanon.app.model.analyst.Observer;
import hanon.app.model.analyst.RecordingGenerator;
import hanon.app.model.analyst.dynamics.DynamicsJudge;
import hanon.app.model.analyst.dynamics.SoundLevels;
import hanon.app.model.analyst.rhythm.Clicker;
import hanon.app.model.analyst.rhythm.RhythmMachine;
import hanon.app.model.analyst.tuner.IntonationJudge;
import hanon.app.model.analyst.tuner.MusicNoteEvaluation;
import hanon.app.model.music.*;

import java.io.File;
import java.util.ArrayList;
import java.util.List;


import hanon.app.model.player.noteimage.NoteImage;
import hanon.app.model.player.sheet.MusicSheet;
import hanon.app.model.player.sheet.StaffPlaceable;
import hanon.app.model.player.staff.CrescendoImage;
import hanon.app.model.player.staff.DecrescendoImage;
import hanon.app.model.util.FunctionalList;
import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;

public class EvaluationController extends BaseController {
  private RhythmMachine machine;
  private MainDriver mainDriver;


  @FXML public Label rhythmStatus;
  
  @FXML public ToggleButton stopButton;
  private MusicSheet sheet;

  public EvaluationController() {
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
    List<StaffElement> quarters = new ArrayList<>();
    quarters.add(new MusicNote(new NoteValue(440f), NoteLength.QUARTER));
    quarters.add(new MusicNote(new NoteValue(440f), NoteLength.QUARTER));
    quarters.add(new MusicNote(new NoteValue(440f), NoteLength.QUARTER));
    quarters.add(new MusicNote(new NoteValue(440f), NoteLength.QUARTER));
    RhythmMachine counter = RhythmMachine.fromElements(quarters, 120);

    Thread recThread = new Thread(RecordingGenerator.getInstance());
    recThread.setDaemon(true);
    recThread.start();

    Clicker clicker = new Clicker();
    counter.register(clicker);
    counter.register(this::startMachine);
    counter.register(new CountInShower());

    machine = RhythmMachine.fromElements(elements, 120);
    machine.register(clicker);
    IntonationJudge intonationJudge = new IntonationJudge();
    intonationJudge.register(new NoteColorChanger(sheet));
    machine.register(intonationJudge);

    DynamicsJudge dynamicsJudge = new DynamicsJudge();
    dynamicsJudge.register(new CrescendoColorChanger(sheet));
    machine.register(dynamicsJudge);

    ensureClickerReady();

    Thread thread = new Thread(counter);
    thread.setDaemon(true);
    thread.start();
  }

  private void startMachine(StaffElement e) {
    if (e == null) {
      Thread thread = new Thread(machine);
      thread.setDaemon(true);
      thread.start();
    }
  }

  private void ensureClickerReady() {
    try {
      Thread.sleep(2000);
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

  class NoteColorChanger extends Task implements Observer<MusicNoteEvaluation> {
    private FunctionalList<NoteImage> notes;

    public NoteColorChanger(MusicSheet sheet) {
      notes = FunctionalList.fromIterable(sheet.getAllNoteImages());
    }

    @Override
    protected Object call() throws Exception {
      return null;
    }

    @Override
    public void inform(MusicNoteEvaluation info) {
      NoteImage n = notes.head();
      if (info.isPoor()) {
        Platform.runLater(() ->
          n.paint(sheet.getBrush().withColor(Color.RED)));
      } else if (info.isGood()) {
        Platform.runLater(() ->
          n.paint(sheet.getBrush().withColor(Color.SEAGREEN)));
      }
      notes = notes.tail();
    }
  }

  class CrescendoColorChanger extends Task implements Observer<SoundLevels> {
    private FunctionalList<StaffPlaceable> crescendos;

    public CrescendoColorChanger(MusicSheet sheet) {
      crescendos = FunctionalList.fromIterable(sheet.getAllCrescendos());
    }

    @Override
    public void inform(SoundLevels levels) {
      Color color;
      StaffPlaceable c = crescendos.head();

      if (levels.isCrescendo() && c instanceof CrescendoImage) {
        color = Color.SEAGREEN;
      } else if (levels.isDecrescendo() && c instanceof DecrescendoImage) {
        color = Color.SEAGREEN;
      } else {
        color = Color.RED;
      }
      Platform.runLater(() -> c.paint(sheet.getBrush().withColor(color)));
      crescendos = crescendos.tail();
    }

    @Override
    protected Object call() throws Exception {
      return null;
    }
  }

  class CountInShower extends Task implements Observer<EvaluableElement> {
    private int index = 0;
    private String[] files = {"count_1.png", "count_2.png", "count_ready.png", "count_go.png"};
    private List<ImageView> images = new ArrayList<>();

    public CountInShower() {
      for (String f : files) {
        String path = "res/images/" + f;
        File file = new File(path);
        images.add(new ImageView(new Image(file.toURI().toString())));
      }
    }

    @Override
    public void inform(EvaluableElement info) {
      Platform.runLater(() -> {
        if (index > 0)
          sheet.getBrush().unpaint(images.get(index-1));
        if (index < 4)
          sheet.getBrush().paint(images.get(index), getX(), getY());
        index++;
      });
    }

    private int getX() {
      int fullWidth = (int)sheet.getWidth();
      int imageWidth = 450;
      return (fullWidth - imageWidth)/2;
    }

    private int getY() {
      int fullHeight = (int)sheet.getHeight();
      int imageHeight = 200;
      return fullHeight - imageHeight - 150;
    }

    @Override
    protected Object call() throws Exception {
      return null;
    }
  }
}
