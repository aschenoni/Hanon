package hanon.app.model.player.staff;

import hanon.app.model.player.noteimage.NoteBody;
import hanon.app.model.player.noteimage.NoteImage;
import hanon.app.model.player.sheet.Brush;
import hanon.app.model.player.sheet.StaffPlaceable;
import hanon.app.model.util.FunctionalList;
import javafx.scene.paint.Color;
import javafx.scene.shape.CubicCurve;
import javafx.scene.shape.StrokeLineCap;

public class SlurImage implements StaffPlaceable {
  private final CubicCurve curve = new CubicCurve();

  public SlurImage(FunctionalList<NoteImage> notes) {
    int leftX = notes.head().x() + NoteBody.WIDTH;
    int rightX = notes.last().x();
    int middleX = (leftX + rightX) / 2;
    int leftControlX = (leftX + middleX) / 2;
    int rightControlX = (rightX + middleX) / 2;

    curve.setStartX(leftX);
    curve.setEndX(rightX);
    curve.setControlX1(leftControlX);
    curve.setControlX2(rightControlX);


    if (anyGoDown(notes)) {
      int highest = (int) FunctionalList.minimum(notes.map(NoteImage::top));
      curve.setStartY(notes.head().top() - NoteBody.HEIGHT/4);
      curve.setEndY(notes.last().top() - NoteBody.HEIGHT/4);
      curve.setControlY1(highest - NoteBody.HEIGHT);
      curve.setControlY2(highest - NoteBody.HEIGHT);
    }
    else {
      int lowest = (int) FunctionalList.maximum(notes.map(NoteImage::bottom));
      curve.setStartY(notes.head().bottom() + NoteBody.HEIGHT/4);
      curve.setEndY(notes.last().bottom() + NoteBody.HEIGHT/4);
      curve.setControlY1(lowest + NoteBody.HEIGHT);
      curve.setControlY2(lowest + NoteBody.HEIGHT);
    }

    curve.setStroke(Color.BLACK);
    curve.setStrokeWidth(1);
    curve.setStrokeLineCap(StrokeLineCap.ROUND);
  }

  private boolean anyGoDown(FunctionalList<NoteImage> notes) {
    return !notes.all(NoteImage::goesUp);
  }


  @Override
  public void paint(Brush brush) {
    brush = brush.withColor(null);
    brush.paint(curve);
  }
}
