package org.example.entitys.ingredients;

import org.example.entitys.blackpixelcat.BlackPixelCat;

public class Wortel implements IngredientIMP{
    private BlackPixelCat blackPixelCat;
    private int giveSpeed = 2;
    private String resource = "entitys/ingredients/Wortel.png";

    public Wortel(BlackPixelCat blackPixelCat) {
        this.blackPixelCat = blackPixelCat;
    }

    @Override
    public void onPickUp() {
        //sets new speed for blackpixel cat
        int newSpeed = blackPixelCat.getSpeedBlackPixelCat() + giveSpeed;
        blackPixelCat.setSpeedBlackPixelCat(newSpeed);
    }

    @Override
    public String getResource() {
        return resource;
    }
}
