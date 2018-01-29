package game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;

/**
 * Created by larsh on 27-Jan-18.
 */

public class Paddle {
    private int velocity;
    public Vector3 posPaddle;
    private Texture paddle;
    private Rectangle bounds;
    private int score;
    public BitmapFont text;

    public Paddle(int x, int y, int paddleNr, int vel){
        velocity = vel;
        text = new BitmapFont();
        paddle = new Texture("pongPaddle"+paddleNr+".PNG");
        posPaddle = new Vector3(x,y,0);
        bounds = new Rectangle(posPaddle.x, posPaddle.y, paddle.getWidth(), paddle.getHeight());
    }
    public void update(float dt){
        bounds.setPosition(posPaddle.x,posPaddle.y);
    }
    public int getVelocity(){
        return velocity;
    }
    public Vector3 getPosPaddle(){
        return posPaddle;
    }
    //takes input from player and moves the paddle accordingly
    public Rectangle getBounds(){
        return bounds;
    }
    public Texture getPaddle(){
        return paddle;
    }
    public int getScore(){
        return score;
    }
    public void setScore(int d){
        score = d;
    }
    public String toString(){
        return String.valueOf(score);
    }
    public void dispose(){
        paddle.dispose();
    }
}
