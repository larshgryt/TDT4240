package game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.mygdx.game.MyGdxGame;

/**
 * Created by El Perozo on 29.01.2018.
 */

public class Ball {

    private Vector3 posBall;
    private Texture ball;
    private int velocityVertical;
    private int velocityHorizontal;
    private Rectangle bounds;
    private Paddle paddle;

    public Ball(int vert, int hori){
        velocityVertical = vert;
        velocityHorizontal = hori;
        posBall = new Vector3(200,400,0);
        ball = new Texture("pongBall.PNG");
        bounds = new Rectangle(posBall.x, posBall.y, ball.getWidth(), ball.getHeight());
    }
    public void update(float dt){
        posBall.add(velocityHorizontal, velocityVertical,0);
        bounds.setPosition(posBall.x, posBall.y);
        if(posBall.y >= 750){
            velocityVertical = -velocityVertical;
        }
        if(posBall.y <= 50){
            velocityVertical = -velocityVertical;
        }
        if(posBall.x <= 0){
            velocityHorizontal = -velocityHorizontal;
        }
        if(posBall.x >= 480){
            velocityHorizontal = -velocityHorizontal;
        }

    }
    public Texture getBall(){
        return ball;
    }
    public Vector3 getPosBall(){
        return posBall;
    }
    public void setPosBall(){
        posBall.set(MyGdxGame.WIDTH/2,MyGdxGame.HEIGHT/2,0);
    }
    public Rectangle getBounds(){
        return bounds;
    }
    public int getVelocityHorizontal(){
        return velocityHorizontal;
    }
    public void setVelocityHorizontal(int a){
        velocityHorizontal = a;
    }

    public int getVelocityVertical() {
        return velocityVertical;
    }

    public void setVelocityVertical(int velocityVertical) {
        this.velocityVertical = velocityVertical;
    }

    public void dispose(){
        ball.dispose();
    }
}
