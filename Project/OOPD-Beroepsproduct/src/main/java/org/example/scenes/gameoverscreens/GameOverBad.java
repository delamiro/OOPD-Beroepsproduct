package org.example.scenes.gameoverscreens;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import com.github.hanyaeger.api.scenes.StaticScene;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import org.example.Catgame;
import org.example.shared.buttons.Button;
import org.example.shared.buttons.SelectionButton;

public class GameOverBad extends StaticScene {
    private Catgame catgame;
    private SelectionButton restartButton;
    public GameOverBad(Catgame catgame) {
        this.catgame = catgame;
    }
    @Override
    public void setupScene() {
        setBackgroundAudio("sounds/hampter.mp3");
        setBackgroundImage("backgrounds/badEnding.jpg");
    }

    @Override
    public void setupEntities() {
        var loseText = new TextEntity(new Coordinate2D(getWidth()/2, getHeight() / 2 -90), "You lost.");
        loseText.setAnchorPoint(AnchorPoint.CENTER_CENTER);
        loseText.setFill(Color.WHITESMOKE);
        loseText.setFont(Font.font("Roboto", FontWeight.SEMI_BOLD, 80));
        addEntity(loseText);
        restartButton =  new SelectionButton(catgame, catgame.SCENE_SELECTION);
        Button restartButton1 = new Button(new Coordinate2D(getWidth() / 2, getHeight() / 2), "Try again", restartButton);
        addEntity(restartButton1);
    }
}
