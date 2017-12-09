package com.mygdx.game.sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class bullet {
    private static final int velo = 100;
    private Vector2 position;
    private Vector2 velocity;
    private Texture texture;

    public bullet(int x,int y,float deg){
        position = new Vector2(x,y);
        velocity = new Vector2((float) (velo*(Math.cos(Math.toRadians(deg)))), (float) (velo*(Math.sin(Math.toRadians(deg)))));
        texture = new Texture("bullet.png");
    }

    public void update(float dt){
        velocity.scl(dt);
        position.add(velocity.x,velocity.y);
        velocity.scl(1/dt);
    }

    public Vector2 getPosition() {
        return position;
    }

    public Texture getTexture() {
        return texture;
    }

    public void dispose(){
        texture.dispose();
    }
}
