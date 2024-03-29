package org.example.scenes.levels;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.scenes.DynamicScene;
import org.example.Catgame;
import org.example.entitys.*;
import org.example.entitys.blackpixelcat.BlackPixelCat;
import org.example.entitys.blackpixelcat.BlackPixelCatComposition;
import org.example.entitys.enemys.Rat;


import java.util.Random;


public class DonkerebosScene extends DynamicScene {
    public static final double LEFT_MARGIN = 34;
    private static final double DELTA_Y = 40;

    public int scene = 2;

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

        var bottomFloor = new Floor(new Coordinate2D(0, 670),
                new Size(1550, 10));
        addEntity(bottomFloor);

        var boomstronk = new Boomstronk(new Coordinate2D(300, 620),
                new Size(100, 200));
        addEntity(boomstronk);


        var wall1 = new Wall(new Coordinate2D(300, 670), new Size(10, 60));
        addEntity(wall1);

        var wall2 = new Wall(new Coordinate2D(400, 670), new Size(10, 60));
        addEntity(wall2);

        var boomstronkFloor = new Floor(new Coordinate2D(300, 610),
                new Size(110, 10));
        addEntity(boomstronkFloor);
        var y = 20;
        HealthText healthText = new HealthText(new Coordinate2D(LEFT_MARGIN, y));
        addEntity(healthText);

        y+= DELTA_Y;

        IngredientText ingredientText = new IngredientText(new Coordinate2D(LEFT_MARGIN, y));
        addEntity(ingredientText);

        var blackPixelCat = new BlackPixelCatComposition(new Coordinate2D(getWidth() / 2, getHeight()),2,ingredientText,healthText,catgame );
        addEntity(blackPixelCat);

        Ingredient kattenklauwBladeren = new Ingredient("entitys/kattenklauwBladeren.png",returnRandomLocation(), ingredientText, catgame,scene);
        addEntity(kattenklauwBladeren);
        Ingredient mandragoraWortel = new Ingredient("entitys/wortel.png",returnRandomLocation(), ingredientText , catgame,scene);
        addEntity(mandragoraWortel);
        Ingredient zwarteNachtschadeBessen = new Ingredient("entitys/zwartenachtschadebessen.png",returnRandomLocation(), ingredientText , catgame,scene);
        addEntity(zwarteNachtschadeBessen);
        Ingredient drakentandPoeder = new Ingredient("entitys/drakentandpoeder.png",returnRandomLocation(), ingredientText , catgame,scene);
        addEntity(drakentandPoeder);
        Ingredient schedelPoeder = new Ingredient("entitys/schedelpoeder.png",returnRandomLocation(), ingredientText , catgame,scene);
        addEntity(schedelPoeder);






        Rat rat = new Rat(new Coordinate2D(getWidth(), getHeight()-80));
        addEntity(rat);


    }
    public Coordinate2D returnRandomLocation(){
        return new Coordinate2D(
                new Random().nextInt((int) (getWidth())),
                new Random().nextInt((int) (getHeight()))
        );
    }
}
