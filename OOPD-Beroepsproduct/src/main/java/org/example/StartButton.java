package org.example;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import com.github.hanyaeger.api.userinput.MouseButtonPressedListener;
import javafx.scene.input.MouseButton;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;


public class StartButton extends TextEntity implements MouseButtonPressedListener {
    private Catgame catgame;
    public StartButton(Coordinate2D initialLocation, Catgame catgame){
        super(initialLocation,"Play game");
        setFill(Color.PURPLE);
        setFont(Font.font("Roboto", FontWeight.BOLD, 30));

        this.catgame = catgame;
    }

    @Override
    public void onMouseButtonPressed(MouseButton mouseButton, Coordinate2D coordinate2D) {
        catgame.setActiveScene(2);
    }
}
