package player;

import hanon.app.controller.music.StaffElementSet;
import hanon.app.controller.player.sheet.Brush;
import hanon.app.controller.player.staff.Staff;
import hanon.app.controller.player.staff.StaffSet;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.stage.Stage;

public class MusicSheet {
  private final Stage stage;
  private final StaffElementSet[] sets;

  public MusicSheet(Stage stage, StaffElementSet... sets) {
    this.stage = stage;
    this.sets = sets;
  }

  public void draw() {
    Canvas canvas = new Canvas(1000, 1000);

    Group group = new Group();
    group.getChildren().add(canvas);
    stage.setScene(new Scene(group));
    stage.show();

    Brush brush = new Brush(group, canvas.getGraphicsContext2D());

    int i = 1;
    for (StaffElementSet s : sets) {
      StaffSet set = new StaffSet(s.getClef(), 100, i*90, 100*sets.length, 800);
      for (Staff staff : set.placeElements(s.getElements()))
        staff.paint(brush);
      i++;
    }
  }
}
