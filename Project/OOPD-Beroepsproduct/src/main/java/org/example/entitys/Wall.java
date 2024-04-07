package org.example.entitys;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;

public class Wall extends BlackPixelCatCollidingBox {

    public Wall(Coordinate2D initialLocation, Size size) {
        super(initialLocation, size);
    }
}