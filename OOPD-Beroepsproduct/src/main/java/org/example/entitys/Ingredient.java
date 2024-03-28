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
    public Ingredient(String resource, Coordinate2D initialLocation, IngredientText ingredientText, Catgame catgame) {
        super(resource, initialLocation, new Size(50,50));
        this.ingredientText = ingredientText;
        this.catgame = catgame;
    }

    @Override
    public void onCollision(List<Collider> list) {
            ingredientText.upIngredientText();
            remove();

            if(ingredientText.getIngredientsToGo() == 5){
                catgame.setActiveScene(3);
            }
    }
}
