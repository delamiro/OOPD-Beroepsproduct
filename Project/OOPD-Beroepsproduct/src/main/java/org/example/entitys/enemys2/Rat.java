package org.example.entitys.enemys2;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Direction;
import org.example.entitys.blackpixelcat.BlackPixelCat;
import org.example.scenes.levels.DonkerebosScene;

public class Rat extends Enemy{
    private static final String RESOURCE = "entitys/enemys/RATATA.png";
    private static final int DAMAGE_TO_PLAYER = 2;
    private static final int SPEED = 2;
    private static final Direction DIRECTION = Direction.valueOf(270d);

    public Rat(Coordinate2D initialLocation, BlackPixelCat blackPixelCat, DonkerebosScene donkerebosScene) {
        super(RESOURCE, initialLocation, blackPixelCat, donkerebosScene);
        setMotion(SPEED, DIRECTION);
    }

    @Override
    public void hit() {
        int newHealth = blackPixelCat.getHealth() - DAMAGE_TO_PLAYER;
        blackPixelCat.setHealth(newHealth);
    }
    @Override
    public void talk(){
        System.out.println("Ik ben een rat!");
    }

}
