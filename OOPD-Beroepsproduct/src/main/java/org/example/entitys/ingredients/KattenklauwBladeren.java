package org.example.entitys.ingredients;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.impl.SpriteEntity;

import java.util.List;

public class KattenklauwBladeren extends SpriteEntity implements Ingredient, Collider, Collided {

    public KattenklauwBladeren(Coordinate2D location){
        super("entitys/kattenklauwBladeren.png", location);
    }
    @Override
    public String getName() {
        return "Kattenklauw Bladeren";
    }

    @Override
    public void onPickup() {
        // when picked up

    }
    @Override
    public void onCollision(List<Collider> collidingObject){
        remove();
    }




}
