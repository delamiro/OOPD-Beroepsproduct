package org.example.scenes.levels;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.YaegerEntity;
import com.github.hanyaeger.api.scenes.DynamicScene;
import org.example.Catgame;
import org.example.entitys.IngredientText;
import org.example.entitys.PixelCat;
import org.example.entitys.BlackPixelCat;
import org.example.entitys.HealthText;
import org.example.entitys.ingredients.Ingredient;
import org.example.entitys.ingredients.KattenklauwBladeren;

import java.util.ArrayList;
import java.util.List;


public class GameLevel extends DynamicScene {
    Catgame catgame;
    public GameLevel(Catgame catgame) {
        this.catgame = catgame;
    }


    @Override
    public void setupScene() {

    }

    @Override
    public void setupEntities() {

        PixelCat pixelcat = new PixelCat(new Coordinate2D(getWidth() / 2, getHeight() / 2));
        addEntity(pixelcat);

        HealthText healthText = new HealthText(new Coordinate2D(getWidth() / 2, getHeight() / 2));
        addEntity(healthText);

        IngredientText ingredientText = new IngredientText(new Coordinate2D(getWidth() / 2 - 60, getHeight() / 2 - 40));
        addEntity(ingredientText);

        BlackPixelCat blackPixelCat = new BlackPixelCat(new Coordinate2D(getWidth() / 2, getHeight() / 2), healthText, ingredientText, catgame);
        addEntity(blackPixelCat);

        KattenklauwBladeren kattenklauwBladeren = new KattenklauwBladeren(new Coordinate2D(getWidth() / 2 + 20, getHeight() / 2 + 20));
        addEntity(kattenklauwBladeren);

//        ingredients.add(new MandragoraWortel());
//        ingredients.add(new KattenklauwBladeren(new Coordinate2D(getWidth() / 2, getHeight() / 2)));
////        ingredients.add(new ZwarteNachtschadeBessen());
////        ingredients.add(new DrakentandPoeder());
////        ingredients.add(new SchedelPoeder());
////        ingredients.add(new GeestelijkStof());
////        ingredients.add(new GriezeligeSpinnenpoten());
////        ingredients.add(new VleermuizenBloed());
////        ingredients.add(new HeksenkruidZaden());
////        ingredients.add(new MaanlichtKristallen());


    }
}
