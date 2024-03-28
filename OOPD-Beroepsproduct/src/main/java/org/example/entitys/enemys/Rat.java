package org.example.entitys.enemys;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.SceneBorderCrossingWatcher;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.api.scenes.SceneBorder;

import java.util.List;

public class Rat extends DynamicSpriteEntity implements SceneBorderCrossingWatcher, Collided, Collider {
    private double x;
    public Rat(Coordinate2D location){
        super("entitys/RATATA.png", location , new Size(40,44));
        this.x = location.getX();
        setMotion(2, 270d);
        //movement();
    }

    @Override
    public void onCollision(List<Collider> list) {

    }

    @Override
    public void notifyBoundaryCrossing(SceneBorder sceneBorder) {
        changeDirection(180);
    }
}
