package org.example.entitys.enemys;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.SceneBorderCrossingWatcher;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.api.scenes.SceneBorder;
import org.example.entitys.blackpixelcat.BlackPixelCat;
import org.example.entitys.blackpixelcat.BlackPixelCatCollisionBox;
import org.example.entitys.text.Text;

import java.util.List;

public class Enemy extends DynamicSpriteEntity implements SceneBorderCrossingWatcher, Collided, Collider {
    private EnemyIMP enemyIMP;
    public Enemy(Coordinate2D initialLocation, final Size size, EnemyIMP enemyIMP) {
        super(enemyIMP.getResource(), initialLocation, size);
        this.enemyIMP = enemyIMP;
        setMotion(enemyIMP.getSpeed(), enemyIMP.getDirection());

    }
    @Override
    public void notifyBoundaryCrossing(SceneBorder border){
        changeDirection(180);
    };

    @Override
    public void onCollision(final List<Collider> collidingObjects) {
        for (var collider : collidingObjects) {
            if (collider instanceof BlackPixelCatCollisionBox) {
                enemyIMP.hit();
            }
        }
    }
}


