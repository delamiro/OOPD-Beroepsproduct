package org.example;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.YaegerGame;
import org.example.entitys.blackpixelcat.BlackPixelCat;
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
//    public final int SCENE_HEKSENHUT = 2;
    public final int SCENE_GAME_OVER = 3;
    public final int SCENE_GAME_WON = 4;


    @Override
    public void setupGame() {
        setGameTitle("Cat_Game");
        setSize(new Size(1024, 698));

    }

    @Override
    public void setupScenes() {
        var selection = new SelectionScene(this);
        addScene(SCENE_SELECTION, selection);

        var blackPixelCat = new BlackPixelCat(new Coordinate2D(0,0));

        var donkerebosScene = new DonkerebosScene(this, blackPixelCat);
        addScene(SCENE_DONKEREBOS, donkerebosScene);
//        var heksenHut = new HeksenhutScene(this);
//        addScene(SCENE_HEKSENHUT,heksenHut);
        var gameOver = new GameOverBad(this);
        addScene(SCENE_GAME_OVER,gameOver);
        var gameWon = new GameOverGood(this);
        addScene(SCENE_GAME_WON,gameWon);
    }
}
