package org.example.entitys.ingredients;
import org.example.entitys.blackpixelcat.BlackPixelCat;
import org.example.entitys.text.Text;

public class Kruid implements IngredientIMP{
    private BlackPixelCat blackPixelCat;
    private Text healthbar;
    private int giveOneHp = 1;
    private String resource = "entitys/heksenkruidzaden.png";


    public Kruid(BlackPixelCat blackPixelCat, Text healthbar){
        this.blackPixelCat = blackPixelCat;
        this.healthbar = healthbar;
    }
    @Override
    public void onPickUp() {
        int newHealth = blackPixelCat.getHealth() + giveOneHp;
        String newHealthText = "Health: " + String.valueOf(newHealth);
        blackPixelCat.setHealth(newHealth);
        healthbar.setText(newHealthText);
    }

    @Override
    public String getResource() {
        return resource;
    }
}
