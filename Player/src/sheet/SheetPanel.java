package sheet;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;
import music.MusicNote;
import music.WrittenNote;

public class SheetPanel extends Application {

  public static void main(String[] args) {
    launch(args);
  }

  public static final Paint BACKGROUND_COLOR = Color.WHITE;

  @Override
  public void start(Stage stage) {
    Group root = new Group();
    Canvas canvas = new Canvas(500, 300);

    root.getChildren().add(canvas);
    stage.setScene(new Scene(root));
    stage.show();

    Brush brush = new Brush(root);

    MusicNote note = WrittenNote.fromString("440.0 quarter");

    Staff s = new Staff(25, 25);
    s.addNote(note.getLength(), 50, note.getStaffPosition());
    s.draw(brush);
  }
}

