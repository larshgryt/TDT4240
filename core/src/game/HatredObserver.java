package game;

/**
 * Created by larsh on 08-Feb-18.
 */

public class HatredObserver implements Observer {

    private Hatredcopter hatred;

    public HatredObserver(Hatredcopter hatred){
        this.hatred = hatred;

    }
    @Override
    public void update(boolean right, boolean up) {
        if(right){
            hatred.setHoriVel();
        }
        if(up){
            hatred.setVertiVel();
        }
    }
}
