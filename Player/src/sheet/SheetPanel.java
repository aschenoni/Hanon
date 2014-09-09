package sheet;

import image.Clef;
import image.TimeSignatureImage;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.stage.Stage;
import music.MusicNote;
import music.TimeSignature;
import music.WrittenNote;
import note.NoteImageFactory;

public class SheetPanel extends Application {

  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage stage) {
    Group group = new Group();
    Canvas canvas = new Canvas(1000, 1000);
    group.getChildren().add(canvas);
    stage.setScene(new Scene(group));
    stage.show();

    Brush brush = new Brush(group, canvas.getGraphicsContext2D());

    MusicNote note1 = WrittenNote.fromString("440.0 whole");
    MusicNote note2 = WrittenNote.fromString("470.0 half");
    MusicNote note3 = WrittenNote.fromString("490.0 half");
    MusicNote note4 = WrittenNote.fromString("440.0 quarter");

    Staff s = new Staff(100, 100);
    NoteImageFactory factory = new NoteImageFactory(s.getY());

    s.addElement(new Clef(s.getCurrentX(), s.getY()-20));
    s.addElement(new TimeSignatureImage(new TimeSignature(4, 4), s.getCurrentX(), s.getY()));
    s.addElement(factory.buildImage(note1, s.getCurrentX()));
    s.addMeasureLine();
    s.addElement(factory.buildImage(note2, s.getCurrentX()));
    s.addElement(factory.buildImage(note3, s.getCurrentX()));
    s.addMeasureLine();
    s.addElement(factory.buildImage(note4, s.getCurrentX()));
    s.draw(brush);
  }
}

