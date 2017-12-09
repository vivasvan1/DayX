package com.mygdx.game.sprites;

import com.badlogic.gdx.graphics.Texture;

import java.awt.TextComponent;

/**
 * Created by vivasvan on 09-Dec-17.
 */

public class Dude {

    private float deg =90;
    private Texture texture;

    public Dude(float deg) {
        texture = new Texture("dude.png");
    }


    public void update(float dt){

    }

    public float getDeg() {
        return deg;
    }

    public Texture getTexture() {
        return texture;
    }
}
