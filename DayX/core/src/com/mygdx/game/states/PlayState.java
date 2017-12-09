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
        bullets = new Array<bullet>();
    }

    private boolean bullcreate = false;
    @Override
    protected void handleInput() {
        if(Gdx.input.justTouched()){
            int x,y;
            x = Gdx.input.getX();
            y = Gdx.input.getY();
            y = ((-1)*y + 800)/2;
            x = x/2;

            System.out.println(x);
            System.out.println(y);
            bullcreate = true;
            bull = new bullet(70,70,90);
            System.out.println((((cam.position.x)+cam.viewportWidth/2)/2)-bull.getTexture().getWidth()/2);
            System.out.println(((cam.position.y)+cam.viewportHeight/2)/2);
            bullets.add(new bullet(
                    (int) ((((cam.position.x)+cam.viewportWidth/2)/2)-bull.getTexture().getWidth()/2),
                    (int) (((cam.position.y)+cam.viewportHeight/2)/2),
                    (float)Math.toDegrees(Math.atan((y-200)/(x-108)))));// bullet has 3 attribute x,y,degree at which it is launched initiallizing it with 90
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