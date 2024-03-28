package org.example.entitys.obstacle;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.impl.SpriteEntity;
import org.example.entitys.blackpixelcat.BlackPixelCat;

import java.util.List;

public class Boomstronk extends SpriteEntity implements Collided, Collider {

    BlackPixelCat blackpixelcat;
    public Boomstronk(Coordinate2D initialLocation, BlackPixelCat blackPixelCat) {
        super("entitys/treetrunk.png",initialLocation);
        this.blackpixelcat = blackPixelCat;
    }

    @Override
    public void onCollision(List<Collider> list) {
        blackpixelcat.setSpeed(0);
    }
}
