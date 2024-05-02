package org.example.shared.buttons;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import javafx.scene.Scene;
import javafx.scene.input.MouseButton;
import javafx.scene.paint.Color;
import org.example.Catgame;
import org.example.scenes.selection.SelectionScene;
import org.example.shared.buttons.Button;

public class SelectionButton implements ButtonIMP {

    private int newScene;
    private Catgame catgame;
    public SelectionButton(final Catgame catgame, final int newScene) {
        this.catgame = catgame;
        this.newScene = newScene;
    }

    @Override
    public void doAction() {
        if (newScene == -1) {
            catgame.quit();
        }
        else {
            catgame.setActiveScene(newScene);
        }
    }
}