package org.example.scenes.selection;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.scenes.StaticScene;
import org.example.Catgame;
import org.example.shared.buttons.Button;
import org.example.shared.buttons.SelectionButton;

public class SelectionScene extends StaticScene {

    private final Catgame catgame;
    private SelectionButton startButton;
    private SelectionButton endButton;

    public SelectionScene(final Catgame catgame) {
        this.catgame = catgame;
    }


    @Override
    public void setupScene() {
        setBackgroundImage("backgrounds/witchhatcat.jpg");
    }

    @Override
    public void setupEntities() {
        //Buttons
        startButton = new SelectionButton(catgame, catgame.SCENE_DONKEREBOS);
        Button startButton1 = new Button(new Coordinate2D(getWidth() / 2, getHeight() / 2), "Start", startButton);
        addEntity(startButton1);

        endButton = new SelectionButton(catgame, catgame.SCENE_QUIT_GAME);
        Button endButton1 = new Button(new Coordinate2D(getWidth() / 2, (getHeight() / 2) + 50), "Quit", endButton);

        addEntity(endButton1);
    }
}