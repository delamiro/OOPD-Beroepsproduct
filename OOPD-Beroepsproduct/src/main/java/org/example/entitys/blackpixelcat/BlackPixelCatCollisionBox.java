package org.example.entitys.blackpixelcat;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.impl.RectangleEntity;
import javafx.scene.paint.Color;
import org.example.entitys.Floor;
import org.example.entitys.Ingredient;
import org.example.entitys.Slijm;
import org.example.entitys.Wall;
import org.example.entitys.enemys.Rat;

import java.util.List;

public class BlackPixelCatCollisionBox extends RectangleEntity implements Collider {
    protected BlackPixelCatComposition parent;

    public BlackPixelCatCollisionBox(final Coordinate2D initialLocation, final BlackPixelCatComposition parent, Size size) {
        super(initialLocation, size);
        this.parent = parent;
        setFill(Color.TRANSPARENT);
    }

    public void onCollision(final List<Collider> collidingObjects) {
        for (var collider : collidingObjects) {
            if (parent != null && collider instanceof Floor floor) {
                parent.handleCollision(floor);
            }
            if (parent != null && collider instanceof Ingredient ingredient) {
                parent.handleCollision(ingredient);
            }
            if (parent != null && collider instanceof Rat rat) {
                parent.handleCollision(rat);
            }
            if (parent != null && collider instanceof Slijm slijm) {
                parent.handleCollision(slijm);
            }
            if (parent != null && collider instanceof Wall wall) {
                parent.handleCollision(wall);
            }
        }
    }
}
