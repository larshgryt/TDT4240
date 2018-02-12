package state;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;

import game.HatredObserver;
import game.Hatredcopter;
import game.Observer;

/**
 * Created by El Perozo on 23.01.2018.
 */

public class Ov1 extends State {

    public TextButton button;
    private Hatredcopter hc;
    private Observer hcOb1;
    public Ov1(StateManager sm){
        super(sm);
        hc = new Hatredcopter(50,50);
        hcOb1 = new HatredObserver(hc);

    }
    @Override
    public void handleInput() {
        if(Gdx.input.justTouched()){
            sm.set(new Ov2(sm));
            dispose();
        }
    }
    @Override
    public void update(float dt) {
        handleInput();
        hc.update(dt);
    }
    @Override
    public void render(SpriteBatch sb) {
        sb.begin();
        sb.draw(hc.getHatredCopter(), hc.getPos().x, hc.getPos().y);
        sb.end();
    }

    @Override
    public void dispose() {
        hc.dispose();
    }


}
