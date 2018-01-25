package state;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import game.AnimatedHatredCopter;

/**
 * Created by El Perozo on 23.01.2018.
 */

public class Ov3 extends State {

    private AnimatedHatredCopter ahc2;
    private AnimatedHatredCopter ahc1;
    private AnimatedHatredCopter ahc3;

    public Ov3(StateManager sm) {
        super(sm);
        ahc2 = new AnimatedHatredCopter(4, 0.1f, 10,50, 5,"heli_1");
        ahc1 = new AnimatedHatredCopter(4,0.1f,200,200, 10,"heli_2");
        ahc3 = new AnimatedHatredCopter(4,0.1f,250,500,15,"heli_3");
    }

    @Override
    public void handleInput() {

    }

    @Override
    public void update(float dt) {
        ahc1.update(dt);
        ahc2.update(dt);
        ahc3.update(dt);
        if(ahc1.getBounds().overlaps(ahc2.getBounds())){
            ahc1.collision(ahc2);
        }
        if(ahc2.getBounds().overlaps(ahc1.getBounds())){
            ahc2.collision(ahc1);
        }
        if(ahc3.getBounds().overlaps(ahc1.getBounds())){
            ahc3.collision(ahc1);
        }
        if(ahc1.getBounds().overlaps(ahc3.getBounds())){
            ahc1.collision(ahc3);
        }
        if(ahc2.getBounds().overlaps(ahc3.getBounds())){
            ahc2.collision(ahc3);
        }
        if(ahc3.getBounds().overlaps(ahc2.getBounds())){
            ahc3.collision(ahc2);
        }
    }

    @Override
    public void render(SpriteBatch sb) {
        sb.begin();
        sb.draw(ahc1.getFrames(),ahc1.getPos().x,ahc1.getPos().y);
        sb.draw(ahc2.getFrames(),ahc2.getPos().x,ahc2.getPos().y);
        sb.draw(ahc3.getFrames(),ahc3.getPos().x,ahc3.getPos().y);
        sb.end();
    }

    @Override
    public void dispose() {

    }
}
