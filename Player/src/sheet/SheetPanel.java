package sheet;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;
import music.NoteLength;

public class SheetPanel extends Application {

  public static void main(String[] args) {
    launch(args);
  }

  public static final Paint BACKGROUND_COLOR = Color.WHITE;

  @Override
  public void start(Stage stage) {
    Group root = new Group();
    Canvas canvas = new Canvas(500, 300);
    GraphicsContext g = canvas.getGraphicsContext2D();
    root.getChildren().add(canvas);
    stage.setScene(new Scene(root));
    stage.show();

    Staff s = new Staff(25, 25);
    for (int i = 0; i < 10; i ++)
      s.addNote(NoteLength.half, 450 - 60 * i, i);
    s.draw(g, root);
  }
}

