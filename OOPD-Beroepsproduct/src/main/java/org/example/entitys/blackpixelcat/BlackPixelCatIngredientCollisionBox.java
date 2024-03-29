package org.example.entitys.blackpixelcat;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collider;
import org.example.entitys.Ingredient;

import java.util.List;

public class BlackPixelCatIngredientCollisionBox extends BlackPixelCatCollisionBox {
    public BlackPixelCatIngredientCollisionBox(Coordinate2D initialLocation, final BlackPixelCatComposition parent) {
        super(initialLocation, parent, new Size(40,40));
    }

    @Override
    public void onCollision(final List<Collider> collidingObjects) {
        for (var collider : collidingObjects) {
            if (parent != null && collider instanceof Ingredient ingredient) {
                parent.handleCollision(ingredient);
            }
        }
    }
}