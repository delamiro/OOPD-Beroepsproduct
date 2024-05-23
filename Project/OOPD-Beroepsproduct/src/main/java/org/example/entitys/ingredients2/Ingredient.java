package org.example.entitys.ingredients2;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import org.example.entitys.blackpixelcat.BlackPixelCat;
import org.example.entitys.ingredients.IngredientIMP;
import org.example.scenes.levels.DonkerebosScene;

import java.util.List;

public abstract class Ingredient extends DynamicSpriteEntity implements Collided, Collider {
    private DonkerebosScene donkerebosScene;

    public Ingredient(String resource,Coordinate2D initialLocation, DonkerebosScene donkerebosScene) {
        super(resource, initialLocation, new Size(60,60));
        this.donkerebosScene = donkerebosScene;
    }

    @Override
    public void onCollision(final List<Collider> collidingObjects) {
        for (var collider : collidingObjects) {
            if (collider instanceof BlackPixelCat) {
                onPickUp();
                remove();
                donkerebosScene.upIngredientsGrabbed();
                donkerebosScene.checkForWinOrLose();
                donkerebosScene.updateHealthText();
                donkerebosScene.updateIngredientsText();
            }
        }
    }

    public abstract void onPickUp();
}
