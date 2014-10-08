package util;

import hanon.app.model.util.Maybe;
import org.junit.Test;

import static hanon.app.model.util.Maybe.*;
import static org.junit.Assert.*;

public class MaybeTests {

  @Test
  public void testNothingFmap() {
    Maybe<Integer> maybe = nothing();
    assertTrue(maybe.fmap(this::times2).isEmpty());
  }
  public int times2(Integer in) {
    return 2*in;
  }

  @Test
  public void testBind() {
    Integer i = 2;
    Maybe<Integer> i2 = Maybe.pure(i)
            .bind(this::safeTimes2)
            .bind(this::safeTimes2)
            .bind(this::safeTimes2)
            .bind(this::safeTimes2)
            .bind(this::safeTimes2)
            .bind(this::safeTimes2);
    assertEquals(maybe(128), i2);
    assertEquals(nothing(), i2.bind(this::safeTimes2));
  }
  public Maybe<Integer> safeTimes2(Integer i) {
    if (i < 100) return maybe(i * 2);
    else return nothing();
  }

}
