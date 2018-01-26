package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import game.TouchHatredCopter;
import state.Ov1;
import state.Ov3;
import state.StateManager;

public class MyGdxGame extends ApplicationAdapter {
	public static final int WIDTH = 480;
	public static final int HEIGHT = 800;

	public static final String TITLE = "Hatredcopter";
	private SpriteBatch batch;

	//private Hatredcopter hc;
	private TouchHatredCopter thc;
	private StateManager sm;



	public void create () {
		batch = new SpriteBatch();
		Gdx.gl.glClearColor(0, 0, 0, 1);
		//hc = new Hatredcopter(50,50);
		sm = new StateManager();
		thc = new TouchHatredCopter(50,50);
		sm.push(new Ov3(sm));

	}

	@Override
	public void render () {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		sm.update(Gdx.graphics.getDeltaTime());
		sm.render(batch);


	}
	@Override
	public void dispose () {
		batch.dispose();

	}
}
