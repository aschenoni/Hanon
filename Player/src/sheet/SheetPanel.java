package sheet;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.stage.Stage;
import music.MusicNote;
import music.WrittenNote;
import staff.StaffPlaceableFactory;

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

    MusicNote note1 = WrittenNote.fromString("440.0 whole");
    MusicNote note2 = WrittenNote.fromString("470.0 half");
    MusicNote note3 = WrittenNote.fromString("510.0 half");
    MusicNote note4 = WrittenNote.fromString("440.0 quarter");
    MusicNote note5 = WrittenNote.fromString("440.0 half");

    Staff s = new Staff(100);
    StaffPlaceableFactory factory = new StaffPlaceableFactory(100, 100);

    s.addElement(factory.buildClef());
    s.addElement(factory.buildTimeSignature(4, 4));
    s.addElement(factory.buildNote(note1));
    s.addElement(factory.buildMeasureLine());
    s.addElement(factory.buildNote(note2));
    s.addElement(factory.buildNote(note3));
    s.addElement(factory.buildMeasureLine());
    s.addElement(factory.buildNote(note4));
    s.addElement(factory.buildChord(note5, note3));
    s.addElement(factory.buildStaffLines(1000));
    s.paint(brush);
  }
}

