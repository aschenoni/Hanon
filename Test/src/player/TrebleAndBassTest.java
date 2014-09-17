package player;

import hanon.app.controller.composer.record.WrittenNote;
import hanon.app.controller.music.Clef;
import hanon.app.controller.music.StaffElement;
import hanon.app.controller.music.StaffElementSet;
import hanon.app.controller.music.TimeSignature;
import javafx.application.Application;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

import static hanon.app.controller.music.GeneralStaffElement.measureLine;
import static hanon.app.controller.music.NoteLength.QUARTER;
import static hanon.app.controller.music.NoteValue.NoteName.*;
import static hanon.app.controller.music.NoteValue.fromNameAndOctave;

public class TrebleAndBassTest extends Application {

  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage stage) {
    List<StaffElement> bassElements = new ArrayList<StaffElement>();

    bassElements.add(new TimeSignature(2, 4));
    bassElements.add(new WrittenNote(fromNameAndOctave(C, 3), QUARTER));
    bassElements.add(new WrittenNote(fromNameAndOctave(D, 3), QUARTER));
    bassElements.add(measureLine());

    bassElements.add(new WrittenNote(fromNameAndOctave(E, 3), QUARTER));
    bassElements.add(new WrittenNote(fromNameAndOctave(F, 3), QUARTER));
    bassElements.add(measureLine());

    bassElements.add(new WrittenNote(fromNameAndOctave(G, 3), QUARTER));
    bassElements.add(new WrittenNote(fromNameAndOctave(A, 3), QUARTER));
    bassElements.add(measureLine());

    bassElements.add(new WrittenNote(fromNameAndOctave(B, 3), QUARTER));
    bassElements.add(new WrittenNote(fromNameAndOctave(C, 4), QUARTER));
    bassElements.add(measureLine());
    bassElements.add(new WrittenNote(fromNameAndOctave(C, 3), QUARTER));
    bassElements.add(new WrittenNote(fromNameAndOctave(D, 3), QUARTER));
    bassElements.add(measureLine());

    bassElements.add(new WrittenNote(fromNameAndOctave(E, 3), QUARTER));
    bassElements.add(new WrittenNote(fromNameAndOctave(F, 3), QUARTER));
    bassElements.add(measureLine());

    bassElements.add(new WrittenNote(fromNameAndOctave(G, 3), QUARTER));
    bassElements.add(new WrittenNote(fromNameAndOctave(A, 3), QUARTER));
    bassElements.add(measureLine());

    bassElements.add(new WrittenNote(fromNameAndOctave(B, 3), QUARTER));
    bassElements.add(new WrittenNote(fromNameAndOctave(C, 4), QUARTER));
    bassElements.add(measureLine());


    List<StaffElement> trebleElements = new ArrayList<StaffElement>();

    trebleElements.add(new TimeSignature(2, 4));
    trebleElements.add(new WrittenNote(fromNameAndOctave(C, 4), QUARTER));
    trebleElements.add(new WrittenNote(fromNameAndOctave(D, 4), QUARTER));
    trebleElements.add(measureLine());

    trebleElements.add(new WrittenNote(fromNameAndOctave(E, 4), QUARTER));
    trebleElements.add(new WrittenNote(fromNameAndOctave(F, 4), QUARTER));
    trebleElements.add(measureLine());

    trebleElements.add(new WrittenNote(fromNameAndOctave(G, 4), QUARTER));
    trebleElements.add(new WrittenNote(fromNameAndOctave(A, 4), QUARTER));
    trebleElements.add(measureLine());

    trebleElements.add(new WrittenNote(fromNameAndOctave(B, 4), QUARTER));
    trebleElements.add(new WrittenNote(fromNameAndOctave(C, 5), QUARTER));
    trebleElements.add(measureLine());
    trebleElements.add(new WrittenNote(fromNameAndOctave(C, 4), QUARTER));
    trebleElements.add(new WrittenNote(fromNameAndOctave(D, 4), QUARTER));
    trebleElements.add(measureLine());

    trebleElements.add(new WrittenNote(fromNameAndOctave(E, 4), QUARTER));
    trebleElements.add(new WrittenNote(fromNameAndOctave(F, 4), QUARTER));
    trebleElements.add(measureLine());

    trebleElements.add(new WrittenNote(fromNameAndOctave(G, 4), QUARTER));
    trebleElements.add(new WrittenNote(fromNameAndOctave(A, 4), QUARTER));
    trebleElements.add(measureLine());

    trebleElements.add(new WrittenNote(fromNameAndOctave(B, 4), QUARTER));
    trebleElements.add(new WrittenNote(fromNameAndOctave(C, 5), QUARTER));
    trebleElements.add(measureLine());

    new MusicSheet(
            stage,
            new StaffElementSet(Clef.TREBLE, trebleElements),
            new StaffElementSet(Clef.BASS, bassElements)).draw();
  }
}

