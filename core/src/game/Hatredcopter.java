package game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;
import com.mygdx.game.MyGdxGame;

import java.util.ArrayList;

import javax.security.auth.*;

/**
 * Created by El Perozo on 22.01.2018.
 */

public class Hatredcopter implements Subject {
    private Vector3 pos;

    private int horiVel;
    private int vertiVel;
    private boolean goRight;
    private boolean goUp;
    private ArrayList<Observer> observers;
    private HatredObserver hcObserver;

    public Texture hatredCopter;
    public Sprite hatred;

    public Hatredcopter(int x, int y){
        pos = new Vector3(x,y,0);
        vertiVel = 10;
        horiVel = 10;
        hatredCopter = new Texture("attackhelicopter.PNG");
        hatred = new Sprite(hatredCopter);
        observers = new ArrayList<Observer>();
        hcObserver = new HatredObserver(this);
        register(hcObserver);

    }

    public void update(float dt){

        if(pos.x >= MyGdxGame.WIDTH - hatredCopter.getWidth()|| pos.x <= 0){
            notifyObserver(true, false);
        }
        if(pos.y>= MyGdxGame.HEIGHT - hatredCopter.getHeight() || pos.y <= 0){
            notifyObserver(false, true);
        }
        pos.add(horiVel, vertiVel,0);
    }



    public Vector3 getPos() {
        return pos;
    }


    public Sprite getHatredCopter() {
        return hatred;
    }
    public void dispose(){
        hatredCopter.dispose();
    }


    public void register(Observer o) {
        observers.add(o);
    }

    @Override
    public void unregister(Observer o) {
        int observerIndex = observers.indexOf(o);
        observers.remove(observerIndex);
    }

    @Override
    public void notifyObserver(boolean horiHit, boolean vertHit) {  //tells the observer whether the wall is in the horizontal or vertical plane.
        for (Observer observer : observers){
            observer.update(horiHit, vertHit);
        }
    }
    public void setHoriVel(){
        horiVel = -horiVel;
    }
    public void setVertiVel(){
        vertiVel = -vertiVel;
    }

    public int getHoriVel() {
        return horiVel;
    }

    public int getVertiVel() {
        return vertiVel;
    }

    public boolean isGoRight() {
        return goRight;
    }

    public boolean isGoUp() {
        return goUp;
    }
}
