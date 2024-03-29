package org.example.entitys.blackpixelcat;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collider;
import org.example.entitys.Floor;

import java.util.List;

public class BlackPixelCatFloorCollisionBox extends BlackPixelCatCollisionBox {
    public BlackPixelCatFloorCollisionBox(Coordinate2D initialLocation, final BlackPixelCatComposition parent) {
        super(initialLocation, parent, new Size(18,40));
    }

    @Override
    public void onCollision(final List<Collider> collidingObjects) {
        for (var collider : collidingObjects) {
            if (parent != null && collider instanceof Floor floor) {
                parent.handleCollision(floor);
            }
        }
    }
}
