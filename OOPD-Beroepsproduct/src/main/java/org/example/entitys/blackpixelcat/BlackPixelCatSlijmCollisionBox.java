package org.example.entitys.blackpixelcat;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collider;
import org.example.entitys.Ingredient;
import org.example.entitys.Slijm;

import java.util.List;

public class BlackPixelCatSlijmCollisionBox extends BlackPixelCatCollisionBox {

    public BlackPixelCatSlijmCollisionBox(Coordinate2D initialLocation, final BlackPixelCatComposition parent) {
        super(initialLocation, parent, new Size(40,40));
    }

    @Override
    public void onCollision(final List<Collider> collidingObjects) {
        for (var collider : collidingObjects) {
            if (parent != null && collider instanceof Slijm slijm) {
                parent.handleCollision(slijm);
            }
        }
    }
}
