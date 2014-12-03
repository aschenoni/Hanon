package hanon.app.model.player.staff;

import hanon.app.model.player.noteimage.NoteImage;
import hanon.app.model.player.sheet.Brush;
import hanon.app.model.player.sheet.StaffPlaceable;
import hanon.app.model.util.FunctionalList;
import javafx.scene.shape.Line;

public class DecrescendoImage implements StaffPlaceable {
  private final Line lineUp;
  private final Line lineDown;

  public DecrescendoImage(FunctionalList<NoteImage> lastNNotes, int y) {
    int startX = lastNNotes.head().x();
    int endX = lastNNotes.last().x() + 10;
    int startTopY = y + 55;
    int startBottomY = y + 65;
    int endY = y + 60;

    lineUp = new Line(startX, startTopY, endX, endY);
    lineDown = new Line(startX, startBottomY, endX, endY);
  }

  @Override
  public void paint(Brush brush) {
    brush.paint(lineUp);
    brush.paint(lineDown);
  }
}
