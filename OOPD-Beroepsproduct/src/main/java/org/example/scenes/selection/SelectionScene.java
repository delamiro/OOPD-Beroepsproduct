package org.example.scenes.selection;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.scenes.StaticScene;
import org.example.Catgame;
import org.example.shared.buttons.QuitButton;
import org.example.shared.buttons.StartButton;

public class SelectionScene extends StaticScene {

    private final Catgame catgame;

    public SelectionScene(final Catgame catgame) {
        this.catgame = catgame;
    }


    @Override
    public void setupScene() {

    }

    @Override
    public void setupEntities() {

        var startButton = new StartButton(new Coordinate2D(getWidth() / 2, getHeight() / 2), catgame);
        addEntity(startButton);

        var quitButton = new QuitButton(new Coordinate2D(getWidth() / 2, getHeight() / 2 + 50), catgame);
        addEntity(quitButton);
    }
}