package hanon.app.model.analyst;

public interface Observable<T> {
  public void register(Observer<T> observer);

  public void informAll(T info);
}
