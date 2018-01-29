package state;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Created by El Perozo on 29.01.2018.
 */

public class WinState extends State {
    private BitmapFont text;
    public WinState(StateManager sm) {
        super(sm);
        text = new BitmapFont();
    }

    @Override
    public void handleInput() {
        if(Gdx.input.justTouched()) {
            sm.set(new Ov1(sm));
            dispose();
        }
    }

    @Override
    public void update(float dt) {
        handleInput();
    }

    @Override
    public void render(SpriteBatch sb) {
        sb.begin();
        text.draw(sb,"YoU are Winner!", 290,400);
        sb.end();
    }

    @Override
    public void dispose() {
        text.dispose();
    }
}
