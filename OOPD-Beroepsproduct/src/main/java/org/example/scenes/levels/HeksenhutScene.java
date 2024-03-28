package org.example.scenes.levels;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.scenes.DynamicScene;
import org.example.Catgame;
import org.example.entitys.BlackPixelCat;
import org.example.entitys.HealthText;
import org.example.entitys.IngredientText;

public class HeksenhutScene extends DynamicScene {

    Catgame catgame;
    public HeksenhutScene(Catgame catgame) {
        this.catgame = catgame;
    }
    @Override
    public void setupScene() {
        setBackgroundImage("backgrounds/heksenhut.jpg");
    }

    @Override
    public void setupEntities() {

        HealthText healthText = new HealthText(new Coordinate2D(getWidth() / 2, getHeight() / 2));
        addEntity(healthText);

        IngredientText ingredientText = new IngredientText(new Coordinate2D(getWidth() / 2 - 60, getHeight() / 2 - 40));
        addEntity(ingredientText);

        BlackPixelCat blackPixelCat = new BlackPixelCat(new Coordinate2D(getWidth() / 2, getHeight()), healthText, ingredientText, catgame);
        addEntity(blackPixelCat);
    }
}
