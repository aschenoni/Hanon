package hanon.app.model.player.staff;

import hanon.app.model.music.*;
import hanon.app.model.player.noteimage.NoteImage;
import hanon.app.model.player.noteimage.NoteImageFactory;
import hanon.app.model.player.noteimage.NoteStem;
import hanon.app.model.player.sheet.Brush;
import hanon.app.model.player.sheet.StaffPlaceable;
import hanon.app.model.util.FunctionalList;

import java.util.ArrayList;
import java.util.List;

public class Staff {
  public static final int LINE_GAP = 10;

  private final StaffInfo info;
  private final StaffPlaceableFactory factory;
  private final List<StaffPlaceable> placeables;

  public Staff(StaffInfo info, List<StaffElement> elements) {
    this.info = info;
    factory = new StaffPlaceableFactory(info);

    FunctionalList<StaffSpacedElement> spacings = new StaffSpacer(info.getWidth(), elements).allocatedElements();
    placeables = spacings.map(this::placeElement)
            .prepend(new MeasureLine(info.getX(), info.getY(), info.getMeasureLineHeight()))
            .prepend(new StaffLines(info.getX(), info.getY(), info.getWidth())).toArrayList();
  }

  public List<StaffPlaceable> getPlaceableElements() {
    return placeables;
  }

  private StaffPlaceable placeElement(StaffSpacedElement e) {
    int x = e.getX() + info.getX();
    return factory.placeElement(x, e.getElement());
  }


  public void paint(Brush brush) {
    for (StaffPlaceable e : placeables) e.paint(brush);
  }
}
