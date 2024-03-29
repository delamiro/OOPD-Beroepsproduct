package org.example.entitys;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.impl.SpriteEntity;
import org.example.Catgame;

import java.util.List;

public class Ingredient  extends SpriteEntity implements  Collider, Collided {
    IngredientText ingredientText;
    Catgame catgame;

    int scene;
    public Ingredient(String resource, Coordinate2D initialLocation, IngredientText ingredientText, Catgame catgame, int scene) {
        super(resource, initialLocation, new Size(50,50));
        this.ingredientText = ingredientText;
        this.catgame = catgame;
        this.scene = scene;
    }

    @Override
    public void onCollision(List<Collider> collidingObjects) {
        ingredientText.upIngredientText();
        remove();
        if(ingredientText.getIngredientsToGo() == 5){
            if (scene == 2){
                catgame.setActiveScene(scene + 1);
            } else if(scene == 3){
                catgame.setActiveScene(scene + 2);
            }
        }
    }
}
