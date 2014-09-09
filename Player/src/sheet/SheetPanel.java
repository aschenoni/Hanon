package sheet;

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
    Group group = new Group();
    Canvas canvas = new Canvas(500, 300);
    group.getChildren().add(canvas);
    stage.setScene(new Scene(group));
    stage.show();

    Brush brush = new Brush(group);

    MusicNote note = WrittenNote.fromString("440.0 half");

    Staff s = new Staff(25, 25);
    s.addNote(note.getLength(), 50, note.getStaffPosition());
    s.draw(brush);
  }
}

