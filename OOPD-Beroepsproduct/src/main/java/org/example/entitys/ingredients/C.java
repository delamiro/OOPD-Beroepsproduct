package org.example.entitys.ingredients;

import com.github.hanyaeger.api.entities.Collider;

import java.util.List;

public interface C {
    default void onPickup(){

    };
    default String getName(){
        return null;
    };

    default void onCollision(List<Collider> list){

    };
}

