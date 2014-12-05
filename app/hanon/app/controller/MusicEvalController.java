package hanon.app.controller;

import hanon.app.model.analyst.tuner.MusicNoteEvaluation;
import javafx.fxml.FXML;
import javafx.scene.control.Label;


public class MusicEvalController {
  @FXML Label actualNote;
  @FXML Label actualFreq;
  @FXML Label expectedNote;
  @FXML Label expectedFreq;

  public MusicEvalController() {}

  public void setEvaluation(MusicNoteEvaluation evaluation) {
    actualNote.setText(evaluation.getPlayed().getName().toString());
    expectedNote.setText(evaluation.getExpected().getName().toString());
    actualFreq.setText("" + Math.round(evaluation.getPlayed().getFrequency()));
    expectedFreq.setText("" + Math.round(evaluation.getExpected().getFrequency()));
  }
}
