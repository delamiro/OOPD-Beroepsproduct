package org.example.entitys.enemys;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.SceneBorderCrossingWatcher;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.api.scenes.SceneBorder;
import org.example.entitys.blackpixelcat.BlackPixelCat;
import org.example.entitys.text.Text;

import java.util.List;
import java.util.Random;

public class Enemy extends DynamicSpriteEntity implements SceneBorderCrossingWatcher, Collided, Collider {
    private EnemyIMP enemyIMP;
    private BlackPixelCat blackPixelCat;
    private Text healthbar;
    public Enemy(Coordinate2D initialLocation, final Size size, EnemyIMP enemyIMP, BlackPixelCat blackPixelCat, Text Healthbar) {
        super(enemyIMP.getResource(), initialLocation, size);
        this.enemyIMP = enemyIMP;
        this.blackPixelCat = blackPixelCat;
        this.healthbar = Healthbar;
        setMotion(enemyIMP.getSpeed(), enemyIMP.getDirection());

    }
    @Override
    public void notifyBoundaryCrossing(SceneBorder border){
        changeDirection(180);
    };

    @Override
    public void onCollision(final List<Collider> collidingObjects) {
        for (var collider : collidingObjects) {
            if (collider instanceof BlackPixelCat) {
                enemyIMP.hit();
                healthbar.setText("Health: " + blackPixelCat.getHealth());
                blackPixelCat.setAnchorLocation(new Coordinate2D(
                        new Random().nextDouble(1024),
                        new Random().nextDouble(698)
                ));
            }
        }
    }
}


