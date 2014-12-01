package hanon.app.model.player.staff;

import hanon.app.model.player.noteimage.NoteImage;
import hanon.app.model.player.sheet.Brush;
import hanon.app.model.player.sheet.StaffPlaceable;
import hanon.app.model.util.FunctionalList;
import javafx.scene.shape.Line;

public class CrescendoImage implements StaffPlaceable {
  private final FunctionalList<NoteImage> lastNNotes;
  private final int x;
  private final int y;

  public CrescendoImage(FunctionalList<NoteImage> lastNNotes, int x, int y) {
    this.lastNNotes = lastNNotes;
    this.x = x;
    this.y = y;
  }

  @Override
  public void paint(Brush brush) {
    int startX = lastNNotes.head().x();
    int endX = lastNNotes.last().x() + 10;
    int startY = y + 60;
    int endTopY = y + 55;
    int endBottomY = y + 65;

    Line lineUp = new Line(startX, startY, endX, endTopY);
    Line lineDown = new Line(startX, startY, endX, endBottomY);
    brush.paint(lineUp);
    brush.paint(lineDown);
  }
}
