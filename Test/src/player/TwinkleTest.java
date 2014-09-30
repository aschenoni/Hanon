package player;

import hanon.app.model.music.StaffElementSet;
import hanon.app.musicpiece.TwinkleTwinkleLittleStar;
import javafx.application.Application;
import javafx.stage.Stage;

public class TwinkleTest extends Application {

  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage stage) {
    new TestMusicSheet(stage, new StaffElementSet(TwinkleTwinkleLittleStar.elements)).draw();
  }
}

