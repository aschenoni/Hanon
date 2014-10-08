package hanon.app.model.util;

import java.util.function.Function;

public class Maybe<A> implements Monad<A> {
  private final A data;
  private final boolean isEmpty;

  public static <A> Maybe<A> maybe(A a) {
    return new Maybe<A>(a, false);
  }

  public static <A> Maybe<A> nothing() {
    return new Maybe<A>(null, true);
  }

  private Maybe(A data, boolean isEmpty) {
    this.data = data;
    this.isEmpty = isEmpty;
  }

  public boolean isEmpty() {
    return isEmpty;
  }

  @Override
  public <B> Maybe<B> fmap(Function<A, B> f) {
    if (isEmpty()) return nothing();
    else return maybe(f.apply(data));
  }

  public static <A> Maybe<A> pure(A a) {
    return maybe(a);
  }

  @Override
  public <B> Maybe<B> bind(Function<A, Monad<B>> f) {
    if (isEmpty()) return nothing();
    else return (Maybe<B>) f.apply(data);
  }

  @Override
  public String toString() {
    if (isEmpty()) return "Nothing";
    else return "Just " + data;
  }

  @Override
  public boolean equals(Object other) {
    if (!(other instanceof Maybe)) return false;
    else {
      Maybe<A> m = (Maybe<A>)other;
      if (m.isEmpty() && isEmpty()) return true;
      else if (m.isEmpty() || isEmpty()) return false;
      else return m.data.equals(data);
    }
  }

  public FunctionalList<A> toList() {
    if (isEmpty()) return FunctionalList.empty();
    else return FunctionalList.pure(data);
  }
}
