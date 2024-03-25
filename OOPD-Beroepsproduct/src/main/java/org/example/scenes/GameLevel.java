package org.example.scenes;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.scenes.DynamicScene;
import org.example.Catgame;
import org.example.entitys.PixelCat;
import org.example.entitys.BlackPixelCat;
import org.example.entitys.HealthText;

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

        HealthText healthText = new HealthText(new Coordinate2D(getWidth() / 2, getHeight() / 2));
        addEntity(healthText);

        BlackPixelCat blackPixelCat = new BlackPixelCat(new Coordinate2D(getWidth() / 2, getHeight() / 2), healthText, catgame);
        addEntity(blackPixelCat);
    }
}
