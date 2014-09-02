package sheet;

import notes.NoteImage;
import notes.QuarterNoteImage;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class SheetPanel extends JPanel {


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

    Staff s = new Staff(25,25,250);
    s.draw(g2);
  }

}

