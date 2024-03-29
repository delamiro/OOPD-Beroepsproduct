package org.example.entitys;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.impl.SpriteEntity;

import org.example.entitys.blackpixelcat.BlackPixelCatComposition;

import java.util.List;

public class Slijm  extends SpriteEntity implements Collider {
    public Slijm(Coordinate2D initialLocation, BlackPixelCatComposition blackPixelCat) {
        super("entitys/slijm.png", initialLocation, new Size(175,175));
    }
}
