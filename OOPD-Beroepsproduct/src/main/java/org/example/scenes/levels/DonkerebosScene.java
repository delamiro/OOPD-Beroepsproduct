package org.example.scenes.levels;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.scenes.DynamicScene;
import org.example.Catgame;
import org.example.entitys.Ingredient;
import org.example.entitys.IngredientText;
import org.example.entitys.blackpixelcat.BlackPixelCat;
import org.example.entitys.HealthText;
import org.example.entitys.enemys.Rat;
import org.example.entitys.ingredients.KattenklauwBladeren;
import org.example.entitys.obstacle.Boomstronk;

import java.util.Random;


public class DonkerebosScene extends DynamicScene {
    public static final double LEFT_MARGIN = 34;
    private static final double DELTA_Y = 40;

    private final Catgame catgame;
    public DonkerebosScene(Catgame catgame) {
        this.catgame = catgame;
    }


    @Override
    public void setupScene() {
        setBackgroundImage("backgrounds/forrest.jpg");
    }

    @Override
    public void setupEntities() {

        var y = 20;
        HealthText healthText = new HealthText(new Coordinate2D(LEFT_MARGIN, y));
        addEntity(healthText);

        y+= DELTA_Y;

        IngredientText ingredientText = new IngredientText(new Coordinate2D(LEFT_MARGIN, y));
        addEntity(ingredientText);

        BlackPixelCat blackPixelCat = new BlackPixelCat(new Coordinate2D(getWidth() / 2, getHeight()), healthText, catgame);
        Ingredient kattenklauwBladeren = new Ingredient("entitys/kattenklauwBladeren.png",returnRandomLocation(), ingredientText, catgame);
        addEntity(kattenklauwBladeren);
        Ingredient mandragoraWortel = new Ingredient("entitys/wortel.png",returnRandomLocation(), ingredientText , catgame);
        addEntity(mandragoraWortel);
        Ingredient zwarteNachtschadeBessen = new Ingredient("entitys/zwartenachtschadebessen.png",returnRandomLocation(), ingredientText , catgame);
        addEntity(zwarteNachtschadeBessen);
        Ingredient drakentandPoeder = new Ingredient("entitys/drakentandpoeder.png",returnRandomLocation(), ingredientText , catgame);
        addEntity(drakentandPoeder);
        Ingredient schedelPoeder = new Ingredient("entitys/schedelpoeder.png",returnRandomLocation(), ingredientText , catgame);
        addEntity(schedelPoeder);





        Boomstronk boomstronk = new Boomstronk(new Coordinate2D(getWidth() / 2 + 20, getHeight()- 100),blackPixelCat);

        Rat rat = new Rat(new Coordinate2D(getWidth(), getHeight()-44));
        //addEntity(rat);


        addEntity(boomstronk);
        addEntity(blackPixelCat);
        
    }
    public Coordinate2D returnRandomLocation(){
        return new Coordinate2D(
                new Random().nextInt((int) (getWidth())),
                new Random().nextInt((int) (getHeight())));
    }
}
