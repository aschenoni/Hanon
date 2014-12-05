package hanon.app.model.player.noteimage;

import hanon.app.MainDriver;
import hanon.app.model.music.MusicNote;
import hanon.app.model.player.sheet.Brush;
import hanon.app.model.player.staff.Staff;
import javafx.scene.shape.Ellipse;

import java.io.IOException;


public class NoteBody implements NoteComponent {
  public static final int HEIGHT = Staff.LINE_GAP-1;
  public static final int WIDTH = (int) (1.6* HEIGHT);

  private final Ellipse ellipse;
  private MusicNote note;

  public NoteBody(int x, int y, int angle) {
    ellipse = RotatedEllipse.buildEllipse(x, y, WIDTH, HEIGHT, angle);
    ellipse.setOnMousePressed(e -> {
      try {
        note.getEvaluation().showStatistics(x, y);
      } catch (IOException e1) {
        e1.printStackTrace();
      }
    });
    ellipse.setOnMouseReleased(e -> note.getEvaluation().hideStatistics());
  }

  public void setMusicNote(MusicNote note) {
    this.note = note;
  }

  public void paint(Brush brush) {
    brush.paint(ellipse);
  }
}
