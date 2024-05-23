package org.example.entitys.ingredients2;

import com.github.hanyaeger.api.Coordinate2D;
import org.example.entitys.blackpixelcat.BlackPixelCat;
import org.example.scenes.levels.DonkerebosScene;

public class Carrot extends Ingredient{
    private BlackPixelCat blackPixelCat;

    public Carrot(Coordinate2D initialLocation, DonkerebosScene donkerebosScene, BlackPixelCat blackPixelCat) {
        super("entitys/ingredients/Wortel.png",initialLocation, donkerebosScene);
        this.blackPixelCat = blackPixelCat;
    }

    @Override
    public void onPickUp() {
        int newSpeed = blackPixelCat.getSpeedBlackPixelCat() + 1;
        blackPixelCat.setSpeedBlackPixelCat(newSpeed);
    }
}
