package hanon.app.model.analyst.tuner;

import hanon.app.MainDriver;
import hanon.app.controller.BaseController;
import hanon.app.controller.MusicEvalController;
import hanon.app.model.music.MusicNote;
import hanon.app.model.music.NoteValue;
import hanon.app.model.player.sheet.MusicSheet;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class MusicNoteEvaluation {
  private final MusicNote played;
  private final MusicNote expected;
  private AnchorPane pane;

  public MusicNoteEvaluation(MusicNote played, MusicNote expected) {
    this.played = played;
    this.expected = expected;
  }

  public MusicNote getExpected() {
    return expected;
  }

  public MusicNote getPlayed() {
    return played;
  }

  public boolean isPoor() {
    return compareFrequencies() > NoteValue.FREQ_CONST;
  }

  public boolean isGood() {
    return compareFrequencies() < NoteValue.FREQ_CONST;
  }

  private float compareFrequencies() {
    return Float.max(played.getFrequency() / expected.getFrequency(),
            expected.getFrequency() / played.getFrequency());
  }

  @Override
  public String toString() {
    return "Played: {" + played + "}, Expected:{" + expected + "}";
  }

  public void showStatistics(int x, int y) throws IOException {
    FXMLLoader loader = BaseController.buildLoader("NoteEvalView");
    pane = loader.load();
    MusicEvalController controller = loader.getController();
    controller.setEvaluation(this);

    ((MusicSheet)(MainDriver
            .getInstance()
            .getRootLayout()
            .getCenter()))
            .getChildren()
            .add(pane);
    pane.setLayoutX(x);
    pane.setLayoutY(y);
  }

  public void hideStatistics() {
    ((MusicSheet)(MainDriver
            .getInstance()
            .getRootLayout()
            .getCenter()))
            .getChildren()
            .remove(pane);
  }
}
