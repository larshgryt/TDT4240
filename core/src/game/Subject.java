package game;

/**
 * Created by larsh on 08-Feb-18.
 */

public interface Subject {
    public void register(Observer o);
    public void unregister(Observer o);
    public void notifyObserver(boolean a, boolean b);
}
