package org.example.entitys.blackpixelcat;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.impl.RectangleEntity;
import javafx.scene.paint.Color;


public class BlackPixelCatCollisionBox extends RectangleEntity implements Collider {
    protected BlackPixelCat parent;

    public BlackPixelCatCollisionBox(final Coordinate2D initialLocation, final BlackPixelCat parent, Size size) {
        super(initialLocation, size);
        this.parent = parent;
        setFill(Color.TRANSPARENT);
    }
}
