package hanon.app.model.player.staff;

import hanon.app.model.player.noteimage.NoteBody;
import hanon.app.model.player.noteimage.NoteImage;
import hanon.app.model.player.noteimage.NoteStem;
import hanon.app.model.player.sheet.Brush;
import hanon.app.model.player.sheet.StaffPlaceable;
import hanon.app.model.util.Pair;
import javafx.scene.paint.Color;
import javafx.scene.shape.CubicCurve;
import javafx.scene.shape.StrokeLineCap;

public class TieImage implements StaffPlaceable {
  private final CubicCurve curve = new CubicCurve();

  public TieImage(Pair<NoteImage,NoteImage> notes) {
    int leftX = notes.first().x() + NoteBody.WIDTH;
    int rightX = notes.second().x();
    int middleX = (leftX + rightX) / 2;
    int leftControlX = (leftX + middleX) / 2;
    int rightControlX = (rightX + middleX) / 2;

    curve.setStartX(leftX);
    curve.setEndX(rightX);
    curve.setControlX1(leftControlX);
    curve.setControlX2(rightControlX);

    if (notes.first().goesUp()) {
      curve.setStartY(notes.first().y() + 5*NoteBody.HEIGHT/4);
      curve.setEndY(notes.second().y() + 5*NoteBody.HEIGHT/4);
      curve.setControlY1(notes.second().y() + 3*NoteBody.HEIGHT);
      curve.setControlY2(notes.first().y() + 3*NoteBody.HEIGHT);
    }
    else {
      curve.setStartY(notes.first().y() - NoteBody.HEIGHT/4);
      curve.setEndY(notes.second().y() - NoteBody.HEIGHT/4);
      curve.setControlY1(notes.second().y() - 2*NoteBody.HEIGHT);
      curve.setControlY2(notes.first().y() - 2*NoteBody.HEIGHT);
    }

    curve.setStroke(Color.BLACK);
    curve.setStrokeWidth(1);
    curve.setStrokeLineCap(StrokeLineCap.ROUND);
  }

  @Override
  public void paint(Brush brush) {
    brush = brush.withColor(null);
    brush.paint(curve);
  }
}
