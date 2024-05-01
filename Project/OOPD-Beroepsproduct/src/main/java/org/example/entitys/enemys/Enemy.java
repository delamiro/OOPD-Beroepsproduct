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
import org.example.scenes.levels.DonkerebosScene;

import java.util.List;
import java.util.Random;

public class Enemy extends DynamicSpriteEntity implements SceneBorderCrossingWatcher, Collided, Collider {
    private EnemyIMP enemyIMP;
    private DonkerebosScene donkerebosScene;

    public Enemy(Coordinate2D initialLocation, EnemyIMP enemyIMP, DonkerebosScene donkerebosScene) {
        super(enemyIMP.getResource(), initialLocation, new Size(50,50));
        this.enemyIMP = enemyIMP;
        this.donkerebosScene = donkerebosScene;
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
                donkerebosScene.checkForWinOrLose();
                donkerebosScene.updateHealthText();
                donkerebosScene.setBlackPixelCatRandom();
            }
        }
    }
}


