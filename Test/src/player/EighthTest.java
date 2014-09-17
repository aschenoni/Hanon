package player;

import hanon.app.controller.composer.record.WrittenNote;
import hanon.app.controller.music.*;
import javafx.application.Application;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

import static hanon.app.controller.music.GeneralStaffElement.measureLine;
import static hanon.app.controller.music.NoteValue.fromNameAndOctave;

public class EighthTest extends Application {

  private static final List<StaffElement> elements = new ArrayList<StaffElement>();
  static {
    elements.add(new WrittenNote(fromNameAndOctave(NoteValue.NoteName.A, 4), NoteLength.EIGHTH));
    elements.add(new WrittenNote(fromNameAndOctave(NoteValue.NoteName.B, 4), NoteLength.EIGHTH));
    elements.add(measureLine());
  }

  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage stage) {
    new MusicSheet(stage, new StaffElementSet(Clef.TREBLE, elements)).draw();
  }
}

