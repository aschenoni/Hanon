package hanon.app.model.player.staff;

import hanon.app.model.player.noteimage.NoteImage;
import hanon.app.model.player.sheet.Brush;
import hanon.app.model.player.sheet.StaffPlaceable;
import hanon.app.model.util.FunctionalList;
import javafx.scene.shape.Line;

public class CrescendoImage implements StaffPlaceable {
  private final Line lineUp;
  private final Line lineDown;

  public CrescendoImage(FunctionalList<NoteImage> lastNNotes, int x, int y) {
    int startX = lastNNotes.head().x();
    int endX = lastNNotes.last().x() + 10;
    int startY = y + 60;
    int endTopY = y + 55;
    int endBottomY = y + 65;

    lineUp = new Line(startX, startY, endX, endTopY);
    lineDown = new Line(startX, startY, endX, endBottomY);
  }

  @Override
  public void paint(Brush brush) {
    brush.paint(lineUp);
    brush.paint(lineDown);
  }
}
