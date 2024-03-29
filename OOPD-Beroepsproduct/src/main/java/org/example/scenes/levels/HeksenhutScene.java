package org.example.scenes.levels;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.scenes.DynamicScene;
import javafx.scene.Scene;
import org.example.Catgame;
import org.example.entitys.Ingredient;
import org.example.entitys.blackpixelcat.BlackPixelCat;
import org.example.entitys.HealthText;
import org.example.entitys.IngredientText;

import java.util.Random;

public class HeksenhutScene extends DynamicScene {
    public static final double LEFT_MARGIN = 34;
    private static final double DELTA_Y = 40;

    public int scene = 3;

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

        BlackPixelCat blackPixelCat = new BlackPixelCat(new Coordinate2D(getWidth() / 2, getHeight()), healthText, catgame);
        addEntity(blackPixelCat);
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


////        ingredients.add(new GeestelijkStof()); 1
////        ingredients.add(new GriezeligeSpinnenpoten());
////        ingredients.add(new VleermuizenBloed()); 1
////        ingredients.add(new HeksenkruidZaden()); 1
////        ingredients.add(new MaanlichtKristallen()); 1
    }

    public Coordinate2D returnRandomLocation(){
        return new Coordinate2D(
                new Random().nextInt((int) (getWidth())),
                new Random().nextInt((int) (getHeight())));
    }
}
