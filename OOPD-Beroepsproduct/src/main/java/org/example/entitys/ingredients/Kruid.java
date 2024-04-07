package org.example.entitys.ingredients;
import com.github.hanyaeger.api.Coordinate2D;
import org.example.entitys.blackpixelcat.BlackPixelCat;
import org.example.entitys.text.Text;

public class Kruid implements IngredientIMP{
    private BlackPixelCat blackPixelCat;
    private Text healthbar;
    private Text ingredientsBar;
    private int giveOneHp = 1;
    private String resource = "entitys/heksenkruidzaden.png";


    public Kruid(BlackPixelCat blackPixelCat, Text healthbar, Text ingredientsBar){
        this.blackPixelCat = blackPixelCat;
        this.healthbar = healthbar;
        this.ingredientsBar = ingredientsBar;
    }
    @Override
    public void onPickUp() {
        int newHealth = blackPixelCat.getHealth() + giveOneHp;
        String newHealthText = "Health: " + String.valueOf(newHealth);
        blackPixelCat.setHealth(newHealth);
        healthbar.changeText(newHealthText);
    }

    @Override
    public String getResource() {
        return resource;
    }
}
