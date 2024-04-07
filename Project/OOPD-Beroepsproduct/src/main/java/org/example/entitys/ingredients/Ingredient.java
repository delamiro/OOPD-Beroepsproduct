package org.example.entitys.ingredients;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import org.example.entitys.blackpixelcat.BlackPixelCatCollisionBox;
import org.example.entitys.text.Text;

import java.util.List;

public class Ingredient extends DynamicSpriteEntity implements Collided, Collider {
    private IngredientIMP ingredientIMP;
    private static int ingredientsGrabbed = 0;
    private Text ingredientText;
    public Ingredient(Coordinate2D initialLocation, IngredientIMP ingredientIMP, Text ingredientText) {
        super(ingredientIMP.getResource(), initialLocation);
        this.ingredientIMP = ingredientIMP;
        this.ingredientText = ingredientText;
    }

    @Override
    public void onCollision(final List<Collider> collidingObjects) {
        for (var collider : collidingObjects) {
            if (collider instanceof BlackPixelCatCollisionBox) {
                ingredientIMP.onPickUp();
                remove();
                ingredientsGrabbed++;
                ingredientText.setText("Ingredients: " + ingredientsGrabbed);
                System.out.println(ingredientsGrabbed);
            }
        }
    }

    public static int getIngredientsGrabbed() {
        return ingredientsGrabbed;
    }
}
