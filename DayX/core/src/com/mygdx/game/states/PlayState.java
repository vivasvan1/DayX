package com.mygdx.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
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
        bullets = new Array<bullet>();
    }

    private boolean bullcreate = false;
    @Override
    protected void handleInput() {
        if(Gdx.input.justTouched()){
            //System.out.println("camX = "+cam.position.x+ "camY = "+ cam.position.y);
            Vector3 mousePos = new Vector3(Gdx.input.getX(),Gdx.input.getY(),0);
            cam.unproject(mousePos);
            System.out.println(mousePos);
            bullcreate = true;
            bull = new bullet(70,70,90);
            if(mousePos.x > 120){
                bullets.add(new bullet(
                        (int) ((cam.viewportWidth/2)-bull.getTexture().getWidth()/2),
                        (int) (cam.viewportHeight/2),
                        (float) Math.atan((mousePos.y-200)/(mousePos.x-120))));// bullet has 3 attribute x,y,degree at which it is launched initiallizing it with 90
            }
            else{
                bullets.add(new bullet(
                        (int) ((cam.viewportWidth/2)-bull.getTexture().getWidth()/2),
                        (int) (cam.viewportHeight/2),
                        (float) ((float) (3.1415)+Math.atan((mousePos.y-200)/(mousePos.x-120)))));
            }
        }
    }

    @Override
    public void update(float dt) {
        handleInput();
        for (int i = 0; i < bullets.size; i++) {
            bullets.get(i).update(dt);
        }
    }

    @Override
    public void render(SpriteBatch sb) {
        sb.setProjectionMatrix(cam.combined);
        sb.begin();
        sb.draw(dude.getTexture(),(((cam.position.x)+cam.viewportWidth/2)/2)-dude.getTexture().getWidth()/2,((cam.position.y)+cam.viewportHeight/2)/2);
        for (int i = 0; i < bullets.size; i++) {
            sb.draw(bullets.get(i).getTexture(), bullets.get(i).getPosition().x, bullets.get(i).getPosition().y);
        }
        sb.end();

    }

    @Override
    public void dispose() {

    }
}