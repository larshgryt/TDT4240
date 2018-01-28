package game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;

/**
 * Created by larsh on 27-Jan-18.
 */

public class Pong {
    private int velocity;
    private int score1;
    private int score2;
    private Vector3 posPaddle1;
    private Vector3 posPaddle2;
    private Vector3 posBall;
    private Texture paddle;
    private Texture ball;
    private Rectangle bounds;

    public Pong(){
        velocity = 10;
    }
    //takes input from player and moves the paddle accordingly
    public void paddleMovement(){
        if(Gdx.input.isKeyPressed(Input.Keys.W)){
            posPaddle1.y += velocity;
        }
        if(Gdx.input.isKeyPressed(Input.Keys.S)){
            posPaddle1.y += -velocity;
        }
        if(Gdx.input.isKeyPressed(Input.Keys.UP)){
            posPaddle2.y += velocity;
        }
        if(Gdx.input.isKeyPressed(Input.Keys.DOWN)){
            posPaddle2.y += -velocity;
        }
    }
    //checks whether the ball has crossed a goal line, and update score accordingly
    public void goal(){
        if(posBall.x >= 480){
            score1 += 1;
        }
        if(posBall.x <= 0){
            score2 += 1;
        }
    }
    //what happens when the ball collides with paddle or wall
    public void collision(){

    }

}
