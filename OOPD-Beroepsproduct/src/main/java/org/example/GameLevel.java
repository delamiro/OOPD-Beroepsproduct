package org.example;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.scenes.DynamicScene;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class GameLevel extends DynamicScene {
    Catgame catgame;
    public GameLevel(Catgame catgame) {
        this.catgame = catgame;
    }
    @Override
    public void setupScene() {

    }

    @Override
    public void setupEntities() {

        PixelCat pixelcat = new PixelCat(new Coordinate2D(getWidth() / 2, getHeight() / 2));
        //pixelcat.setAnchorPoint(AnchorPoint.CENTER_CENTER);
        addEntity(pixelcat);
    }
}
