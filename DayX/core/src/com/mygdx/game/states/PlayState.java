package com.mygdx.game.states;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.dayx;

public class PlayState extends state{

    Texture dude;

    protected PlayState(GameStateManager gsm) {
        super(gsm);
        cam.setToOrtho(false, dayx.WIDTH/2,dayx.HEIGHT/2);
        dude = new Texture("dude.png");
    }

    @Override
    protected void handleInput() {

    }

    @Override
    public void update(float dt) {

    }

    @Override
    public void render(SpriteBatch sb) {
        sb.setProjectionMatrix(cam.combined);
        sb.begin();
        sb.draw(dude,50,50);
        sb.end();


    }

    @Override
    public void dispose() {

    }
}
