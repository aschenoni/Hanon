package hanon.app.model.player.sheet;

import java.util.ArrayList;
import java.util.List;

import hanon.app.model.music.StaffElementSet;
import hanon.app.model.player.noteimage.NoteImage;
import hanon.app.model.player.staff.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.canvas.Canvas;
import javafx.scene.layout.AnchorPane;

public class MusicSheet extends AnchorPane {
	
	//List of staff elements on the music sheet. The list May Change if notes are added or deleted
  private final ObservableList<StaffElementSet> sets;
  private Brush brush;
  private List<StaffSet> staffSets = new ArrayList<>();

  public MusicSheet(ObservableList<StaffElementSet> sets) {
    this.sets = sets;
  }
  
  public MusicSheet(StaffElementSet set){
    List<StaffElementSet> list = new ArrayList<>();
    list.add(set);
    this.sets = FXCollections.observableArrayList(list);
  }

  public Brush getBrush() {
    return brush;
  }

  public void setup(int width, int height) {
    Canvas canvas = new Canvas(width, height);
    Group group = new Group();
    group.getChildren().add(canvas);
    this.getChildren().add(group);
    brush = new Brush(group);

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
      staffSets.add(set);
      i++;
    }
  }

	/**
	 * Draws the music sheet, rendering the musical representation of each note
	 */
	public void draw() {
    for (StaffSet set : staffSets)
      for (Staff staff : set.getStaffs())
        staff.paint(brush);
	}

  public List<NoteImage> getAllNoteImages() {
    List<NoteImage> images = new ArrayList<>();
    for (StaffSet set : staffSets) {
      for (Staff staff : set.getStaffs()) {
        for (StaffPlaceable p : staff.getPlaceableElements()) {
          if (p instanceof NoteImage) {
            images.add((NoteImage)p);
          }
        }
      }
    }
    return images;
  }
	
	public ObservableList<StaffElementSet> getSets(){
		return this.sets;
	}

  public Iterable<StaffPlaceable> getAllCrescendos() {
    List<StaffPlaceable> images = new ArrayList<>();
    for (StaffSet set : staffSets)
      for (Staff staff : set.getStaffs())
        for (StaffPlaceable p : staff.getPlaceableElements())
          if (p instanceof CrescendoImage || p instanceof DecrescendoImage)
            images.add(p);
    return images;
  }
}
