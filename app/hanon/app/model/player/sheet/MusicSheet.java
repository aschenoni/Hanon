package hanon.app.model.player.sheet;

import hanon.app.model.music.StaffElementSet;
import hanon.app.model.player.staff.StaffInfo;
import hanon.app.model.player.staff.Staff;
import hanon.app.model.player.staff.StaffSet;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.canvas.Canvas;
import javafx.scene.layout.AnchorPane;

public class MusicSheet extends AnchorPane{
	
	//List of staff elements on the music sheet. The list May Change if notes are added or deleted
  private final ObservableList<StaffElementSet> sets;

  public MusicSheet(ObservableList<StaffElementSet> sets) {
    this.sets = sets;
  }
	/**
	 * Draws the music sheet, rendering the musical representation of each note
	 * 
	 * @param width - width of the canvas (eventually should have this automatically resized)
	 * @param height - height of the canvas (eventually should have this automatically resized)
	 */
	public void draw(double width, double height) {
		Canvas canvas = new Canvas(width, height);
	
		Group group = new Group();
		group.getChildren().add(canvas);
		
		
		this.getChildren().add(group);
		
		//Not sure I like this required group here, it seems like we are adding an unnecessary middle layer)
		Brush brush = new Brush(group, canvas.getGraphicsContext2D());




    int i = 1;
    for (StaffElementSet s : sets) {
      StaffInfo.StaffInfoBuilder b = new StaffInfo.StaffInfoBuilder()
              .clef(s.getClef())
              .x(100)
              .y(i*90)
              .width(800);

      if (i == 1 && sets.size() == 2) {
        b.measureLineHeight(130);
      }


      StaffSet set = new StaffSet(b.build(), 100*sets.size(), s.getElements());


      for (Staff staff : set.getStaffs())
        staff.paint(brush);
      i++;
    }


	}
}