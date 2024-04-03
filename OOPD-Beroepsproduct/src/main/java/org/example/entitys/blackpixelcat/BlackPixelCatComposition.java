package org.example.entitys.blackpixelcat;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Direction;
import com.github.hanyaeger.api.entities.DynamicCompositeEntity;
import com.github.hanyaeger.api.entities.Newtonian;
import com.github.hanyaeger.api.userinput.KeyListener;
import javafx.scene.input.KeyCode;
import org.example.Catgame;
import org.example.entitys.*;
import org.example.entitys.enemys.Rat;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class BlackPixelCatComposition extends DynamicCompositeEntity implements KeyListener, Newtonian {
    private BlackPixelCat blackPixelCat;
    private int scene;
    private HealthText healthText;
    private IngredientText ingredientText;

    private int ingredientAmount = 0;
    private Catgame catgame;
    private int health;
    private boolean touchdown = true;
    private Set<KeyCode> latestPressedKeys = new HashSet<>();

    private static final Coordinate2D RIGHT_GROUND_ANCHOR_LOCATION = new Coordinate2D(25, 15);
    private static final Coordinate2D RIGHT_WALL_ANCHOR_LOCATION = new Coordinate2D(20, 33);
    private static final Coordinate2D LEFT_GROUND_ANCHOR_LOCATION = new Coordinate2D(40, 15);
    private static final Coordinate2D LEFT_WALL_ANCHOR_LOCATION = new Coordinate2D(35, 33);

    private boolean direction_left;


    public BlackPixelCatComposition(Coordinate2D initialLocation, final int scene, final IngredientText ingredientText, final HealthText healthText, final Catgame catgame,int health) {
        super(initialLocation);
        setAnchorPoint(AnchorPoint.BOTTOM_LEFT);
        this.scene = scene;
        this.ingredientText = ingredientText;
        this.healthText = healthText;
        this.catgame = catgame;
        this.health = health;
    }

    @Override
    protected void setupEntities() {
        blackPixelCat = new BlackPixelCat(new Coordinate2D(0, 0),this);
        addEntity(blackPixelCat);

        BlackPixelCatCollisionBox blackPixelCatCollisionBox = new BlackPixelCatCollisionBox(new Coordinate2D(0, 0), this, new Size(40,40));
        addEntity(blackPixelCatCollisionBox);

    }

    @Override
    public void onPressedKeysChange(Set<KeyCode> pressedKeys) {
        latestPressedKeys = pressedKeys;
        if(pressedKeys.contains(KeyCode.LEFT)){
            setMotion(2,270d);
            direction_left = true;
        } else if(pressedKeys.contains(KeyCode.RIGHT)){
            setMotion(2,90d);
            direction_left = false;
        } else if(pressedKeys.contains(KeyCode.UP)){
            setMotion(2,180d);
        } else if(pressedKeys.contains(KeyCode.DOWN)){
            setMotion(2,0d);
        }
    }
    public void handleCollision(final Floor ground) {
        setAnchorLocationY(ground.getBoundingBox().getMinY() + 1);
        nullifySpeedInDirection(Direction.DOWN);
        touchdown = true;

        // Since the KeyListeners event handler is only called on a KeyPressed change event,
        // we use the latestPressedKeys to manually call it and ensure the Witch will behave
        // accordingly.
        onPressedKeysChange(latestPressedKeys);
    }

    public void handleCollision(final Wall wall) {
        if(direction_left){
            setAnchorLocationX(wall.getBoundingBox().getMaxX());
            nullifySpeedInDirection(Direction.LEFT);
        } else{
            setAnchorLocationX(wall.getBoundingBox().getMinX() - 50);
            nullifySpeedInDirection(Direction.RIGHT);
        }
    }
    public void handleCollision(final Boomstronk boomstronk) {
        if(direction_left){
            setAnchorLocationX(boomstronk.getBoundingBox().getMaxX());
            nullifySpeedInDirection(Direction.LEFT);
        } else{
            setAnchorLocationX(boomstronk.getBoundingBox().getMinX() - 50);
            nullifySpeedInDirection(Direction.RIGHT);
        }
    }

    public void handleCollision(final Ingredient ingredient)
    {
        ingredientAmount++;
        ingredientText.setIngredientText(ingredientAmount);
        ingredient.remove();
        if(ingredientAmount == 5){
            if (scene == catgame.SCENE_DONKEREBOS){
                catgame.setActiveScene(scene + 1);
            } else if(scene == catgame.SCENE_HEKSENHUT){
                catgame.setActiveScene(scene + 2);
            }
        }
    }
    public void handleCollision(final Rat rat)
    {
        setAnchorLocation(new Coordinate2D(
                new Random().nextInt((int) (getSceneWidth() - getWidth())),
                new Random().nextInt((int) (getSceneHeight() - getHeight())))
        );
        health--;
        health--;
        healthText.setHealthText(health);

        if(health < 1){
            catgame.setActiveScene(4);
        }
    }
    public void handleCollision(final Slijm slijm) {
        setFrictionConstant(0);
    }
}
