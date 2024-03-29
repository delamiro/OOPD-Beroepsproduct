package org.example.entitys.enemys;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.scenes.SceneBorder;


public class Rat extends Enemy {
    public Rat(final Coordinate2D initialLocation) {
        super("entitys/RATATA.png", initialLocation, new Size(50,50));
        setMotion(2, 270d);
    }

    @Override
    public void notifyBoundaryCrossing(SceneBorder border) {
        changeDirection(180);
    }
}
