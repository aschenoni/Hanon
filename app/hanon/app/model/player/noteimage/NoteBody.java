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

  private boolean evaluationShowing = false;

  public NoteBody(int x, int y, int angle) {
    ellipse = RotatedEllipse.buildEllipse(x, y, WIDTH, HEIGHT, angle);
    ellipse.setOnMousePressed(e -> {
      if (!evaluationShowing) {
        try {
          if (note.getEvaluation() != null) {
            note.getEvaluation().showStatistics(x, y);
          }
        } catch (IOException e1) {
          e1.printStackTrace();
        }
      }
      evaluationShowing = true;
    });
    ellipse.setOnMouseReleased(e -> {
      if (note.getEvaluation() != null) {
        note.getEvaluation().hideStatistics();
        evaluationShowing = false;
      }
    });
  }

  public void setMusicNote(MusicNote note) {
    this.note = note;
  }

  public void paint(Brush brush) {
    brush.paint(ellipse);
  }
}
