package player;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.stage.Stage;
import music.*;
import sheet.Brush;
import sheet.StaffPlaceable;
import staff.Staff;
import staff.StaffSet;

import java.util.ArrayList;
import java.util.List;

import static music.GeneralStaffElement.*;
import static music.NoteLength.*;
import static music.NoteValue.*;
import static music.NoteValue.NoteName.*;

public class SheetPanel extends Application {

  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage stage) {
    Group group = new Group();
    Canvas canvas = new Canvas(1000, 1000);
    group.getChildren().add(canvas);
    stage.setScene(new Scene(group));
    stage.show();

    Brush brush = new Brush(group, canvas.getGraphicsContext2D());

    List<StaffElement> elements = new ArrayList<StaffElement>();
    elements.add(new TimeSignature(2,4));
    elements.add(new WrittenNote(fromNameAndOctave(C, 4), quarter));
    elements.add(new WrittenNote(fromNameAndOctave(C, 4), quarter));
    elements.add(measureLine());
    elements.add(new WrittenNote(fromNameAndOctave(G, 4), quarter));
    elements.add(new WrittenNote(fromNameAndOctave(G, 4), quarter));
    elements.add(measureLine());
    elements.add(new WrittenNote(fromNameAndOctave(A, 4), quarter));
    elements.add(new WrittenNote(fromNameAndOctave(A, 4), quarter));
    elements.add(measureLine());
    elements.add(new WrittenNote(fromNameAndOctave(G, 4), half));
    elements.add(measureLine());

    elements.add(new WrittenNote(fromNameAndOctave(F, 4), quarter));
    elements.add(new WrittenNote(fromNameAndOctave(F, 4), quarter));
    elements.add(measureLine());
    elements.add(new WrittenNote(fromNameAndOctave(E, 4), quarter));
    elements.add(new WrittenNote(fromNameAndOctave(E, 4), quarter));
    elements.add(measureLine());
    elements.add(new WrittenNote(fromNameAndOctave(D, 4), quarter));
    elements.add(new WrittenNote(fromNameAndOctave(D, 4), quarter));
    elements.add(measureLine());
    elements.add(new WrittenNote(fromNameAndOctave(C, 4), half));
    elements.add(measureLine());

    elements.add(new WrittenNote(fromNameAndOctave(G, 4), quarter));
    elements.add(new WrittenNote(fromNameAndOctave(G, 4), quarter));
    elements.add(measureLine());
    elements.add(new WrittenNote(fromNameAndOctave(F, 4), quarter));
    elements.add(new WrittenNote(fromNameAndOctave(F, 4), quarter));
    elements.add(measureLine());
    elements.add(new WrittenNote(fromNameAndOctave(E, 4), quarter));
    elements.add(new WrittenNote(fromNameAndOctave(E, 4), quarter));
    elements.add(measureLine());
    elements.add(new WrittenNote(fromNameAndOctave(D, 4), half));
    elements.add(measureLine());

    elements.add(new WrittenNote(fromNameAndOctave(G, 4), quarter));
    elements.add(new WrittenNote(fromNameAndOctave(G, 4), quarter));
    elements.add(measureLine());
    elements.add(new WrittenNote(fromNameAndOctave(F, 4), quarter));
    elements.add(new WrittenNote(fromNameAndOctave(F, 4), quarter));
    elements.add(measureLine());
    elements.add(new WrittenNote(fromNameAndOctave(E, 4), quarter));
    elements.add(new WrittenNote(fromNameAndOctave(E, 4), quarter));
    elements.add(measureLine());
    elements.add(new WrittenNote(fromNameAndOctave(D, 4), half));
    elements.add(measureLine());

    elements.add(new WrittenNote(fromNameAndOctave(C, 4), quarter));
    elements.add(new WrittenNote(fromNameAndOctave(C, 4), quarter));
    elements.add(measureLine());
    elements.add(new WrittenNote(fromNameAndOctave(G, 4), quarter));
    elements.add(new WrittenNote(fromNameAndOctave(G, 4), quarter));
    elements.add(measureLine());
    elements.add(new WrittenNote(fromNameAndOctave(A, 4), quarter));
    elements.add(new WrittenNote(fromNameAndOctave(A, 4), quarter));
    elements.add(measureLine());
    elements.add(new WrittenNote(fromNameAndOctave(G, 4), half));
    elements.add(measureLine());

    elements.add(new WrittenNote(fromNameAndOctave(F, 4), quarter));
    elements.add(new WrittenNote(fromNameAndOctave(F, 4), quarter));
    elements.add(measureLine());
    elements.add(new WrittenNote(fromNameAndOctave(E, 4), quarter));
    elements.add(new WrittenNote(fromNameAndOctave(E, 4), quarter));
    elements.add(measureLine());
    elements.add(new WrittenNote(fromNameAndOctave(D, 4), quarter));
    elements.add(new WrittenNote(fromNameAndOctave(D, 4), quarter));
    elements.add(measureLine());
    elements.add(new WrittenNote(fromNameAndOctave(C, 4), half));
    elements.add(measureLine());


    StaffSet factory = new StaffSet(100, 100, 800);
    for (Staff s : factory.placeElements(elements)) s.paint(brush);

  }
}