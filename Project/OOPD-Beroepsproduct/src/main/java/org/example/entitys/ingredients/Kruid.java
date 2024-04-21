package org.example.entitys.ingredients;

import org.example.entitys.blackpixelcat.BlackPixelCat;

public class Kruid implements IngredientIMP{
    private BlackPixelCat blackPixelCat;
    private int giveOneHp = 1;
    private String resource = "entitys/ingredients/heksenkruidzaden.png";


    public Kruid(BlackPixelCat blackPixelCat){
        this.blackPixelCat = blackPixelCat;
    }
    @Override
    public void onPickUp() {
        int newHealth = blackPixelCat.getHealth() + giveOneHp;
        blackPixelCat.setHealth(newHealth);
    }

    @Override
    public String getResource() {
        return resource;
    }
}
