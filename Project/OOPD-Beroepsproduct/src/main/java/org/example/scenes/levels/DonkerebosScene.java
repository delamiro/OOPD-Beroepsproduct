package org.example.scenes.levels;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.TimerContainer;
import com.github.hanyaeger.api.scenes.DynamicScene;
import org.example.Catgame;
import org.example.entitys.*;
import org.example.entitys.blackpixelcat.BlackPixelCat;
import org.example.entitys.enemys.Crow;
import org.example.entitys.enemys.Enemy;
import org.example.entitys.enemys.Monkey;
import org.example.entitys.enemys.Rat;
import org.example.entitys.ingredients.Powder;
import org.example.entitys.ingredients.Potion;
import org.example.entitys.ingredients.Carrot;
import org.example.entitys.ingredients2.Ingredient;
import org.example.entitys.text.Text;
import org.example.scenes.levels.timers.SceneTimer;


import java.util.Random;


public class DonkerebosScene extends DynamicScene implements TimerContainer {
    private final int COUNTDOWN_NUMBER_START_VALUE = 30;
    private int displayNumber = COUNTDOWN_NUMBER_START_VALUE;
    private Text displayNumberText;
    private SceneTimer secondsTimer;
    private int ingredientsGrabbed = 0;
    private Text healthBar;
    private Text ingredientBar;
    private final double LEFT_MARGIN = 34;
    private final double DELTA_Y = 40;
    private BlackPixelCat blackPixelCat;
    private final Catgame catgame;
    private Rat rat;
    private Monkey monkey;
    private Powder powder;
    private Potion potion;
    private Carrot carrot;
    private Crow crow;

    public DonkerebosScene(Catgame catgame) {
        this.catgame = catgame;
    }


    @Override
    public void setupScene() {
        setBackgroundImage("backgrounds/forrest.jpg");
        ingredientsGrabbed = 0;
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
        String ingredientBarText = "Ingredients: " + ingredientsGrabbed;
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
        Ingredient carrot = new org.example.entitys.ingredients2.Carrot(returnRandomLocation(), this,blackPixelCat);
        addEntity(carrot);

        Ingredient carrot2 = new org.example.entitys.ingredients2.Carrot(returnRandomLocation(), this,blackPixelCat);
        addEntity(carrot2);
        //        powder = new Powder(blackPixelCat);
//        Ingredient kruid1 = new Ingredient(returnRandomLocation(), powder,this);
//        addEntity(kruid1);
//
//        potion = new Potion(this);
//        Ingredient potion1 = new Ingredient(returnRandomLocation(),potion,this );
//        addEntity(potion1);
//
//        carrot = new Carrot(blackPixelCat);
//        Ingredient wortel1 = new Ingredient(returnRandomLocation(), carrot,this );
//        addEntity(wortel1);

        //Enemys
        rat = new Rat(blackPixelCat);
        Enemy rat1 = new Enemy(new Coordinate2D(getWidth(), getHeight()-80),rat,this);
        addEntity(rat1);

        monkey = new Monkey(blackPixelCat);
        Enemy Monkey1 = new Enemy(new Coordinate2D(getWidth()/2, getHeight()-80),monkey,this);
        addEntity(Monkey1);

        crow = new Crow(blackPixelCat);
        Enemy Crow1 = new Enemy(new Coordinate2D(getWidth()/2, getHeight()-80),crow,this);
        addEntity(Crow1);

    }

    public void setBlackPixelCatRandom() {
        blackPixelCat.setAnchorLocation(returnRandomLocation());
    }

    public void updateHealthText(){
        healthBar.setText("Health: " + blackPixelCat.getHealth());
    }

    public void updateIngredientsText(){
        ingredientBar.setText("Ingredients: " + ingredientsGrabbed);
    }

    public void checkForWinOrLose(){
        // win condition
        if (ingredientsGrabbed == 3){
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
                new Random().nextDouble(900),
                new Random().nextDouble(500)
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

    public void upIngredientsGrabbed(){
        ingredientsGrabbed++;
    }
}
