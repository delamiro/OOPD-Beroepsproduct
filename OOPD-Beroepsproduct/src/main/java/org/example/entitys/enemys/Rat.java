package org.example.entitys.enemys;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Direction;
import org.example.entitys.blackpixelcat.BlackPixelCat;
import org.example.entitys.text.Text;
import java.util.Random;


public class Rat implements EnemyIMP{
    private BlackPixelCat blackPixelCat;
    private Text healthbar;
    private int damageToPlayer = 2;
    private int speed = 2;
    private Direction direction = Direction.valueOf(270d);
    private String resource = "entitys/RATATA.png";
    public Rat(BlackPixelCat blackPixelCat, Text healthBar) {
        this.blackPixelCat = blackPixelCat;
        this.healthbar = healthBar;
    }

    @Override
    public void hit() {
        int newHealth = blackPixelCat.getHealth() - damageToPlayer;
        String newHealthText = "Health: " + String.valueOf(newHealth);
        blackPixelCat.setHealth(newHealth);
        healthbar.changeText(newHealthText);

        blackPixelCat.setAnchorLocation(new Coordinate2D(
                new Random().nextDouble(1024),
                new Random().nextDouble(698)
        ));
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
