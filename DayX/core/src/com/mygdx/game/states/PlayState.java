package com.mygdx.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;
import com.mygdx.game.dayx;
import com.mygdx.game.sprites.Dude;
import com.mygdx.game.sprites.bullet;

class PlayState extends state{

    private Dude dude;
    private Texture Texture;
    private Array<bullet> bullets;
    private bullet bull;

    PlayState(GameStateManager gsm) {
        super(gsm);
        cam.setToOrtho(false, dayx.WIDTH/2,dayx.HEIGHT/2);
        dude = new Dude(90);
    }

    private boolean bullcreate = false;
    @Override
    protected void handleInput() {
        if(Gdx.input.justTouched()){
            int x,y;
            x = Gdx.input.getX();
            y = Gdx.input.getY();
            bullcreate = true;
            bull = new bullet(50,50,90);// bullet has 3 attribute x,y,degree at which it is launched initiallizing it with 90
            bullets.add(bull);
        }

    }

    @Override
    public void update(float dt) {
        handleInput();
        for(int i=0;i<bullets.size;i++) {
            bullets.get(i).update(dt);
        }

    }

    @Override
    public void render(SpriteBatch sb) {
        sb.setProjectionMatrix(cam.combined);
        sb.begin();
        sb.draw(dude.getTexture(),(((cam.position.x)+cam.viewportWidth/2)/2)-dude.getTexture().getWidth()/2,((cam.position.y)+cam.viewportHeight/2)/2);
        for(int i=0;i<bullets.size;i++) {
            sb.draw(bullets.get(i).getTexture(), bullets.get(i).getPosition().x, bullets.get(i).getPosition().y);
        }
        sb.end();


    }

    @Override
    public void dispose() {

    }
}
