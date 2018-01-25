package state;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.Stack;

/**
 * Created by El Perozo on 23.01.2018.
 */

public class StateManager  {
    private Stack<State> states;

    public StateManager(){
        states = new Stack<State>();
    }
    public void push(State state){
        states.push(state);
    }
    public void pop(){
        states.pop();
    }
    public void set(State state){
        states.pop();
        states.push(state);
    }
    public void update(float dt){
        states.peek().update(dt);
    }
    public void render(SpriteBatch sb){
        states.peek().render(sb);
    }
}
