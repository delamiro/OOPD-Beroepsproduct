package org.example.scenes.levels;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.TimerContainer;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import com.github.hanyaeger.api.scenes.DynamicScene;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import org.example.Catgame;
import org.example.entitys.*;
import org.example.entitys.blackpixelcat.BlackPixelCat;
import org.example.entitys.enemys.Enemy;
import org.example.entitys.enemys.Monkey;
import org.example.entitys.enemys.Rat;
import org.example.entitys.ingredients.Ingredient;
import org.example.entitys.ingredients.Kruid;
import org.example.entitys.text.Text;
import org.example.scenes.levels.timers.SceneTimer;


import java.util.Random;


public class DonkerebosScene extends DynamicScene implements TimerContainer {
    public final int COUNTDOWN_NUMBER_START_VALUE = 30;
    private int displayNumber = COUNTDOWN_NUMBER_START_VALUE;
    private Text displayNumberText;
    private SceneTimer secondsTimer;


    public final double LEFT_MARGIN = 34;
    private final double DELTA_Y = 40;
    private BlackPixelCat blackPixelCat;
    private final Catgame catgame;
    private Rat rat;
    private Monkey monkey;
    private Kruid kruid;


    public DonkerebosScene(Catgame catgame, BlackPixelCat blackPixelCat) {
        this.catgame = catgame;
        this.blackPixelCat = blackPixelCat;
    }


    @Override
    public void setupScene() {
        setBackgroundImage("backgrounds/forrest.jpg");
    }

    @Override
    public void setupEntities() {
        //Floor walls
        var bottomFloor = new Floor(new Coordinate2D(0, 670),
                new Size(1550, 10),blackPixelCat);
        addEntity(bottomFloor);

        //Text
        var y = 20;
        Text healthBar = new Text(new Coordinate2D(LEFT_MARGIN, y));
        String healthText = "Health: " + blackPixelCat.getHealth();
        healthBar.setText(healthText);
        addEntity(healthBar);

        y += DELTA_Y;
        Text ingredientBar = new Text(new Coordinate2D(LEFT_MARGIN, y));
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
        kruid = new Kruid(blackPixelCat,healthBar,ingredientBar);
        Ingredient kruid1 = new Ingredient(returnRandomLocation(),kruid, ingredientBar);
        addEntity(kruid1);

        //Enemys
        rat = new Rat(blackPixelCat,healthBar);
        Enemy rat1 = new Enemy(new Coordinate2D(getWidth(), getHeight()-80),new Size(50,50),rat);
        addEntity(rat1);

        monkey = new Monkey(blackPixelCat,healthBar);
        Enemy Monkey1 = new Enemy(new Coordinate2D(getWidth()/2, getHeight()-80),new Size(50,50),monkey);
        addEntity(Monkey1);



    }
    public Coordinate2D returnRandomLocation(){
        return new Coordinate2D(
                new Random().nextInt(100,500),
                new Random().nextInt(100,500)
        );
    }
    public void updateTimer(){
        if (displayNumber <= 0) {
            displayNumber = COUNTDOWN_NUMBER_START_VALUE;
            catgame.setActiveScene(catgame.SCENE_GAME_OVER);
        } else {
            displayNumberText.setText("Timers: " +Integer.toString(displayNumber--));
        }
    }

    @Override
    public void setupTimers() {
        secondsTimer = new SceneTimer(this);
        addTimer(secondsTimer);
    }
}
