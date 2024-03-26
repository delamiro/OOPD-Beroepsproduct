package org.example.scenes.secret;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import com.github.hanyaeger.api.scenes.StaticScene;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import org.example.Catgame;

public class SecretScene extends StaticScene {
    private static final String HAMTER_TEXT = "PLEASE GIVE ME A 10";

    public SecretScene(Catgame app) {
    }

    @Override
    public void setupScene() {
        setBackgroundAudio("sounds/hampter.mp3");
        setBackgroundImage("backgrounds/hampter.jpg");

    }

    @Override
    public void setupEntities() {
        var hamterText = new TextEntity(
                new Coordinate2D(getWidth() / 2, getHeight() / 2),
                HAMTER_TEXT
        );
        hamterText.setAnchorPoint(AnchorPoint.CENTER_CENTER);
        hamterText.setFill(Color.BLACK);
        hamterText.setFont(Font.font("Roboto", FontWeight.SEMI_BOLD, 80));
        addEntity(hamterText);

    }
}
