package staff;

import javafx.scene.image.Image;
import music.TimeSignature;
import sheet.Brush;
import sheet.StaffPlaceable;

import java.io.File;

class TimeSignatureImage implements StaffPlaceable {
  private static final File TIME_2 = new File("Player\\res\\images\\Time2.png");
  private static final File TIME_3 = new File("Player\\res\\images\\Time3.png");
  private static final File TIME_4 = new File("Player\\res\\images\\Time4.png");
  private static final File TIME_8 = new File("Player\\res\\images\\Time8.png");

  private final Image beatsPerMeasureImage;
  private final Image whichGetsBeatImage;
  private final int x;
  private final int y;

  public TimeSignatureImage(TimeSignature signature, int x, int y) {
    this.beatsPerMeasureImage = imageFromInt(signature.getBeatsPerMeasure());
    this.whichGetsBeatImage   = imageFromInt(signature.getWhichGetsBeat());
    this.x = x;
    this.y = y;
  }

  private Image imageFromInt(int i) {
    return new Image(fileFromInt(i).toURI().toString(), 20, 20, true, true);
  }

  private File fileFromInt(int i) {
    switch (i) {
      case 2:  return TIME_2;
      case 3:  return TIME_3;
      case 4:  return TIME_4;
      case 8:  return TIME_8;
      default: throw new NoSuchTimeException();
    }
  }

  @Override
  public void paint(Brush brush) {
    brush.paint(beatsPerMeasureImage, x, y);
    brush.paint(whichGetsBeatImage, x, y + 20);
  }

  @Override
  public int getSpacing() {
    return 50;
  }

  private class NoSuchTimeException extends RuntimeException {  }
}
