package org.example.scenes.levels;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.TimerContainer;
import com.github.hanyaeger.api.scenes.DynamicScene;
import javafx.scene.Scene;
import org.example.Catgame;
import org.example.entitys.*;
import org.example.entitys.blackpixelcat.BlackPixelCat;
import org.example.entitys.blackpixelcat.BlackPixelCatComposition;

import java.util.Random;

public class HeksenhutScene extends DynamicScene implements TimerContainer {
    public static final double LEFT_MARGIN = 34;
    private static final double DELTA_Y = 40;

    public int scene = 3;

    public int time = 30000;

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
        var bottomFloor = new Floor(new Coordinate2D(0, 670),
                new Size(1550, 10));
        addEntity(bottomFloor);

        var y = 20;
        HealthText healthText = new HealthText(new Coordinate2D(LEFT_MARGIN, y));
        addEntity(healthText);

        y+= DELTA_Y;

        IngredientText ingredientText = new IngredientText(new Coordinate2D(LEFT_MARGIN, y));
        addEntity(ingredientText);

//        var blackPixelCat = new BlackPixelCatComposition(new Coordinate2D(getWidth() / 2, getHeight()),3,ingredientText,healthText,catgame );
//        addEntity(blackPixelCat);

        Ingredient geetstelijkeStof = new Ingredient("entitys/geestelijkestof.png",returnRandomLocation(), ingredientText, catgame , scene);
        addEntity(geetstelijkeStof);
        Ingredient griezeligeSpinnenpoten = new Ingredient("entitys/spinnenpoot.png",returnRandomLocation(), ingredientText , catgame,scene);
        addEntity(griezeligeSpinnenpoten);
        Ingredient vleermuizenBloed = new Ingredient("entitys/vleermuizenbloed.png",returnRandomLocation(), ingredientText , catgame,scene);
        addEntity(vleermuizenBloed);
        Ingredient heksenkruidZaden = new Ingredient("entitys/heksenkruidzaden.png",returnRandomLocation(), ingredientText , catgame,scene);
        addEntity(heksenkruidZaden);
        Ingredient maanlichtKristallen = new Ingredient("entitys/maanlicht_kristallen.png",returnRandomLocation(), ingredientText , catgame,scene);
        addEntity(maanlichtKristallen);
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
