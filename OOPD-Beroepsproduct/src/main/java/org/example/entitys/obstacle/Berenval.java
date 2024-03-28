package org.example.entitys.obstacle;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Timer;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;

import java.util.List;

public class Berenval extends DynamicSpriteEntity implements Collided, Collider {
    protected Berenval(String resource, Coordinate2D initialLocation) {
        super("entitys/berenvalOpen", initialLocation);
    }

    @Override
    public void onCollision(List<Collider> list) {

    }
}
