package player;

import hanon.app.controller.music.StaffElement;
import hanon.app.controller.player.sheet.Brush;
import hanon.app.controller.player.staff.Staff;
import hanon.app.controller.player.staff.StaffSet;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.stage.Stage;

import java.util.List;

public class MusicSheet {
  private final List<StaffElement> elements;
  private final Stage stage;

  public MusicSheet(List<StaffElement> elements, Stage stage) {
    this.elements = elements;
    this.stage = stage;
  }

  public void draw() {
    Canvas canvas = new Canvas(1000, 1000);

    Group group = new Group();
    group.getChildren().add(canvas);
    stage.setScene(new Scene(group));
    stage.show();

    Brush brush = new Brush(group, canvas.getGraphicsContext2D());
    StaffSet set = new StaffSet(100, 100, 800);
    for (Staff s : set.placeElements(elements)) s.paint(brush);
  }
}
