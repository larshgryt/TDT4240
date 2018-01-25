package state;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Created by El Perozo on 23.01.2018.
 */

public abstract class State {
    protected StateManager sm;

    protected State(StateManager sm){
        this.sm = sm;

    }
    public abstract void handleInput();
    public abstract void update(float dt);
    public abstract void render(SpriteBatch sb);
    public abstract void dispose();
}
