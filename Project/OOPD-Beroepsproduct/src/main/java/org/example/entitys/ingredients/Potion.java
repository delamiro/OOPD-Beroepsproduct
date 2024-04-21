package org.example.entitys.ingredients;

import org.example.scenes.levels.DonkerebosScene;

public class Potion implements IngredientIMP{
    private DonkerebosScene donkerebosScene;
//    private Text time;
    private int giveTime = 5;
    private String resource = "entitys/ingredients/potionBottel.png";

    public Potion(DonkerebosScene donkerebosScene){
        this.donkerebosScene = donkerebosScene;
//        this.time = time;
    }
    @Override
    public void onPickUp() {
        int newTime = donkerebosScene.getDisplayNumber() + giveTime;
        donkerebosScene.setDisplayNumber(newTime);
    }

    @Override
    public String getResource() {
        return resource;
    }
}
