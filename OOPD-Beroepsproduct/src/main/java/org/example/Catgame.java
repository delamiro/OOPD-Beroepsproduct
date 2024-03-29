package org.example;

import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.YaegerGame;
import org.example.scenes.gameoverscreens.GameOverGood;
import org.example.scenes.levels.DonkerebosScene;
import org.example.scenes.gameoverscreens.GameOverBad;
import org.example.scenes.levels.HeksenhutScene;
import org.example.scenes.secret.SecretScene;
import org.example.scenes.selection.SelectionScene;



/**
 * Hello world!
 */
public class Catgame extends YaegerGame {
    public static void main(String[] args) {
        launch(args);
    }
    public static final int SCENE_SELECTION = 0;
    public static final int SCENE_SECRET = 1;
    public static final String SCENE_SECRET_TITLE = "Secret";

    public static final String SCENE_SELECTION_TITLE = "Selection";
    public static final int SCENE_DONKEREBOS = 2;
    public static final String SCENE_DONKEREBOS_TITLE = "Donkere bos";
    public static final int SCENE_HEKSENHUT = 3;
    public static final String SCENE_HEKSENHUT_TITLE = "Heksen hut";
    public static final int SCENE_GAME_OVER = 4;
    public static final String SCENE_GAME_OVER_TITLE = "Game Over";

    public static final int SCENE_GAME_WON = 5;

    public static final String SCENE_GAME_WON_TITLE = "Game Won";




    @Override
    public void setupGame() {
        setGameTitle("Cat_Game");
        setSize(new Size(1024, 698));

    }

    @Override
    public void setupScenes() {
        var selection = new SelectionScene(this);
        addScene(SCENE_SELECTION, selection);
        var secretScene = new SecretScene(this);
        addScene(SCENE_SECRET, secretScene);
        var donkerebosScene = new DonkerebosScene(this);
        addScene(SCENE_DONKEREBOS, donkerebosScene);
        var heksenHut = new HeksenhutScene(this);
        addScene(SCENE_HEKSENHUT,heksenHut);
        var gameOver = new GameOverBad(this);
        addScene(SCENE_GAME_OVER,gameOver);
        var gameWon = new GameOverGood(this);
        addScene(SCENE_GAME_WON,gameWon);


    }
}
