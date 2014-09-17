package player;

import hanon.app.controller.music.Clef;
import hanon.app.controller.music.StaffElementSet;
import javafx.application.Application;
import javafx.stage.Stage;

import static player.TwinkleTwinkleLittleStar.*;

public class TwinkleTest extends Application {

  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage stage) {
    new MusicSheet(stage, new StaffElementSet(Clef.TREBLE, elements)).draw();
  }
}

