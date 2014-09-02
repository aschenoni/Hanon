package sheet;

import notes.HalfNote;
import notes.QuarterNote;
import notes.WholeNote;

import javax.swing.*;
import java.awt.*;

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

    QuarterNote q = new QuarterNote(25, 25);
    q.draw(g2);

    HalfNote h = new HalfNote(45, 35);
    h.draw(g2);

    WholeNote w = new WholeNote(65, 45);
    w.draw(g2);

    Staff s = new Staff(25,25,250);
    s.draw(g2);
  }

}

