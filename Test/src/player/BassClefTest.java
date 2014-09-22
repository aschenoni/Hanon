package player;

import hanon.app.model.music.Clef;
import hanon.app.model.music.StaffElementSet;
import hanon.app.model.composer.record.WrittenNote;
import hanon.app.model.music.StaffElement;
import javafx.application.Application;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

import static hanon.app.model.music.GeneralStaffElement.measureLine;
import static hanon.app.model.music.NoteLength.*;
import static hanon.app.model.music.NoteValue.NoteName.*;
import static hanon.app.model.music.NoteValue.fromNameAndOctave;


public class BassClefTest extends Application {

  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage stage) {
    List<StaffElement> elements = new ArrayList<StaffElement>();

    elements.add(new WrittenNote(fromNameAndOctave(G, 2), QUARTER));
    elements.add(new WrittenNote(fromNameAndOctave(A, 2), QUARTER));
    elements.add(new WrittenNote(fromNameAndOctave(B, 2), QUARTER));
    elements.add(new WrittenNote(fromNameAndOctave(C, 3), QUARTER));
    elements.add(new WrittenNote(fromNameAndOctave(D, 3), QUARTER));
    elements.add(new WrittenNote(fromNameAndOctave(E, 3), QUARTER));
    elements.add(new WrittenNote(fromNameAndOctave(F, 3), QUARTER));
    elements.add(new WrittenNote(fromNameAndOctave(G, 3), QUARTER));
    elements.add(measureLine());

    new TestMusicSheet(stage, new StaffElementSet(Clef.BASS, elements)).draw();
  }
}
