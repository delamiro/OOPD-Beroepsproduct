package org.example.entitys.enemys;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.SceneBorderCrossingWatcher;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.api.scenes.SceneBorder;

import java.util.List;

public abstract class Enemy extends DynamicSpriteEntity implements SceneBorderCrossingWatcher, Collided, Collider {
    protected Enemy(final String resource, Coordinate2D initialLocation, final Size size) {
        super(resource, initialLocation, size);
    }
    @Override
    public abstract void notifyBoundaryCrossing(SceneBorder border);

    @Override
    public void onCollision(List<Collider> collidingObject) {
    }
}


