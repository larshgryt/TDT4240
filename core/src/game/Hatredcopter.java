package game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;
import com.mygdx.game.MyGdxGame;

/**
 * Created by El Perozo on 22.01.2018.
 */

public class Hatredcopter {
    private Vector3 pos;

    private boolean goRight;
    private boolean goUp;

    public Texture hatredCopter;
    public Sprite hatred;

    public Hatredcopter(int x, int y){
        pos = new Vector3(x,y,0);
        hatredCopter = new Texture("attackhelicopter.PNG");
        hatred = new Sprite(hatredCopter);
    }

    public void update(float dt){
        if(goRight){
            pos.add(10,0,0);
            if(pos.x + hatred.getWidth() >= MyGdxGame.WIDTH ){
                goRight = false;
                hatred.flip(true, false);

            }}
        if (!goRight) {
            pos.add(-10,0,0);
            if(pos.x <= 0){
                goRight = true;
                hatred.flip(true, false);

            }
        }
        if(goUp){
            pos.add(0,10,0);
            if(pos.y + hatred.getHeight() >= MyGdxGame.HEIGHT){
                goUp = false;
            }}
        if(!goUp){
            pos.add(0,-10,0);
            if(pos.y <= 0){
                goUp = true;
            }
        }
    }



    public Vector3 getPos() {
        return pos;
    }
    public boolean isGoRight() {
        return goRight;
    }

    public void setGoRight(boolean goRight) {
        this.goRight = goRight;
    }

    public Sprite getHatredCopter() {
        return hatred;
    }
    public void dispose(){
        hatredCopter.dispose();
    }
}
