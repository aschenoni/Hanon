package components;

import javafx.scene.Group;
import javafx.scene.canvas.GraphicsContext;
import sheet.Brush;

public interface NoteComponent {
  void draw(Brush brush);
}
