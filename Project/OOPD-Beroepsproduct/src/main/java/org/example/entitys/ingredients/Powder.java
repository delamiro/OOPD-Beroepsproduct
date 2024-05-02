package org.example.entitys.ingredients;

import org.example.entitys.blackpixelcat.BlackPixelCat;

public class Powder implements IngredientIMP{
    private BlackPixelCat blackPixelCat;
    private int giveOneHp = 1;
    private String resource = "entitys/ingredients/heksenkruidzaden.png";


    public Powder(BlackPixelCat blackPixelCat){
        this.blackPixelCat = blackPixelCat;
    }
    @Override
    public void onPickUp() {
        //sets new health blackpixelcat
        int newHealth = blackPixelCat.getHealth() + giveOneHp;
        blackPixelCat.setHealth(newHealth);
    }

    @Override
    public String getResource() {
        return resource;
    }
}
