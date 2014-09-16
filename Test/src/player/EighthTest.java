package player;

import hanon.app.model.music.NoteLength;
import hanon.app.model.music.NoteValue;
import hanon.app.model.music.StaffElement;
import hanon.app.model.composer.record.WrittenNote;
import javafx.application.Application;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

import static hanon.app.model.music.GeneralStaffElement.measureLine;
import static hanon.app.model.music.NoteValue.fromNameAndOctave;

public class EighthTest extends Application {

  private static final List<StaffElement> elements = new ArrayList<StaffElement>();
  static {
    elements.add(new WrittenNote(fromNameAndOctave(NoteValue.NoteName.A, 4), NoteLength.eighth));
    elements.add(new WrittenNote(fromNameAndOctave(NoteValue.NoteName.B, 4), NoteLength.eighth));
    elements.add(measureLine());
  }

  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage stage) {
    new MusicSheet(elements, stage).draw();
  }
}

