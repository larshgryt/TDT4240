package game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Array;
import com.mygdx.game.MyGdxGame;

/**
 * Created by El Perozo on 23.01.2018.
 */

public class AnimatedHatredCopter {
    private int velocity;
    private Vector3 pos;
    private Texture hatred;
    private Sprite hatredCopter;
    private boolean goRight;
    private boolean goUp;
    private Rectangle bounds;
    private String heliNumbr;


    private Array<Sprite> frames;
    private float maxFrameTime;
    private float currentFrameTime;
    private int frameCount;
    private int frame;



    public AnimatedHatredCopter(int frameCount, float cycleTime, int x, int y, int vel, String string){
        pos = new Vector3(x,y,0);
        frames = new Array<Sprite>();
        for(int i = 1 ; i <= frameCount ; i++){
            hatred = new Texture("heli"+i+".png"); //lawl
            frames.add(hatredCopter = new Sprite(hatred));
        }
        heliNumbr = string;
        this.frameCount = frameCount;
        maxFrameTime = cycleTime / frameCount;
        frame = 0;
        this.velocity = vel;
        bounds = new Rectangle(pos.x, pos.y, hatredCopter.getWidth(), hatredCopter.getHeight());
    }
    public void update(float dt){
        currentFrameTime += dt;
        bounds.setPosition(pos.x, pos.y);
        if(currentFrameTime >= maxFrameTime){
            frame++;
            currentFrameTime = 0;
        }
        if(frame>=frameCount){
            frame=0;
        }
        if(goRight){
            pos.add(velocity,0,0);
            if(pos.x + hatred.getWidth() >= MyGdxGame.WIDTH ){
                goRight = false;
                for(int i = 0; i<frameCount; i++){
                    frames.get(i).setFlip(false,false);
                }

            }}
        if (!goRight) {

            pos.add(-velocity, 0, 0);
            if (pos.x <= 0) {
                goRight = true;
                for (int i = 0; i < frameCount; i++) {
                    frames.get(i).setFlip(true, false);
                }
            }
        }
        if(goUp){
            pos.add(0,velocity,0);
            if(pos.y + hatred.getHeight() >= MyGdxGame.HEIGHT){
                goUp = false;
            }}
        if(!goUp){
            pos.add(0,-velocity,0);
            if(pos.y <= 0){
                goUp = true;
            }
        }
    }
    public Sprite getFrames(){
            return frames.get(frame);
    }
    public Vector3 getPos(){
        return pos;
    }
   public void collision(AnimatedHatredCopter otherHeli){
        int value = 10;
        /*Rectangle intersection = new Rectangle();
        Intersector.intersectRectangles(bounds, otherHeli, intersection);*/
        if(!goRight){
          // pos.x += -value;
            otherHeli.setGoRight(true);
            //System.out.println("left");
        }
        if(goRight){
         // pos.x += value;
            otherHeli.setGoRight(false);
            //System.out.println("right");
        }
        if(goUp){
          //  pos.y += -value;
            otherHeli.setGoUp(false);
            //System.out.println("Up");
        }
        if(!otherHeli.getGoUp()){
        //   pos.y += value;
            otherHeli.setGoUp(true);
            //System.out.println("Up");
        }


    }
    public Rectangle getBounds(){
        return bounds;
    }
    public Boolean getGoRight(){
        return goRight;
    }
    public void setGoRight(Boolean b){
        goRight = b;
    }
    public Boolean getGoUp(){
        return goUp;
    }
    public void setGoUp(Boolean b){
        goUp = b;
    }

    public void dispose(){
        hatred.dispose();
    }
}
