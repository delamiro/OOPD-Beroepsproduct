package org.example.shared.buttons;

import com.github.hanyaeger.api.Coordinate2D;
import javafx.scene.input.MouseButton;
import javafx.scene.paint.Color;
import org.example.Catgame;
import org.example.scenes.selection.SelectionScene;
import org.example.shared.buttons.Button;

public class SelectionButton extends Button {

    protected Catgame catgame;

    public SelectionButton(Coordinate2D initialLocation, final String text, final Catgame catgame, final int scene) {
        super(new Coordinate2D(initialLocation), text, scene);
        this.catgame = catgame;

        setFill(Color.BLACK);
    }

    @Override
    public void onMouseButtonPressed(final MouseButton button, final Coordinate2D coordinate2D) {
        catgame.setActiveScene(getScene());
    }
}