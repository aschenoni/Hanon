package hanon.app.model.player.staff;

import hanon.app.model.music.*;
import hanon.app.model.util.FunctionalList;

import java.util.List;

import static hanon.app.model.util.FunctionalList.*;

public class StaffSpacer {

  private final int width;
  private final FunctionalList<StaffElement> elements;

  public StaffSpacer(int width, List<StaffElement> elements) {
    this.width = width;
    this.elements = fromIterable(elements);
  }

  /**
   * Returns the list of elements given to the spacer that will not fit on one
   * line.
   */
  public FunctionalList<StaffElement> unallocatedElements() {
    return elements.drop(allocatedElements().size());
  }

  /**
   * Returns the list of elements given to the spacer that will fit on one
   * line. This is done by finding the closest measure line to the width
   * and then moving everything else before this line to fit.
   */
  public FunctionalList<StaffSpacedElement> allocatedElements() {
    FunctionalList<StaffSpacedElement> unallocated = elementsToBeReallocated();
    double diff = ((double)width - unallocated.last().getX()) / unallocated.size();
    return unallocated.inits().tail().tail().map((list) ->
            list.last().moveX((int) (diff * list.size()))).prepend(unallocated.head());
  }

  /**
   * Returns the list of elements that will have their spacings reallocated.
   */
  public FunctionalList<StaffSpacedElement> elementsToBeReallocated() {
    return spacedElements().takeWhile((e) ->
            e.getX() <= closestMeasureToWidth().getX());
  }

  /**
   * Returns the Measure Line which is closest to the width of the staff.
   */
  public StaffSpacedElement closestMeasureToWidth() {
    FunctionalList<StaffSpacedElement> spacings = spacedElements();
    FunctionalList<StaffSpacedElement> lines = spacings.filter(StaffSpacedElement::isStaffLine);
    return lines.foldl1((a, b) ->            distanceFromWidth(a.getX()) < distanceFromWidth(b.getX()) ? a : b);
  }

  private FunctionalList<StaffSpacedElement> spacedElements() {
    return getUnadjustedPositions().zipWith((x, e) ->
            new StaffSpacedElement(e, x), elements);
  }

  private int distanceFromWidth(int x) {
    return Math.abs(width - x);
  }

  /**
   * Returns a list of numbers which represents the unadjusted absolute x
   * location of all the elements given to the spacer.
   */
  public FunctionalList<Integer> getUnadjustedPositions() {
    return getSpacings().inits().map((FunctionalList<Integer> init) ->
            init.foldr(((Integer a, Integer b) -> a + b), 0));
  }

  /**
   * Returns a list of numbers which represents the unadjusted amount of
   * space required for each element given to the spacer.
   */
  public FunctionalList<Integer> getSpacings() {
    return elements.map(Spacing::getSpacing);
  }
}
