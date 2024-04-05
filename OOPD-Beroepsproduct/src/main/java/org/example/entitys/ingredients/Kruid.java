package org.example.entitys.ingredients;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.impl.SpriteEntity;
import org.example.entitys.*;
import org.example.entitys.blackpixelcat.BlackPixelCatCollisionBox;
import org.example.entitys.blackpixelcat.BlackPixelCatComposition;
import org.example.entitys.enemys.Rat;

import java.util.List;

public class Kruid extends SpriteEntity implements Collided,IngredientIMP{
    IngredientText ingredientText;
    public Kruid(Coordinate2D initialLocation, IngredientText ingredientText) {
        super("entitys/heksenkruidzaden.png", initialLocation);
        this.ingredientText = ingredientText;
    }

    @Override
    public void OnPickUp() {
        ingredientText.setIngredientText(1);
    }

    @Override
    public void onCollision(List<Collider> collidingObjects) {
        for (var collider : collidingObjects) {
            if (collider instanceof BlackPixelCatCollisionBox) {
                OnPickUp();
                remove();
            }
        }
    }
}
