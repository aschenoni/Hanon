package sheet;

import image.Clef;
import image.TimeSignatureImage;
import javafx.scene.shape.Rectangle;
import note.NoteImage;
import note.NoteImageFactory;

import java.util.ArrayList;
import java.util.List;

public class Staff {
  public static final int LINE_GAP = 10;

  private final int x;
  private final int y;
  private int currentX;

  private final List<StaffPlaceable> elements = new ArrayList<StaffPlaceable>();
  private final List<Rectangle> measureEnds = new ArrayList<Rectangle>();
  private final Clef clef;
  private final TimeSignatureImage timeSignature;

  public Staff(Clef clef, TimeSignatureImage timeSignature, int x, int y) {
    this.clef = clef;
    this.timeSignature = timeSignature;
    this.x = x;
    this.y = y;
    currentX = x+100;

  }

  public void draw(Brush brush) {
    clef.draw(brush, x, y-20);
    timeSignature.draw(brush, x, y);

    for (StaffPlaceable e : elements) { e.paint(brush); }
    for (Rectangle r : measureEnds) { brush.paint(r); }
    for (int i = 0; i < 5; i++) {
      new StaffLine(x, y + LINE_GAP * i, 800).paint(brush);
    }
  }

  /**
   * @param line The line is the position on the staff where the note should
   *             lie. The top space is 0, and the line below it is 1, etc. To
   *             go above the line, use negative values.
   */
  public void addElement(StaffPlaceable s) {
    elements.add(s);
    currentX += s.getSpacing();
  }

  public int getY() {
    return y;
  }

  public int getCurrentX() {
    return currentX;
  }

  public void addMeasureLine() {
    addElement(new MeasureLine(currentX, y, 4*LINE_GAP));
  }
}

class StaffLine implements StaffPlaceable {
  private final Rectangle rectangle;

  public StaffLine(int x, int y, int width) {
    rectangle = new Rectangle(x, y, width, 1);
  }

  @Override
  public void paint(Brush brush) {
    brush.paint(rectangle);
  }

  @Override
  public int getSpacing() {
    return 0;
  }
}

class MeasureLine implements StaffPlaceable {
  private final Rectangle rectangle;

  public MeasureLine(int x, int y, int height) {
    rectangle = new Rectangle(x, y, 1, height);
  }

  @Override
  public void paint(Brush brush) {
    brush.paint(rectangle);
  }

  @Override
  public int getSpacing() {
    return 30;
  }
}