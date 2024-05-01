package org.example.entitys.ingredients;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import org.example.entitys.blackpixelcat.BlackPixelCat;
import org.example.scenes.levels.DonkerebosScene;

import java.util.List;

public class Ingredient extends DynamicSpriteEntity implements Collided, Collider {
    private IngredientIMP ingredientIMP;
    private DonkerebosScene donkerebosScene;

    public Ingredient(Coordinate2D initialLocation, IngredientIMP ingredientIMP, DonkerebosScene donkerebosScene) {
        super(ingredientIMP.getResource(), initialLocation, new Size(60,60));
        this.ingredientIMP = ingredientIMP;
        this.donkerebosScene = donkerebosScene;
    }

    @Override
    public void onCollision(final List<Collider> collidingObjects) {
        for (var collider : collidingObjects) {
            if (collider instanceof BlackPixelCat) {
                ingredientIMP.onPickUp();
                remove();
                donkerebosScene.upIngredientsGrabbed();
                donkerebosScene.checkForWinOrLose();
                donkerebosScene.updateHealthText();
                donkerebosScene.updateIngredientsText();
            }
        }
    }
}
