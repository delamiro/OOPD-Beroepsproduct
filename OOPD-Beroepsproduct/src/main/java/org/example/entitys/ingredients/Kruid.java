package org.example.entitys.ingredients;
import com.github.hanyaeger.api.Coordinate2D;

public class Kruid implements IngredientIMP{

    private String resource = "entitys/heksenkruidzaden.png";

    @Override
    public void onPickUp() {
        //zet ingredients gathered ++
    }

    @Override
    public String getResource() {
        return resource;
    }
}
