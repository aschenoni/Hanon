package components;

import javafx.scene.Group;
import javafx.scene.canvas.GraphicsContext;

public interface NoteComponent {
  void draw(GraphicsContext g2, Group root);
}
