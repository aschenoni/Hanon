package player;

import hanon.app.controller.composer.record.WrittenNote;
import hanon.app.controller.music.Chord;
import hanon.app.controller.music.MusicNote;
import hanon.app.controller.music.StaffElement;
import hanon.app.controller.music.TimeSignature;
import hanon.app.controller.player.sheet.Brush;
import hanon.app.controller.player.sheet.StaffPlaceable;
import hanon.app.controller.player.staff.Staff;
import hanon.app.controller.player.staff.StaffSet;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.stage.Stage;
import music.*;

import java.util.ArrayList;
import java.util.List;

import static hanon.app.controller.music.GeneralStaffElement.*;

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

    StaffSet factory = new StaffSet(100, 100, 400);

    List<StaffElement> elements = new ArrayList<StaffElement>();
    elements.add(new TimeSignature(4,4));
    elements.add(note1);
    elements.add(measureLine());
    elements.add(note2);
    elements.add(note3);
    elements.add(measureLine());
    elements.add(note4);
    elements.add(new Chord(note5, note3));
    elements.add(staffLines());

    for (Staff s : factory.placeElements(elements)) s.paint(brush);

  }
}