package org.example;

import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.YaegerGame;
import org.example.scenes.gameoverscreens.GameOverGood;
import org.example.scenes.levels.DonkerebosScene;
import org.example.scenes.gameoverscreens.GameOverBad;
import org.example.scenes.selection.SelectionScene;



/**
 * Hello world!
 */
public class Catgame extends YaegerGame {
    public static void main(String[] args) {
        launch(args);
    }
    public  final int SCENE_SELECTION = 0;
    public  final int SCENE_DONKEREBOS = 1;
    public final int SCENE_GAME_OVER = 2;
    public final int SCENE_GAME_WON = 3;
    public final int SCENE_QUIT_GAME = -1;


    @Override
    public void setupGame() {
        setGameTitle("Cat_Game");
        setSize(new Size(1024, 698));

    }

    @Override
    public void setupScenes() {
        var selection = new SelectionScene(this);
        addScene(SCENE_SELECTION, selection);
        var donkerebosScene = new DonkerebosScene(this);
        addScene(SCENE_DONKEREBOS, donkerebosScene);
        var gameOver = new GameOverBad(this);
        addScene(SCENE_GAME_OVER,gameOver);
        var gameWon = new GameOverGood(this);
        addScene(SCENE_GAME_WON,gameWon);
    }
}
