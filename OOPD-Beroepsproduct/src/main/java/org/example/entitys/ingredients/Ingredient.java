package org.example.entitys.ingredients;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import org.example.entitys.blackpixelcat.BlackPixelCatCollisionBox;

import java.util.List;

public class Ingredient extends DynamicSpriteEntity implements Collided, Collider {
    private IngredientIMP ingredientIMP;
    public Ingredient(Coordinate2D initialLocation, IngredientIMP ingredientIMP) {
        super(ingredientIMP.getResource(), initialLocation);
        this.ingredientIMP = ingredientIMP;
    }

    @Override
    public void onCollision(final List<Collider> collidingObjects) {
        for (var collider : collidingObjects) {
            if (collider instanceof BlackPixelCatCollisionBox) {
                ingredientIMP.onPickUp();
                remove();
            }
        }
    }
}
