package org.example;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;

public class PixelCat extends DynamicSpriteEntity {
    public PixelCat(Coordinate2D location){
        super("sprites/small_cat.png", location);
        setMotion(2, 270d);
    }
}
