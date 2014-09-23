package hanon.app.model.player.component;

import hanon.app.model.player.sheet.Brush;
import hanon.app.model.player.staff.NoteComponent;
import javafx.scene.shape.Rectangle;

public class LedgerLine implements NoteComponent {
  private final Rectangle rectangle;
  private final int staffPosition;

  public LedgerLine(int x, int y, int staffPosition) {
    this.staffPosition = staffPosition;
    rectangle = new Rectangle(x - 3, y + NoteBody.HEIGHT/2, NoteBody.WIDTH + 6, 1);
  }

  @Override
  public void paint(Brush brush) {
    if (staffPosition < -2 || staffPosition > 9) brush.paint(rectangle);
  }
}
