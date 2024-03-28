package org.example.scenes.levels;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.scenes.DynamicScene;
import org.example.Catgame;
import org.example.entitys.IngredientText;
import org.example.entitys.BlackPixelCat;
import org.example.entitys.HealthText;
import org.example.entitys.enemys.Rat;
import org.example.entitys.ingredients.KattenklauwBladeren;


public class DonkerebosScene extends DynamicScene {
    Catgame catgame;
    public DonkerebosScene(Catgame catgame) {
        this.catgame = catgame;
    }


    @Override
    public void setupScene() {
        setBackgroundImage("backgrounds/forrest.jpg");
    }

    @Override
    public void setupEntities() {

        Rat rat = new Rat(new Coordinate2D(getWidth(), getHeight()-44));
        addEntity(rat);

        HealthText healthText = new HealthText(new Coordinate2D(getWidth() / 2, getHeight() / 2));
        addEntity(healthText);

        IngredientText ingredientText = new IngredientText(new Coordinate2D(getWidth() / 2 - 60, getHeight() / 2 - 40));
        addEntity(ingredientText);

        BlackPixelCat blackPixelCat = new BlackPixelCat(new Coordinate2D(getWidth() / 2, getHeight()), healthText, ingredientText, catgame);
        addEntity(blackPixelCat);

        KattenklauwBladeren kattenklauwBladeren = new KattenklauwBladeren(new Coordinate2D(getWidth() / 2 + 20, getHeight() / 2 + 20));
        addEntity(kattenklauwBladeren);

//        ingredients.add(new MandragoraWortel());
//        ingredients.add(new KattenklauwBladeren(new Coordinate2D(getWidth() / 2, getHeight() / 2)));
////        ingredients.add(new ZwarteNachtschadeBessen()); 1
////        ingredients.add(new DrakentandPoeder());  1
////        ingredients.add(new SchedelPoeder()); 1
////        ingredients.add(new GeestelijkStof()); 1
////        ingredients.add(new GriezeligeSpinnenpoten());
////        ingredients.add(new VleermuizenBloed()); 1
////        ingredients.add(new HeksenkruidZaden()); 1
////        ingredients.add(new MaanlichtKristallen()); 1

    }
}
