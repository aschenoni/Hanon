package hanon.app.controller.player.image;

import hanon.app.controller.player.sheet.Brush;
import javafx.scene.image.Image;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import java.io.File;

public class TimeSignature {
  private static final File TIME_2 = new File("Player\\res\\images\\Time2.png");
  private static final File TIME_3 = new File("Player\\res\\images\\Time3.png");
  private static final File TIME_4 = new File("Player\\res\\images\\Time4.png");
  private static final File TIME_8 = new File("Player\\res\\images\\Time8.png");

  public static TimeSignature fromInts(int beatsPerMeasure, int whichGetsBeat) {
    return new TimeSignature(imageFromInt(beatsPerMeasure), imageFromInt(whichGetsBeat));
  }

  private static Image imageFromInt(int i) {
    return new Image(fileFromInt(i).toURI().toString(), 20, 20, true, true);
  }

  private static File fileFromInt(int i) {
    switch (i) {
      case 2:  return TIME_2;
      case 3:  return TIME_3;
      case 4:  return TIME_4;
      case 8:  return TIME_8;
      default: throw new NoSuchTimeException();
    }
  }

  private static class NoSuchTimeException extends RuntimeException {  }


  private final Image beatsPerMeasure;
  private final Image whichGetsBeat;

  private TimeSignature(Image beatsPerMeasure, Image whichGetsBeat) {
    this.beatsPerMeasure = beatsPerMeasure;
    this.whichGetsBeat = whichGetsBeat;
  }

  public void draw(Brush brush, int x, int y) {
    Text text = new Text("" + x);
    brush.paint(beatsPerMeasure, x+50, y);
    brush.paint(whichGetsBeat, x+50, y + 20);
  }
}
