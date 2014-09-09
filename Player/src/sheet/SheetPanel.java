package sheet;

import image.Clef;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.stage.Stage;
import music.MusicNote;
import music.WrittenNote;

public class SheetPanel extends Application {

  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage stage) {

    System.out.println("Working Directory = " +
            System.getProperty("user.dir"));

    Group group = new Group();
    Canvas canvas = new Canvas(1000, 1000);
    group.getChildren().add(canvas);
    stage.setScene(new Scene(group));
    stage.show();

    Brush brush = new Brush(group, canvas.getGraphicsContext2D());

    MusicNote note1 = WrittenNote.fromString("440.0 half");
    MusicNote note2 = WrittenNote.fromString("440.0 quarter");
    MusicNote note3 = WrittenNote.fromString("440.0 quarter");
    MusicNote note4 = WrittenNote.fromString("440.0 quarter");

    Staff s = new Staff(new Clef(), 25, 25);
    s.addNote(note1.getLength(), note1.getStaffPosition());
    s.addNote(note2.getLength(), note2.getStaffPosition());
    s.addNote(note3.getLength(), note3.getStaffPosition());
    s.addNote(note4.getLength(), note4.getStaffPosition());
    s.draw(brush);
  }
}

