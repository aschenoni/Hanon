package player;

import hanon.app.model.music.*;
import javafx.application.Application;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

import static hanon.app.model.music.GeneralStaffElement.measureLine;
import static hanon.app.model.music.GeneralStaffElement.tie;
import static hanon.app.model.music.NoteValue.fromNameAndOctave;

public class TieTest extends Application {

  private static final List<StaffElement> elements = new ArrayList<>();
  static {
    elements.add(Clef.TREBLE);
    elements.add(tie());
    elements.add(new MusicNote(fromNameAndOctave(NoteValue.NoteName.A, 4), NoteLength.EIGHTH));
    elements.add(measureLine());
    elements.add(new MusicNote(fromNameAndOctave(NoteValue.NoteName.A, 4), NoteLength.EIGHTH));
    elements.add(tie());
    elements.add(new MusicNote(fromNameAndOctave(NoteValue.NoteName.C, 5), NoteLength.EIGHTH));
    elements.add(measureLine());
    elements.add(new MusicNote(fromNameAndOctave(NoteValue.NoteName.C, 5), NoteLength.EIGHTH));
    elements.add(measureLine());
  }

  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage stage) {
    new TestMusicSheet(stage, new StaffElementSet(elements)).draw();
  }
}
