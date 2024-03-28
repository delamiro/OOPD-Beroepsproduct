package org.example.shared.buttons;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import javafx.scene.input.MouseButton;
import org.example.Catgame;

public class QuitButton extends SelectionButton {
    private static final String QUIT = "Quit";
    public QuitButton(Coordinate2D initialLocation, final Catgame catgame){
        super(initialLocation, QUIT, catgame, -1);
        setAnchorPoint(AnchorPoint.CENTER_CENTER);
    }

    @Override
    public void onMouseButtonPressed(MouseButton mouseButton, Coordinate2D coordinate2D) {
        catgame.quit();
    }
}
