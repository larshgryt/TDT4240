package state;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import game.Pong;

/**
 * Created by larsh on 27-Jan-18.
 */

public class Ov4 extends State {
    public Pong pong;
    protected Ov4(StateManager sm) {
        super(sm);
        pong = new Pong();
    }

    @Override
    public void handleInput() {

    }

    @Override
    public void update(float dt) {

    }

    @Override
    public void render(SpriteBatch sb) {

    }

    @Override
    public void dispose() {

    }
}
