package org.example;

import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.YaegerGame;
import com.github.hanyaeger.api.scenes.YaegerScene;
import org.example.scenes.levels.GameLevel;
import org.example.scenes.GameOver;
import org.example.scenes.secret.SecretScene;
import org.example.scenes.selection.SelectionScene;



/**
 * Hello world!
 */
public class Catgame extends YaegerGame {
    public static void main(String[] args) {
        launch(args);
    }




    @Override
    public void setupGame() {
        setGameTitle("Cat_Game");
        setSize(new Size(800, 600));

    }

    @Override
    public void setupScenes() {

        addScene(0, (YaegerScene) new SelectionScene(this));
        addScene(1, (YaegerScene) new SecretScene(this));
        addScene(2, (YaegerScene) new GameLevel(this));
        addScene(3, (YaegerScene) new GameOver(this));


    }
}
