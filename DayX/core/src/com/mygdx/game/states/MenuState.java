package com.mygdx.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.dayx;


public class MenuState extends state{

    Texture Playbtn;

    public MenuState(GameStateManager gsm) {
        super(gsm);
        cam.setToOrtho(false, dayx.WIDTH/2, dayx.HEIGHT/2);
        Playbtn = new Texture("playbtn.png");
    }

    @Override
    protected void handleInput() {
        if(Gdx.input.justTouched()){
            gsm.set(new PlayState(gsm));
        }

    }

    @Override
    public void update(float dt) {
        handleInput();

    }

    @Override
    public void render(SpriteBatch sb) {
        sb.setProjectionMatrix(cam.combined);
        sb.begin();
        sb.draw(Playbtn,cam.position.x,cam.position.y);
        sb.end();

    }

    @Override
    public void dispose() {
        Playbtn.dispose();

    }
}
