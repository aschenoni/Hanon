package hanon.app.model.player.staff;

import hanon.app.model.player.noteimage.NoteImage;
import hanon.app.model.player.sheet.Brush;
import hanon.app.model.player.sheet.StaffPlaceable;
import hanon.app.model.util.FunctionalList;
import javafx.event.EventHandler;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;

public class CrescendoImage implements StaffPlaceable {
  private final Line lineUp;
  private final Line lineDown;
  private final Rectangle boundingRectangle;

  public CrescendoImage(FunctionalList<NoteImage> lastNNotes, int y) {
    int startX = lastNNotes.head().x();
    int endX = lastNNotes.last().x() + 10;
    int startY = y + 60;
    int endTopY = y + 55;
    int endBottomY = y + 65;

    int width = endX - startX;
    int height = endBottomY - endTopY;

    lineUp = new Line(startX, startY, endX, endTopY);
    lineDown = new Line(startX, startY, endX, endBottomY);
    boundingRectangle = new Rectangle(startX, endTopY, width, height);
  }

  @Override
  public void paint(Brush brush) {
    brush.paint(lineUp);
    brush.paint(lineDown);
    brush.withColor(Color.TRANSPARENT).paint(boundingRectangle);
  }

  public void setOnMousePressed(EventHandler e) {
    boundingRectangle.setOnMousePressed(e);
  }

  public void setOnMouseReleased(EventHandler e) {
    boundingRectangle.setOnMouseReleased(e);
  }
}
