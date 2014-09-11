package player;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.stage.Stage;
import music.*;
import sheet.Brush;
import sheet.StaffPlaceable;
import staff.StaffPlaceableFactory;

import java.util.ArrayList;
import java.util.List;

import static music.GeneralStaffElement.*;

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

    StaffPlaceableFactory factory = new StaffPlaceableFactory(100, 100);

    List<StaffElement> elements = new ArrayList<StaffElement>();
    elements.add(clef());
    elements.add(new TimeSignature(4,4));
    elements.add(note1);
    elements.add(measureLine());
    elements.add(note2);
    elements.add(note3);
    elements.add(measureLine());
    elements.add(note4);
    elements.add(new Chord(note5, note3));
    elements.add(staffLines());
    List<StaffPlaceable> placeables = factory.buildPlaceables(elements);

    for (StaffPlaceable p : placeables) p.paint(brush);;

  }
}