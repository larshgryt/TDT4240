package game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector3;
import com.mygdx.game.MyGdxGame;

import java.awt.MouseInfo;

/**
 * Created by El Perozo on 22.01.2018.
 */

public class TouchHatredCopter {
    private Vector3 pos;
    private Texture hatred;
    private Sprite hatredCopter;
    private boolean flipRight;
    private BitmapFont text;


    public TouchHatredCopter(int x, int y){
        pos = new Vector3(x,y,0);
        hatred = new Texture("attackhelicopter.PNG");
        hatredCopter = new Sprite(hatred);
        text = new BitmapFont();

    }

    public void update(float dt){
        if(!(pos.x + hatredCopter.getWidth() >= MyGdxGame.WIDTH) && !(pos.y + hatredCopter.getHeight() >= MyGdxGame.HEIGHT) ) {
            pos.x = Gdx.input.getX();
            pos.y = -Gdx.input.getY() + MyGdxGame.HEIGHT;

            }
        if(pos.x + hatredCopter.getWidth() >= MyGdxGame.WIDTH){
            pos.set(MyGdxGame.WIDTH - hatredCopter.getWidth()-1,getPos().y,0);
            if(flipRight) {
                hatredCopter.flip(true, false);
                flipRight = false;
            }
        }

        if(pos.y + hatredCopter.getHeight() >= MyGdxGame.HEIGHT) {
            pos.set(getPos().x, MyGdxGame.HEIGHT - hatredCopter.getHeight() - 1, 0);
        }
        if(pos.x == 0){
            if(!flipRight){
                hatredCopter.flip(true,false);
                flipRight = true;
            }
        }
    }

    public String toString(){
        return "coord:" + pos.x + "." + pos.y;
    }
    public Sprite getHatredCopter() {
        return hatredCopter;
    }

    public Vector3 getPos() {
        return pos;
    }
    public BitmapFont getText(){
        return text;
    }
    public void dispose(){
        text.dispose();
        hatred.dispose();
    }
}
