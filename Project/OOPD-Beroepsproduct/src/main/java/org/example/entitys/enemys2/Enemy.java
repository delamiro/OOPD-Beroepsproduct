package org.example.entitys.enemys2;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.SceneBorderCrossingWatcher;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.api.scenes.SceneBorder;
import org.example.entitys.blackpixelcat.BlackPixelCat;
import org.example.scenes.levels.DonkerebosScene;

import java.util.List;

public abstract class Enemy extends DynamicSpriteEntity implements SceneBorderCrossingWatcher, Collided, Collider {
    protected BlackPixelCat blackPixelCat;
    protected DonkerebosScene donkerebosScene;

    public Enemy(String resource, Coordinate2D initialLocation, BlackPixelCat blackPixelCat, DonkerebosScene donkerebosScene) {
        super(resource, initialLocation, new Size(50,50));
        this.blackPixelCat = blackPixelCat;
        this.donkerebosScene = donkerebosScene;
    }
    @Override
    public void notifyBoundaryCrossing(SceneBorder border){
        changeDirection(180);
    }

    @Override
    public void onCollision(final List<Collider> collidingObjects) {
        for (var collider : collidingObjects) {
            if (collider instanceof BlackPixelCat) {
                hit();
                donkerebosScene.checkForWinOrLose();
                donkerebosScene.updateHealthText();
                donkerebosScene.setBlackPixelCatRandom();
            }
        }
    }
    public abstract void hit();
}
