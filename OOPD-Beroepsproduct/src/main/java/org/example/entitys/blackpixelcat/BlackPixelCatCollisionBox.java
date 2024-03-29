package org.example.entitys.blackpixelcat;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.impl.RectangleEntity;
import javafx.scene.paint.Color;
public abstract class BlackPixelCatCollisionBox extends RectangleEntity implements Collided {
    protected BlackPixelCatComposition parent;

    public BlackPixelCatCollisionBox(final Coordinate2D initialLocation, final BlackPixelCatComposition parent, Size size) {
        super(initialLocation, size);
        this.parent = parent;
        setFill(Color.TRANSPARENT);
    }

}
