package org.example.entitys.blackpixelcat;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collider;
import org.example.entitys.Wall;

import java.util.List;

public class BlackPixelCatWallCollisionBox extends BlackPixelCatCollisionBox {

    public BlackPixelCatWallCollisionBox(final Coordinate2D initialLocation, final BlackPixelCatComposition blackPixelCatComposition) {
        super(initialLocation, blackPixelCatComposition, new Size(28, 18));
    }

    @Override
    public void onCollision(final List<Collider> collidingObjects) {
        for (var collider : collidingObjects) {
            if (parent != null && collider instanceof Wall wall) {
                parent.handleCollision(wall);
            }
        }
    }
}
