package org.example.entitys.blackpixelcat;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;

public class BlackPixelCatSprite extends DynamicSpriteEntity {

    public BlackPixelCatSprite(Coordinate2D location, final BlackPixelCat composition){

        super("sprites/blacCatPixel.png", location, new Size(40,80));
    }
}
