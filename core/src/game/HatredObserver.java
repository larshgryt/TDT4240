package game;

/**
 * Created by larsh on 08-Feb-18.
 */

public class HatredObserver implements Observer {

    private static int vertiHits;
    private static int horiHits;

    public HatredObserver(Hatredcopter hc2){
        hc2.register(this);
    }
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
