package hanon.app.model.player.staff;

import hanon.app.model.player.noteimage.NoteImage;
import hanon.app.model.player.sheet.Brush;
import hanon.app.model.player.sheet.StaffPlaceable;
import hanon.app.model.util.FunctionalList;
import javafx.event.EventHandler;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;

public class DecrescendoImage implements StaffPlaceable {
  private final Line lineUp;
  private final Line lineDown;
  private final Rectangle boundingRectangle;
  private int x;
  private int y;

  public DecrescendoImage(FunctionalList<NoteImage> lastNNotes, int y) {
    x = lastNNotes.head().x();
    int endX = lastNNotes.last().x() + 10;
    this.y = y + 55;
    int startBottomY = y + 65;
    int endY = y + 60;

    int width = endX - x;
    int height = startBottomY - this.y;

    lineUp = new Line(x, this.y, endX, endY);
    lineDown = new Line(x, startBottomY, endX, endY);
    boundingRectangle = new Rectangle(x, this.y, width, height);
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

  public int getX() {
    return x;
  }

  public int getY() {
    return y;
  }
}
