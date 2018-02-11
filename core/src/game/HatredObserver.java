package game;

/**
 * Created by larsh on 08-Feb-18.
 */

public class HatredObserver implements Observer {

    private int vertiHits;
    private int horiHits;

    @Override
    public void update(boolean right, boolean up) {
        if(right){
            horiHits++;
            System.out.println("Horizontal walls hit: " + horiHits);
        }
        if(up){
            vertiHits++;
            System.out.println("Vertical walls hit: " + vertiHits);
        }
    }
}
