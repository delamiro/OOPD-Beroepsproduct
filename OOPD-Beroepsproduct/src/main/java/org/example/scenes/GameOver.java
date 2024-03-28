package org.example.scenes;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.scenes.StaticScene;
import org.example.Catgame;
import org.example.shared.buttons.SelectionButton;

public class GameOver extends StaticScene {
    private Catgame catgame;
    public GameOver(Catgame catgame) {
        this.catgame = catgame;
    }
    @Override
    public void setupScene() {

    }

    @Override
    public void setupEntities() {
        var restartButton =  new SelectionButton(new Coordinate2D(getWidth() / 2, getHeight() / 2), "Try again",catgame,2);
        addEntity(restartButton);
    }
}
