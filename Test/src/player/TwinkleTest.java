package player;

import hanon.app.model.music.Clef;
import hanon.app.model.music.StaffElementSet;
import hanon.app.view.TwinkleTwinkleLittleStar;
import javafx.application.Application;
import javafx.stage.Stage;

public class TwinkleTest extends Application {

  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage stage) {
    new TestMusicSheet(stage, new StaffElementSet(Clef.TREBLE, TwinkleTwinkleLittleStar.elements)).draw();
  }
}

