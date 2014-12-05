package hanon.app.controller;

import hanon.app.model.analyst.tuner.MusicNoteEvaluation;
import javafx.fxml.FXML;
import javafx.scene.control.Label;


public class MusicEvalController {
  @FXML Label actualNote;
  @FXML Label actualFreq;
  @FXML Label expectedNote;
  @FXML Label expectedFreq;

  private MusicNoteEvaluation evaluation;

  public MusicEvalController() {}

  public void setEvaluation(MusicNoteEvaluation evaluation) {
    this.evaluation = evaluation;
    actualNote.setText(evaluation.getPlayed().toString());
  }
}
