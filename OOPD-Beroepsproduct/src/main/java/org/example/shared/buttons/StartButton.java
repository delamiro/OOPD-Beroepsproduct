package org.example.shared.buttons;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import javafx.scene.input.MouseButton;
import org.example.Catgame;
import org.example.shared.buttons.SelectionButton;


public class StartButton extends SelectionButton {
    private static final String START = "Start";
    public StartButton(Coordinate2D initialLocation, final Catgame catgame){
        super(initialLocation, START, catgame, 1);
        setAnchorPoint(AnchorPoint.CENTER_CENTER);
    }

    @Override
    public void onMouseButtonPressed(MouseButton mouseButton, Coordinate2D coordinate2D) {

        catgame.setActiveScene(2);
    }
}
