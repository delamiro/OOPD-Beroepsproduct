package org.example.scenes.levels;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.TimerContainer;
import com.github.hanyaeger.api.scenes.DynamicScene;
import org.example.Catgame;
import org.example.entitys.*;
import org.example.entitys.blackpixelcat.BlackPixelCat;
import org.example.entitys.blackpixelcat.BlackPixelCatComposition;
import org.example.entitys.enemys.Rat;


import java.util.Random;


public class DonkerebosScene extends DynamicScene implements TimerContainer {
    public static final double LEFT_MARGIN = 34;
    private static final double DELTA_Y = 40;

    public int scene = 2;
    public int health = 10;
    public int time = 30000;

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
        //Floor walls
        var bottomFloor = new Floor(new Coordinate2D(0, 670),
                new Size(1550, 10));
        addEntity(bottomFloor);

        var boomstronkFloor = new Floor(new Coordinate2D(300, 610),
                new Size(110, 10));
        addEntity(boomstronkFloor);

        //Boomstronk
        var boomstronk = new Boomstronk(new Coordinate2D(300, 620),
                new Size(100, 200));
        addEntity(boomstronk);



        //Text
        var y = 20;
        HealthText healthText = new HealthText(new Coordinate2D(LEFT_MARGIN, y));
        healthText.setHealthText(health);
        addEntity(healthText);


        y+= DELTA_Y;

        IngredientText ingredientText = new IngredientText(new Coordinate2D(LEFT_MARGIN, y));
        ingredientText.setIngredientText(0);
        addEntity(ingredientText);

        y+= DELTA_Y;

        GameTimerText gameTimerText = new GameTimerText(new Coordinate2D(LEFT_MARGIN, y));
        gameTimerText.setTimeText(time);
        addEntity(gameTimerText);


        //PixelCat
        var blackPixelCat = new BlackPixelCatComposition(new Coordinate2D(getWidth() / 2, getHeight()),2,ingredientText,healthText,catgame,health );
        addEntity(blackPixelCat);


        //ingredienten
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


        //Enemys
        Rat rat = new Rat(new Coordinate2D(getWidth(), getHeight()-80));
        addEntity(rat);


    }
    public Coordinate2D returnRandomLocation(){
        return new Coordinate2D(
                new Random().nextInt(100,500),
                new Random().nextInt(100,500)
        );
    }

    @Override
    public void setupTimers() {
        addTimer(new GameTimer(time, catgame));
    }
}
