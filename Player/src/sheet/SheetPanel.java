package sheet;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.ArcType;
import javafx.stage.Stage;
import notes.NoteImage;
import notes.QuarterNoteImage;

import java.util.ArrayList;
import java.util.List;

public class SheetPanel extends Application {

  public static void main(String[] args) {
    launch(args);
  }

  public static final Paint BACKGROUND_COLOR = Color.WHITE;

  @Override
  public void start(Stage stage) {
    Group root = new Group();
    Canvas canvas = new Canvas(300, 300);
    GraphicsContext g = canvas.getGraphicsContext2D();
    root.getChildren().add(canvas);
    stage.setScene(new Scene(root));
    stage.show();


    List<NoteImage> images = new ArrayList<NoteImage>();
    for (int i = 25; i < 60; i += 5)
      images.add(new QuarterNoteImage(360 - 6 * i, i));

    for (NoteImage i : images) i.draw(g);
  }

  /*
  public static void main(String[] args) {
    JFrame frame = new JFrame("Music");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);
    frame.setSize(new Dimension(400, 400));
    frame.add(new SheetPanel());
  }

  public static final Color BACKGROUND_COLOR = Color.WHITE;

  public SheetPanel() {

  }

  @Override
  public void paintComponent(Graphics g) {
    Graphics2D g2 = (Graphics2D)g;
    g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

    g2.setBackground(BACKGROUND_COLOR);
    g2.clearRect(0, 0, 400, 400);

    java.util.List<NoteImage> images = new ArrayList<NoteImage>();
    for (int i = 25; i < 60; i+=5) {
      images.add(new QuarterNoteImage(360 - 6*i, i));
    }

    for (NoteImage i : images) i.draw(g2);

  }
  */

}

