package hanon.app.controller;

import hanon.app.MainDriver;
import hanon.app.model.analyst.Observer;
import hanon.app.model.analyst.RecordingGenerator;
import hanon.app.model.analyst.dynamics.DynamicsJudge;
import hanon.app.model.analyst.dynamics.SoundLevels;
import hanon.app.model.analyst.results.SongResult;
import hanon.app.model.analyst.results.SongResultMusicAggregator;
import hanon.app.model.analyst.rhythm.Clicker;
import hanon.app.model.analyst.rhythm.RhythmMachine;
import hanon.app.model.analyst.tuner.IntonationJudge;
import hanon.app.model.analyst.tuner.MusicNoteEvaluation;
import hanon.app.model.music.*;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;






import hanon.app.model.player.noteimage.NoteImage;
import hanon.app.model.player.sheet.Brush;
import hanon.app.model.player.sheet.MusicSheet;
import hanon.app.model.player.sheet.StaffPlaceable;
import hanon.app.model.player.staff.CrescendoImage;
import hanon.app.model.player.staff.DecrescendoImage;
import hanon.app.model.util.FunctionalList;
import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.geometry.Side;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
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
  
  @FXML public void handlePlay() {
	  System.out.println("button was pressed");
	  handleRhythm( sheet.getSets().get(0).getElements() );
  }
  
  public void handleRhythm(List<StaffElement> elements) {
    List<StaffElement> quarters = new ArrayList<>();
    quarters.add(new MusicNote(new NoteValue(440f), NoteLength.QUARTER));
    quarters.add(new MusicNote(new NoteValue(440f), NoteLength.QUARTER));
    quarters.add(new MusicNote(new NoteValue(440f), NoteLength.QUARTER));
    quarters.add(new MusicNote(new NoteValue(440f), NoteLength.QUARTER));
    RhythmMachine counter = RhythmMachine.fromElements(quarters, 120);

    RecordingGenerator.getInstance().start();

    CountInShower cis = new CountInShower();

    counter.register(new Clicker());
    counter.register(e -> { if(e == null) machine.start(); });
    counter.register(cis);

    counter.setOnStop(cis::cancel);

    machine = RhythmMachine.fromElements(elements, 120);
    machine.register(new Clicker());

    IntonationJudge intonationJudge = new IntonationJudge();
    DynamicsJudge dynamicsJudge = new DynamicsJudge();

    NoteColorChanger noteColorChanger = new NoteColorChanger();
    CrescendoColorChanger crescendoColorChanger = new CrescendoColorChanger(sheet);

    intonationJudge.register(noteColorChanger);
    dynamicsJudge.register(crescendoColorChanger);

    SongResultMusicAggregator sra = new SongResultMusicAggregator();
    sra.setEvalController(this);
    intonationJudge.register(sra);
    dynamicsJudge.register(sra.getSoundAggregator());
    machine.register(intonationJudge);
    machine.register(dynamicsJudge);
    machine.setOnStop(() -> {
      noteColorChanger.cancel();
      crescendoColorChanger.cancel();
    });

    ensureClickerReady();

    counter.start();
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
  
  public void publish(SongResult sr) throws IOException {
	mainDriver.showResults(sr);
  }

  class NoteColorChanger extends Task implements Observer<MusicNoteEvaluation> {
    private FunctionalList<NoteImage> notes;

    public NoteColorChanger() {
      notes = FunctionalList.fromIterable(sheet.getAllNoteImages());
    }

    @Override
    protected Object call() throws Exception {
      return null;
    }

    @Override
    public void inform(MusicNoteEvaluation info) {
      NoteImage n = notes.head();
      if(info != null) {
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

      if (c == null) return;

      if (c instanceof CrescendoImage) {
        ((CrescendoImage)c).setOnMousePressed(e -> graphLevels(levels));
        ((CrescendoImage)c).setOnMouseReleased(e -> hideLevels());
      } else {
        ((DecrescendoImage)c).setOnMousePressed(e -> graphLevels(levels));
        ((DecrescendoImage)c).setOnMouseReleased(e -> hideLevels());
      }

      if (levels.isCrescendo() && c instanceof CrescendoImage) {
        color = Color.SEAGREEN;
      } else if (levels.isDecrescendo() && c instanceof DecrescendoImage) {
        color = Color.SEAGREEN;
      } else {
        color = Color.RED;
      }
      final Brush b = sheet.getBrush().withColor(color);
      Platform.runLater(() -> c.paint(b));
      crescendos = crescendos.tail();
    }

    private void graphLevels(SoundLevels levels) {
    	final NumberAxis xAxis = new NumberAxis();
    	final NumberAxis yAxis = new NumberAxis();
    	LineChart<Number, Number> levelGraph = new LineChart<Number,Number>(xAxis,yAxis);
    	XYChart.Series series = new XYChart.Series();
    	int i = 1;
    	for(Double level  : levels.averagedLevels().toArrayList()) {
    		series.getData().add(new XYChart.Data(i,level));
    		i++;			
		}
    	levelGraph.getData().add(series);
    	((MusicSheet)mainDriver.getRootLayout().getCenter()).getChildren().add(levelGraph);
    }

    private void hideLevels() {
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
