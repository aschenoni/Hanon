package image;

import javafx.scene.image.Image;
import javafx.scene.text.Text;
import music.NoteLength;
import music.TimeSignature;
import sheet.Brush;

import java.io.File;

public class TimeSignatureImage {
  private static final File TIME_2 = new File("Player\\res\\images\\Time2.png");
  private static final File TIME_3 = new File("Player\\res\\images\\Time3.png");
  private static final File TIME_4 = new File("Player\\res\\images\\Time4.png");
  private static final File TIME_8 = new File("Player\\res\\images\\Time8.png");

  private final TimeSignature signature;
  private final Image beatsPerMeasureImage;
  private final Image whichGetsBeatImage;

  public TimeSignatureImage(TimeSignature signature) {
    this.signature = signature;
    this.beatsPerMeasureImage = imageFromInt(signature.getBeatsPerMeasure());
    this.whichGetsBeatImage   = imageFromInt(signature.getWhichGetsBeat());
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

  private class NoSuchTimeException extends RuntimeException {  }

  public void draw(Brush brush, int x, int y) {
    brush.paint(beatsPerMeasureImage, x+50, y);
    brush.paint(whichGetsBeatImage, x+50, y + 20);
  }

  public void addNote(NoteLength length) {
    signature.addNote(length);
  }

  public boolean needsNewMeasure() {
    return signature.needsNewMeasure();
  }
}
