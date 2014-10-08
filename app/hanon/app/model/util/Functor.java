package hanon.app.model.util;

import java.util.function.Function;

public interface Functor<A> {
  public <B> Functor<B> fmap(Function<A, B> f);
}
