package org.example.scenes.levels;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.scenes.DynamicScene;
import org.example.Catgame;
import org.example.entitys.blackpixelcat.BlackPixelCat;
import org.example.entitys.HealthText;
import org.example.entitys.IngredientText;

public class HeksenhutScene extends DynamicScene {
    public static final double LEFT_MARGIN = 34;
    private static final double DELTA_Y = 40;
    private final Catgame catgame;
    public HeksenhutScene(Catgame catgame) {
        this.catgame = catgame;
    }
    @Override
    public void setupScene() {
        setBackgroundImage("backgrounds/heksenhut.jpg");
    }

    @Override
    public void setupEntities() {
        var y = 20;
        HealthText healthText = new HealthText(new Coordinate2D(LEFT_MARGIN, y));
        addEntity(healthText);

        y+= DELTA_Y;

        IngredientText ingredientText = new IngredientText(new Coordinate2D(LEFT_MARGIN, y));
        addEntity(ingredientText);
    }
}
