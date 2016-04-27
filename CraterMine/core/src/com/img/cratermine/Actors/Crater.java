package com.img.cratermine.Actors;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;

/**
 * Created by Gonza on 27/04/2016.
 */
public class Crater extends Actor {

    TextureRegion textureRegion;

    public Crater() {
        textureRegion = new TextureRegion(new Texture("crater.png"));
    }

    @Override
    public void draw (Batch batch, float parentAlpha) {
        Color color = getColor();
        batch.setColor(color.r, color.g, color.b, color.a * parentAlpha);
        batch.draw(textureRegion, 0, 0, getOriginX(), getOriginY(), 200, 200, getScaleX(), getScaleY(), getRotation());
    }

}
