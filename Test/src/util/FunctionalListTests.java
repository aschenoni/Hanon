package util;

import hanon.app.model.util.FunctionalList;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static hanon.app.model.util.FunctionalList.*;
import static org.junit.Assert.*;

public class FunctionalListTests {

  @Test
  public void emptyListShouldReturnEmpty() {
    assertTrue(empty().isEmpty());
  }

  @Test
  public void prependingElementShouldChangeHead() {
    FunctionalList<Integer> list = FunctionalList.<Integer>empty().prepend(5);
    assertEquals(new Integer(5), list.head());
  }

  @Test
  public void testAppending() {
    FunctionalList<Integer> l1 = FunctionalList.<Integer>empty().prepend(6).prepend(7).prepend(8);
    FunctionalList<Integer> l2 = FunctionalList.<Integer>empty().prepend(3).prepend(4).prepend(5);
    FunctionalList<Integer> expected = FunctionalList.<Integer>empty().prepend(3)
                                                                      .prepend(4)
                                                                      .prepend(5)
                                                                      .prepend(6)
                                                                      .prepend(7)
                                                                      .prepend(8);
    assertEquals(expected, l1.append(l2));
  }

  @Test
  public void tailOfOneElementListShouldBeEmptyList() {
    FunctionalList<Integer> list = FunctionalList.<Integer>empty().prepend(5);
    assertEquals(empty(), list.tail());
  }

  @Test
  public void listsOfDifferentTypesShouldNotBeEqual() {
    FunctionalList<Integer> l1 = FunctionalList.<Integer>empty().prepend(5);
    FunctionalList<String> l2 = FunctionalList.<String>empty().prepend("Hello");
    assertNotSame(l1, l2);
  }

  @Test
  public void testReverse() {
    FunctionalList<Integer> l1 = FunctionalList.<Integer>empty().prepend(5).prepend(4).prepend(3);
    FunctionalList<Integer> l2 = FunctionalList.<Integer>empty().prepend(3).prepend(4).prepend(5);
    assertEquals(l1, l2.reverse());
    assertEquals(l2, l1.reverse());
  }

  @Test
  public void testFilter() {
    Integer[] nums = {1,2,3,4,5,6,5,4,3,2,3,4,5,6,7};
    Integer[] expected = {4,5,6,5,4,4,5,6,7};
    assertEquals(fromArray(expected), fromArray(nums).filter(((Integer i) -> i > 3)));
  }

  @Test
  public void testFromList() {
    List<Integer> list = new ArrayList<>();
    list.add(4);
    list.add(5);
    FunctionalList<Integer> expected = FunctionalList.<Integer>empty().prepend(5).prepend(4);
    assertEquals(expected, fromIterable(list));
  }

  @Test
  public void testToArrayList() {
    List<Integer> list = new ArrayList<>();
    list.add(4);
    list.add(5);
    assertEquals(list, fromIterable(list).toArrayList());
  }

  @Test
  public void testBind() {
    Integer[] nums = {3, 4, 5};
    Integer[] expected = {4, 5, 6, 5, 6, 7, 6, 7, 8};
    assertEquals(fromArray(expected), fromArray(nums).bind(this::nextThree));
  }
  public FunctionalList<Integer> nextThree(Integer i) {
    Integer[] nums = {i+1, i+2, i+3};
    return fromArray(nums);
  }

  @Test
  public void testZipWith() {
    Integer[] l1 = {3,4,5};
    Integer[] l2 = {6,7,8,9,10};
    Integer[] expected = {9,11,13};
    assertEquals(fromArray(expected), fromArray(l1).zipWith(
            ((Integer a, Integer b) -> a + b),
            fromArray(l2))
    );
  }

  @Test
  public void testMinimum() {
    Integer[] l1 = {3,4,5,4,2,4,7};
    assertEquals(2, minimum(fromArray(l1)));
  }
  @Test
  public void testMaximum() {
    Integer[] l1 = {3,4,5,4,2,4,7};
    assertEquals(7, maximum(fromArray(l1)));
  }

  @Test
  public void testTakeWhile() {
    Integer[] nums = {3,4,5,4,3};
    Integer[] expected = {3,4};
    assertEquals(fromArray(expected), fromArray(nums).takeWhile((n) -> n < 5));
  }

  @Test
  public void testTails() {
    Integer[] nums = {3, 4, 5};
    Integer[] nums2 = {4, 5};
    Integer[] nums3 = {5};


    FunctionalList<Integer>[] expected = new FunctionalList[]{
            fromArray(nums),
            fromArray(nums2),
            fromArray(nums3),
            FunctionalList.<Integer>empty()
    };
    assertEquals(fromArray(expected), fromArray(nums).tails());
  }

  @Test
  public void testDrop() {
    Integer[] nums = {3, 4, 5};
    Integer[] expected = {4, 5};
    assertEquals(fromArray(expected), fromArray(nums).drop(1));
  }
}
