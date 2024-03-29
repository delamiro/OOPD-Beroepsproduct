package org.example.entitys;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.impl.SpriteEntity;
import org.example.Catgame;

import java.util.List;

public class Ingredient  extends SpriteEntity implements  Collider {
    IngredientText ingredientText;
    Catgame catgame;

    int scene;
    public Ingredient(String resource, Coordinate2D initialLocation, IngredientText ingredientText, Catgame catgame, int scene) {
        super(resource, initialLocation, new Size(50,50));
        this.ingredientText = ingredientText;
        this.catgame = catgame;
        this.scene = scene;
    }
}
