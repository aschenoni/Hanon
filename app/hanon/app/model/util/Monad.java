package hanon.app.model.util;

import java.util.function.Function;

public interface Monad<A> extends Functor<A> {
  <B> Monad<B> bind(Function<A, Monad<B>> f);
}
