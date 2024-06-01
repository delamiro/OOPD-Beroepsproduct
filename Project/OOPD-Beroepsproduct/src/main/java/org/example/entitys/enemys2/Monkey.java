package org.example.entitys.enemys2;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Direction;
import org.example.entitys.blackpixelcat.BlackPixelCat;
import org.example.scenes.levels.DonkerebosScene;

public class Monkey extends Enemy{
    private static final String RESOURCE = "entitys/enemys/Monkey.png";
    private static final int DAMAGE_TO_PLAYER = 1;
    private static final int SPEED = 2;
    private static final Direction DIRECTION = Direction.valueOf(180d);

    public Monkey(Coordinate2D initialLocation, BlackPixelCat blackPixelCat, DonkerebosScene donkerebosScene) {
        super(RESOURCE, initialLocation, blackPixelCat, donkerebosScene);
        setMotion(SPEED, DIRECTION);
    }

    @Override
    public void hit() {
        int newHealth = blackPixelCat.getHealth() - DAMAGE_TO_PLAYER;
        blackPixelCat.setHealth(newHealth);
    }
}
