package player;

import hanon.app.model.music.*;
import javafx.application.Application;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

import static hanon.app.model.music.GeneralStaffElement.measureLine;
import static hanon.app.model.music.NoteLength.*;
import static hanon.app.model.music.NoteValue.NoteName.*;
import static hanon.app.model.music.NoteValue.fromNameAndOctave;

public class TrebleAndBassTest extends Application {

  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage stage) {
    List<StaffElement> bassElements = new ArrayList<StaffElement>();

    bassElements.add(new TimeSignature(2, 4));
    bassElements.add(new MusicNote(fromNameAndOctave(C, 3), QUARTER));
    bassElements.add(new MusicNote(fromNameAndOctave(D, 3), QUARTER));
    bassElements.add(measureLine());

    bassElements.add(new MusicNote(fromNameAndOctave(E, 3), QUARTER));
    bassElements.add(new MusicNote(fromNameAndOctave(F, 3), QUARTER));
    bassElements.add(measureLine());

    bassElements.add(new MusicNote(fromNameAndOctave(G, 3), QUARTER));
    bassElements.add(new MusicNote(fromNameAndOctave(A, 3), QUARTER));
    bassElements.add(measureLine());

    bassElements.add(new MusicNote(fromNameAndOctave(B, 3), QUARTER));
    bassElements.add(new MusicNote(fromNameAndOctave(C, 4), QUARTER));
    bassElements.add(measureLine());
    bassElements.add(new MusicNote(fromNameAndOctave(C, 3), QUARTER));
    bassElements.add(new MusicNote(fromNameAndOctave(D, 3), QUARTER));
    bassElements.add(measureLine());

    bassElements.add(new MusicNote(fromNameAndOctave(E, 3), QUARTER));
    bassElements.add(new MusicNote(fromNameAndOctave(F, 3), QUARTER));
    bassElements.add(measureLine());

    bassElements.add(new MusicNote(fromNameAndOctave(G, 3), QUARTER));
    bassElements.add(new MusicNote(fromNameAndOctave(A, 3), QUARTER));
    bassElements.add(measureLine());

    bassElements.add(new MusicNote(fromNameAndOctave(B, 3), QUARTER));
    bassElements.add(new MusicNote(fromNameAndOctave(C, 4), QUARTER));
    bassElements.add(measureLine());


    List<StaffElement> trebleElements = new ArrayList<StaffElement>();

    trebleElements.add(new TimeSignature(2, 4));
    trebleElements.add(new MusicNote(fromNameAndOctave(C, 4), QUARTER));
    trebleElements.add(new MusicNote(fromNameAndOctave(D, 4), QUARTER));
    trebleElements.add(measureLine());

    trebleElements.add(new MusicNote(fromNameAndOctave(E, 4), QUARTER));
    trebleElements.add(new MusicNote(fromNameAndOctave(F, 4), QUARTER));
    trebleElements.add(measureLine());

    trebleElements.add(new MusicNote(fromNameAndOctave(G, 4), QUARTER));
    trebleElements.add(new MusicNote(fromNameAndOctave(A, 4), QUARTER));
    trebleElements.add(measureLine());

    trebleElements.add(new MusicNote(fromNameAndOctave(B, 4), QUARTER));
    trebleElements.add(new MusicNote(fromNameAndOctave(C, 5), QUARTER));
    trebleElements.add(measureLine());
    trebleElements.add(new MusicNote(fromNameAndOctave(C, 4), QUARTER));
    trebleElements.add(new MusicNote(fromNameAndOctave(D, 4), QUARTER));
    trebleElements.add(measureLine());

    trebleElements.add(new MusicNote(fromNameAndOctave(E, 4), QUARTER));
    trebleElements.add(new MusicNote(fromNameAndOctave(F, 4), QUARTER));
    trebleElements.add(measureLine());

    trebleElements.add(new MusicNote(fromNameAndOctave(G, 4), QUARTER));
    trebleElements.add(new MusicNote(fromNameAndOctave(A, 4), QUARTER));
    trebleElements.add(measureLine());

    trebleElements.add(new MusicNote(fromNameAndOctave(B, 4), QUARTER));
    trebleElements.add(new MusicNote(fromNameAndOctave(C, 5), QUARTER));
    trebleElements.add(measureLine());

    new TestMusicSheet(
            stage,
            new StaffElementSet(Clef.TREBLE, trebleElements),
            new StaffElementSet(Clef.BASS, bassElements)).draw();
  }
}

