package player;

import javafx.application.Application;
import javafx.stage.Stage;

public class TwinkleTest extends Application {

  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage stage) {
    new MusicSheet(TwinkleTwinkleLittleStar.elements, stage).draw();
  }
}

