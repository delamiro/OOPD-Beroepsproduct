package org.example.entitys.ingredients;

import org.example.entitys.blackpixelcat.BlackPixelCat;
import org.example.entitys.text.Text;
import org.example.scenes.levels.DonkerebosScene;

public class Potion implements IngredientIMP{
    private DonkerebosScene donkerebosScene;
//    private Text time;
    private int giveTime = 5;
    private String resource = "entitys/potionBottel.png";

    public Potion(DonkerebosScene donkerebosScene){
        this.donkerebosScene = donkerebosScene;
//        this.time = time;
    }
    @Override
    public void onPickUp() {
        int newTime = donkerebosScene.getDisplayNumber() + giveTime;
//        String newTimeText = "Time: " + String.valueOf(newTime);
        donkerebosScene.setDisplayNumber(newTime);
//        time.setText(newTimeText);



        ///get new time

        ///make string
        //set new time
        //set text
    }

    @Override
    public String getResource() {
        return resource;
    }
}
