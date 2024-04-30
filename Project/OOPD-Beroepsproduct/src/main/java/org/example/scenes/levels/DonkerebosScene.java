package org.example.scenes.levels;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.TimerContainer;
import com.github.hanyaeger.api.UpdateExposer;
import com.github.hanyaeger.api.scenes.DynamicScene;
import org.example.Catgame;
import org.example.entitys.*;
import org.example.entitys.blackpixelcat.BlackPixelCat;
import org.example.entitys.enemys.Crow;
import org.example.entitys.enemys.Enemy;
import org.example.entitys.enemys.Monkey;
import org.example.entitys.enemys.Rat;
import org.example.entitys.ingredients.Ingredient;
import org.example.entitys.ingredients.Kruid;
import org.example.entitys.ingredients.Potion;
import org.example.entitys.text.Text;
import org.example.scenes.levels.timers.SceneTimer;


import java.util.Random;


public class DonkerebosScene extends DynamicScene implements TimerContainer {
    public final int COUNTDOWN_NUMBER_START_VALUE = 30;
    private int displayNumber = COUNTDOWN_NUMBER_START_VALUE;
    private Text displayNumberText;
    private SceneTimer secondsTimer;

    private Text healthBar;
    private Text ingredientBar;
    public final double LEFT_MARGIN = 34;
    private final double DELTA_Y = 40;
    private BlackPixelCat blackPixelCat;
    private final Catgame catgame;
    private Rat rat;
    private Monkey monkey;
    private Kruid kruid;
    private Potion potion;
    private Crow crow;


    public DonkerebosScene(Catgame catgame) {
        this.catgame = catgame;
    }


    @Override
    public void setupScene() {
        setBackgroundImage("backgrounds/forrest.jpg");
    }

    @Override
    public void setupEntities() {
        blackPixelCat = new BlackPixelCat(new Coordinate2D(0,0));
        //Floor walls
        var bottomFloor = new Floor(new Coordinate2D(0, 670),
                new Size(1550, 10),blackPixelCat);
        addEntity(bottomFloor);

        //Text
        var y = 20;
        healthBar = new Text(new Coordinate2D(LEFT_MARGIN, y));
        String healthText = "Health: " + blackPixelCat.getHealth();
        healthBar.setText(healthText);
        addEntity(healthBar);

        y += DELTA_Y;
        ingredientBar = new Text(new Coordinate2D(LEFT_MARGIN, y));
        String ingredientBarText = "Ingredients: " + Ingredient.getIngredientsGrabbed();
        ingredientBar.setText(ingredientBarText);
        addEntity(ingredientBar);

        y += DELTA_Y;
        displayNumberText = new Text(new Coordinate2D(LEFT_MARGIN, y));
        String timerText = "Timers: " + Integer.toString(displayNumber);
        displayNumberText.setText(timerText);
        addEntity(displayNumberText);

        //PixelCat
        addEntity(blackPixelCat);


        //Ingredient
        kruid = new Kruid(blackPixelCat);
        Ingredient kruid1 = new Ingredient(returnRandomLocation(),kruid,this);
        addEntity(kruid1);

        potion = new Potion(this);
        Ingredient potion1 = new Ingredient(returnRandomLocation(),potion,this );
        addEntity(potion1);

        //Enemys
        rat = new Rat(blackPixelCat);
        Enemy rat1 = new Enemy(new Coordinate2D(getWidth(), getHeight()-80),new Size(50,50),rat,this);
        addEntity(rat1);

        monkey = new Monkey(blackPixelCat);
        Enemy Monkey1 = new Enemy(new Coordinate2D(getWidth()/2, getHeight()-80),new Size(50,50),monkey,this);
        addEntity(Monkey1);

        crow = new Crow(blackPixelCat);
        Enemy Crow1 = new Enemy(new Coordinate2D(getWidth()/2, getHeight()-80),new Size(50,50),crow,this);
        addEntity(Crow1);

    }

    public void setBlackPixelCatRandom() {
        blackPixelCat.setAnchorLocation(new Coordinate2D(
                new Random().nextDouble(1024),
                new Random().nextDouble(698)
        ));
    }

    public void updateHealthText(){
        healthBar.setText("Health: " + blackPixelCat.getHealth());
    }

    public void updateIngredientsText(){
        ingredientBar.setText("Ingredients: " + Ingredient.getIngredientsGrabbed());
    }

    public void checkForWinOrLose(){
        // win condition
        if (Ingredient.getIngredientsGrabbed() == 2){
            catgame.setActiveScene(catgame.SCENE_GAME_WON);
        }
        // lose condition health
        else if (blackPixelCat.getHealth() < 0) {
            catgame.setActiveScene(catgame.SCENE_GAME_OVER);
        }
        // lose condition time
        else if(displayNumber <= 0){
            catgame.setActiveScene(catgame.SCENE_GAME_OVER);
        }
    }

    public Coordinate2D returnRandomLocation(){
        return new Coordinate2D(
                new Random().nextInt(100,500),
                new Random().nextInt(100,500)
        );
    }
    public void updateTimer(){
        if (displayNumber <= 0) {
            checkForWinOrLose();
            displayNumber = COUNTDOWN_NUMBER_START_VALUE;
        } else {
            displayNumberText.setText("Timers: " +Integer.toString(displayNumber--));
        }
    }

    @Override
    public void setupTimers() {
        secondsTimer = new SceneTimer(this);
        addTimer(secondsTimer);
    }

    public int getDisplayNumber() {
        return displayNumber;
    }

    public void setDisplayNumber(int displayNumber) {
        this.displayNumber = displayNumber;
    }
}
