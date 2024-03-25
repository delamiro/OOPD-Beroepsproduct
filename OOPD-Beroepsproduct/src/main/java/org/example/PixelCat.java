package org.example;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.SceneBorderCrossingWatcher;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.api.scenes.SceneBorder;

public class PixelCat extends DynamicSpriteEntity implements SceneBorderCrossingWatcher {
    public PixelCat(Coordinate2D location){
        super("sprites/small_cat.png", location);
        setMotion(2, 270d);
    }

    @Override
    public void notifyBoundaryCrossing(SceneBorder sceneBorder) {
        setAnchorLocationX(getSceneWidth());
    }
}
