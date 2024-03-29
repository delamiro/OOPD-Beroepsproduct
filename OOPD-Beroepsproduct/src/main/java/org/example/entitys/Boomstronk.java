package org.example.entitys;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.impl.SpriteEntity;

public class Boomstronk extends SpriteEntity {

    public Boomstronk(Coordinate2D initialLocation, Size size) {
        super("entitys/treetrunk.png",initialLocation, size);
    }

}
