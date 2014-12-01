package hanon.app.model.analyst;

public interface Observer<T> {

  public void inform(T info);

}
