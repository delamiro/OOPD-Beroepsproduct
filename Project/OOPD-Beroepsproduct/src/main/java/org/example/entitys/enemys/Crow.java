package org.example.entitys.enemys;

import com.github.hanyaeger.api.entities.Direction;
import org.example.entitys.blackpixelcat.BlackPixelCat;


public class Crow implements EnemyIMP{
    private BlackPixelCat blackPixelCat;
    private int damageToPlayer = 1;
    private int speed = 5;
    private Direction direction = Direction.valueOf(45d);
    private String resource = "entitys/enemys/Crow.png";

    public Crow(BlackPixelCat blackPixelCat) {
        this.blackPixelCat = blackPixelCat;
    }
    @Override
    public void hit() {
        int newHealth = blackPixelCat.getHealth() - damageToPlayer;
        blackPixelCat.setHealth(newHealth);
    }

    @Override
    public int getSpeed() {
        return speed;
    }

    @Override
    public Direction getDirection() {
        return direction;
    }

    @Override
    public String getResource() {
        return resource;
    }
}
