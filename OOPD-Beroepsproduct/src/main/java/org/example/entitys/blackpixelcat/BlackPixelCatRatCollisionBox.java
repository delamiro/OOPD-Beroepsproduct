package org.example.entitys.blackpixelcat;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collider;
import org.example.entitys.enemys.Rat;

import java.util.List;

public class BlackPixelCatRatCollisionBox extends BlackPixelCatCollisionBox {
    public BlackPixelCatRatCollisionBox(Coordinate2D initialLocation, BlackPixelCatComposition parent) {
        super(initialLocation, parent, new Size(40,40));
    }

    @Override
    public void onCollision(final List<Collider> collidingObjects) {
        for (var collider : collidingObjects) {
            if (parent != null && collider instanceof Rat rat) {
                parent.handleCollision(rat);
            }
        }
    }
}
