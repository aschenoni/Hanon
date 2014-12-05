package hanon.app.model.player.staff;

import hanon.app.model.player.noteimage.NoteImage;
import hanon.app.model.player.sheet.Brush;
import hanon.app.model.player.sheet.StaffPlaceable;
import hanon.app.model.util.FunctionalList;
import javafx.event.EventHandler;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;

public class DecrescendoImage implements StaffPlaceable {
  private final Line lineUp;
  private final Line lineDown;
  private final Rectangle boundingRectangle;

  public DecrescendoImage(FunctionalList<NoteImage> lastNNotes, int y) {
    int startX = lastNNotes.head().x();
    int endX = lastNNotes.last().x() + 10;
    int startTopY = y + 55;
    int startBottomY = y + 65;
    int endY = y + 60;

    int width = endX - startX;
    int height = startBottomY - startTopY;

    lineUp = new Line(startX, startTopY, endX, endY);
    lineDown = new Line(startX, startBottomY, endX, endY);
    boundingRectangle = new Rectangle(startX, startTopY, width, height);
  }

  @Override
  public void paint(Brush brush) {
    brush.paint(lineUp);
    brush.paint(lineDown);
  }

  public void setOnMousePressed(EventHandler e) {
    boundingRectangle.setOnMousePressed(e);
  }

  public void setOnMouseReleased(EventHandler e) {
    boundingRectangle.setOnMouseReleased(e);
  }
}
