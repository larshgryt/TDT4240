package state;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.MyGdxGame;

import game.Ball;
import game.Paddle;

/**
 * Created by larsh on 27-Jan-18.
 */

public class Ov4 extends State {
    public Paddle paddle1;
    public Paddle paddle2;
    public Ball ball;
    public BitmapFont score1;
    public BitmapFont score2;
    public int scoreToGet = 5; //Du er velkommen til å sette denne til 21, men Pong er vel ikke egentlig SÅ interessant
    public int hitCount = 0;

    public Ov4(StateManager sm) {
        super(sm);
        paddle1 = new Paddle(15, 400, 1, 15);
        paddle2 = new Paddle(450,400,2, 15);
        ball = Ball.getInstance();
        score1 = new BitmapFont();
        score2 = new BitmapFont();
    }

    @Override
    public void handleInput() {

    }

    @Override
    public void update(float dt) {
        ball.update(dt);
        paddle1.update(dt);
        paddle2.update(dt);
        if(Gdx.input.isKeyPressed(Input.Keys.W) && paddle1.getPosPaddle().y <= 800-paddle1.getPaddle().getHeight()){
            paddle1.posPaddle.add(0,paddle1.getVelocity(),0);
        }
        if(Gdx.input.isKeyPressed(Input.Keys.S) && paddle1.getPosPaddle().y >= 0){
            paddle1.posPaddle.add(0,-paddle1.getVelocity(),0);
        }
        if(Gdx.input.isKeyPressed(Input.Keys.UP) && paddle2.getPosPaddle().y <= 800-paddle2.getPaddle().getHeight()){
            paddle2.posPaddle.add(0,paddle1.getVelocity(),0);
        }
        if(Gdx.input.isKeyPressed(Input.Keys.DOWN) && paddle2.getPosPaddle().y >= 0){
            paddle2.posPaddle.add(0,-paddle2.getVelocity(),0);
        }
        if(ball.getBounds().overlaps(paddle1.getBounds()) || ball.getBounds().overlaps(paddle2.getBounds())){
            ball.setVelocityHorizontal(-ball.getVelocityHorizontal());
            System.out.println("Hey listen!");
            hitCount += 1;
            if(hitCount % 3 == 0){
                ball.setVelocityHorizontal(ball.getVelocityHorizontal()+3);
                ball.setVelocityVertical(ball.getVelocityVertical()+2);
            }
        }
        if(ball.getPosBall().x <= 0){
            paddle2.setScore(paddle2.getScore()+1);
            ball.setPosBall();
        }
        if(ball.getPosBall().x >= 480){
            paddle1.setScore(paddle1.getScore()+1);
            ball.setPosBall();
        }
        if(paddle1.getScore() >= scoreToGet || paddle2.getScore() >= scoreToGet){
            sm.set(new WinState(sm));
            dispose();
        }
    }

    @Override
    public void render(SpriteBatch sb) {
        sb.begin();
        sb.draw(paddle1.getPaddle(),paddle1.getPosPaddle().x, paddle1.getPosPaddle().y);
        sb.draw(paddle2.getPaddle(), paddle2.getPosPaddle().x, paddle2.getPosPaddle().y);
        sb.draw(ball.getBall(), ball.getPosBall().x, ball.getPosBall().y);
        score1.draw(sb, paddle1.toString() + "|" + paddle2.toString(), MyGdxGame.WIDTH/2, 780);
        sb.end();
    }

    @Override
    public void dispose() {
        paddle1.dispose();
        paddle2.dispose();
        ball.dispose();
    }
}
