package org.example.entitys.blackpixelcat;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;

public class BlackPixelCat extends DynamicSpriteEntity {

    public BlackPixelCat(Coordinate2D location, final BlackPixelCatComposition composition){

        super("sprites/blacCatPixel.png", location, new Size(40,80));
    }
}
