package player;

import hanon.app.controller.music.StaffElementSet;
import hanon.app.controller.player.sheet.Brush;
import hanon.app.controller.player.staff.Staff;
import hanon.app.controller.player.staff.StaffInfo;
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
      StaffInfo.StaffInfoBuilder b = new StaffInfo.StaffInfoBuilder()
              .clef(s.getClef())
              .x(100)
              .y(i*90)
              .width(800);

      if (i == 1 && sets.length == 2) {
        b.measureLineHeight(130);
      }


      StaffSet set = new StaffSet(b.build(), 100*sets.length, s.getElements());


      for (Staff staff : set.getStaffs())
        staff.paint(brush);
      i++;
    }
  }
}
