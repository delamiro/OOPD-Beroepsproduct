package org.example.scenes;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.scenes.StaticScene;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import org.example.Catgame;
import org.example.entitys.StartButton;

public class TitleScene extends StaticScene {

    private static final String HAMTER_TEXT = "PLEASE GIVE ME A 10";
    private Catgame catgame;
    public TitleScene(Catgame catgame) {
        this.catgame = catgame;
    }

    @Override
    public void setupScene() {
        //setBackgroundAudio("sounds/hampter.mp3");
       // setBackgroundImage("backgrounds/hampter.jpg");

    }

    @Override
    public void setupEntities() {

        StartButton startButton = new StartButton(new Coordinate2D(getWidth() / 2, getHeight() / 2), catgame);
        startButton.setAnchorPoint(AnchorPoint.CENTER_CENTER);
        startButton.setFill(Color.BLACK);
        startButton.setFont(Font.font("Roboto", FontWeight.SEMI_BOLD, 80));

        addEntity(startButton);
    }
}
