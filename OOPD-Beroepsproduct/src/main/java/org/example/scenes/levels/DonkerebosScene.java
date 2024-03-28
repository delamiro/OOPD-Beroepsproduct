package org.example.scenes.levels;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.scenes.DynamicScene;
import org.example.Catgame;
import org.example.entitys.IngredientText;
import org.example.entitys.blackpixelcat.BlackPixelCat;
import org.example.entitys.HealthText;
import org.example.entitys.enemys.Rat;
import org.example.entitys.ingredients.KattenklauwBladeren;
import org.example.entitys.obstacle.Boomstronk;


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


        KattenklauwBladeren kattenklauwBladeren = new KattenklauwBladeren(new Coordinate2D(getWidth() / 2 + 20, getHeight() / 2 + 20));
        addEntity(kattenklauwBladeren);
        BlackPixelCat blackPixelCat = new BlackPixelCat(new Coordinate2D(getWidth() / 2, getHeight()), healthText, ingredientText, catgame);

        Boomstronk boomstronk = new Boomstronk(new Coordinate2D(getWidth() / 2 + 20, getHeight()- 100),blackPixelCat);

        Rat rat = new Rat(new Coordinate2D(getWidth(), getHeight()-44));
        //addEntity(rat);


        addEntity(boomstronk);
        addEntity(blackPixelCat);
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
