package org.example.entitys.blackpixelcat;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collider;
import org.example.entitys.Boomstronk;

import java.util.List;

public class BlackPixelCatBoomstronkCollisionBox extends BlackPixelCatCollisionBox {
    public BlackPixelCatBoomstronkCollisionBox(Coordinate2D initialLocation, final BlackPixelCatComposition parent) {
        super(initialLocation, parent, new Size(50,50));
    }

    @Override
    public void onCollision(final List<Collider> collidingObjects) {
        for (var collider : collidingObjects) {
            if (parent != null && collider instanceof Boomstronk boomstronk) {
                parent.handleCollision(boomstronk);
            }
        }
    }
}
