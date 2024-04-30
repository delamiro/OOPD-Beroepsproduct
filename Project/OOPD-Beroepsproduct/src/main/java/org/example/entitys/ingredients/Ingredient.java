package org.example.entitys.ingredients;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import org.example.entitys.blackpixelcat.BlackPixelCat;
import org.example.scenes.levels.DonkerebosScene;

import java.util.List;

public class Ingredient extends DynamicSpriteEntity implements Collided, Collider {
    private IngredientIMP ingredientIMP;
    private static int ingredientsGrabbed = 0;
    private DonkerebosScene donkerebosScene;

    public Ingredient(Coordinate2D initialLocation, IngredientIMP ingredientIMP, DonkerebosScene donkerebosScene) {
        super(ingredientIMP.getResource(), initialLocation);
        this.ingredientIMP = ingredientIMP;
        this.donkerebosScene = donkerebosScene;
    }

    @Override
    public void onCollision(final List<Collider> collidingObjects) {
        for (var collider : collidingObjects) {
            if (collider instanceof BlackPixelCat) {
                ingredientIMP.onPickUp();
                remove();
                ingredientsGrabbed++;
                donkerebosScene.checkForWinOrLose();
                donkerebosScene.updateHealthText();
                donkerebosScene.updateIngredientsText();
            }
        }
    }

    public static int getIngredientsGrabbed() {
        return ingredientsGrabbed;
    }
}
