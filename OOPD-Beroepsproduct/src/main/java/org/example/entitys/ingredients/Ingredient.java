package org.example.entitys.ingredients;

import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;

import java.util.List;

public interface Ingredient {
    default void onPickup(){

    };
    default String getName(){
        return null;
    };

    default void onCollision(List<Collider> list){

    };
}

