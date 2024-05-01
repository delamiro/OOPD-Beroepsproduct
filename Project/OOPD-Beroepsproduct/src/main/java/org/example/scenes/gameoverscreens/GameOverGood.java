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

public class GameOverGood extends StaticScene {

    private Catgame catgame;
    private SelectionButton restartButton;

    public GameOverGood(Catgame catgame) {
        this.catgame = catgame;
    }
    @Override
    public void setupScene() {
        setBackgroundImage("backgrounds/witch-cat-good.png");
    }

    @Override
    public void setupEntities() {
        var winText = new TextEntity(new Coordinate2D(getWidth()/3, getHeight() / 4), "You won!");
        winText.setAnchorPoint(AnchorPoint.CENTER_CENTER);
        winText.setFill(Color.BLACK);
        winText.setFont(Font.font("Roboto", FontWeight.SEMI_BOLD, 80));
        addEntity(winText);
//        var playAgain =  new SelectionButton(new Coordinate2D(getWidth() / 3 + 40, getHeight() / 3), "Play again",catgame, catgame.SCENE_DONKEREBOS);
//        playAgain.setFill(Color.BLACK);
//        addEntity(playAgain);

        restartButton =  new SelectionButton(catgame, catgame.SCENE_DONKEREBOS);
        Button restartButton1 = new Button(new Coordinate2D(getWidth() / 3 + 40, getHeight() / 3), "Play Again", restartButton);
        addEntity(restartButton1);
    }
}
