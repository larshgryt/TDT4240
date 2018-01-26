package state;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.MyGdxGame;

import javax.xml.soap.Text;

import game.TouchHatredCopter;

/**
 * Created by El Perozo on 23.01.2018.
 */

public class Ov2 extends State {

    private TouchHatredCopter thc;

    private BitmapFont text;

    protected Ov2(StateManager sm) {
        super(sm);
        thc = new TouchHatredCopter(50,50);
        text = new BitmapFont();
    }

    @Override
    public void handleInput() {
        if(Gdx.input.justTouched()){
            sm.set(new Ov3(sm));
            dispose();
        }
    }

    @Override
    public void update(float dt) {
        handleInput();
        thc.update(dt);
    }

    @Override
    public void render(SpriteBatch sb) {
        sb.begin();
        sb.draw(thc.getHatredCopter(), thc.getPos().x, thc.getPos().y);
        thc.getText().draw(sb,thc.toString(),0,720);
        sb.end();
    }

    @Override
    public void dispose() {
        thc.dispose();
    }
}
