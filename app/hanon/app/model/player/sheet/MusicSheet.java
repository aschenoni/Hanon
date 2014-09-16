package hanon.app.model.player.sheet;

import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.canvas.Canvas;
import javafx.scene.layout.AnchorPane;
import hanon.app.model.player.staff.Staff;
import hanon.app.model.music.StaffElement;
import hanon.app.model.player.staff.StaffSet;


public class MusicSheet extends AnchorPane{
	
	//List of staff elements on the music sheet. The list May Change if notes are added or deleted
	private final ObservableList<StaffElement> elements;
	
	
	public MusicSheet(ObservableList<StaffElement> elements)
	{
		this.elements = elements;
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
		StaffSet set = new StaffSet(100, 100, 800);
		for(Staff s : set.placeElements(elements)) s.paint(brush);
	}
}
