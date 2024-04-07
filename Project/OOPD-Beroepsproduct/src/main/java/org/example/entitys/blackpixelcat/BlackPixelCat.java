package org.example.entitys.blackpixelcat;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.DynamicCompositeEntity;
import com.github.hanyaeger.api.entities.Newtonian;
import com.github.hanyaeger.api.userinput.KeyListener;
import javafx.scene.input.KeyCode;
import org.example.Catgame;

import java.util.HashSet;
import java.util.Set;

public class BlackPixelCat extends DynamicCompositeEntity implements KeyListener, Newtonian {
    private BlackPixelCatSprite blackPixelCat;

    private final int WALKING_SPEED = 2;
    private Catgame catgame;
    private boolean touchdown = true;
    private Set<KeyCode> latestPressedKeys = new HashSet<>();
    public int health = 10;


    public BlackPixelCat(Coordinate2D initialLocation, final Catgame catgame) {
        super(initialLocation);
        setAnchorPoint(AnchorPoint.BOTTOM_LEFT);
        this.catgame = catgame;
    }

    @Override
    protected void setupEntities() {
        blackPixelCat = new BlackPixelCatSprite(new Coordinate2D(0, 0),this);
        addEntity(blackPixelCat);

        BlackPixelCatCollisionBox blackPixelCatCollisionBox = new BlackPixelCatCollisionBox(new Coordinate2D(0, 0), this, new Size(40,40));
        addEntity(blackPixelCatCollisionBox);

    }

    @Override
    public void onPressedKeysChange(Set<KeyCode> pressedKeys) {
        latestPressedKeys = pressedKeys;

        if (touchdown && pressedKeys.isEmpty()) {
            setSpeed(0);
        }else if(pressedKeys.contains(KeyCode.LEFT)){
            setMotion(WALKING_SPEED,270d);
        } else if(pressedKeys.contains(KeyCode.RIGHT)){
            setMotion(WALKING_SPEED,90d);
        } else if(pressedKeys.contains(KeyCode.UP)){
            setMotion(WALKING_SPEED,180d);
        } else if(pressedKeys.contains(KeyCode.DOWN)){
            setMotion(WALKING_SPEED,0d);
        }
    }

    public void setHealth(int newHealth) {
        health = newHealth;
    }
    public int getHealth() {
        return health;
    }
//    public void handleCollision(final Floor ground) {
//        setAnchorLocationY(ground.getBoundingBox().getMinY() + 1);
//        nullifySpeedInDirection(Direction.DOWN);
//        touchdown = true;
//        onPressedKeysChange(latestPressedKeys);
//    }
//
//    public void handleCollision(final Wall wall) {
//        if(direction_left){
//            setAnchorLocationX(wall.getBoundingBox().getMaxX());
//            nullifySpeedInDirection(Direction.LEFT);
//        } else{
//            setAnchorLocationX(wall.getBoundingBox().getMinX() - 50);
//            nullifySpeedInDirection(Direction.RIGHT);
//        }
//    }
//    public void handleCollision(final Boomstronk boomstronk) {
//        if(direction_left){
//            setAnchorLocationX(boomstronk.getBoundingBox().getMaxX());
//            nullifySpeedInDirection(Direction.LEFT);
//        } else{
//            setAnchorLocationX(boomstronk.getBoundingBox().getMinX() - 50);
//            nullifySpeedInDirection(Direction.RIGHT);
//        }
//    }
//
//    public void handleCollision(final Ingredient ingredient)
//    {
//        ingredientAmount++;
//        ingredientText.setIngredientText(ingredientAmount);
//        ingredient.remove();
//        if(ingredientAmount == 5){
//            if (scene == catgame.SCENE_DONKEREBOS){
//                catgame.setActiveScene(scene + 1);
//            } else if(scene == catgame.SCENE_HEKSENHUT){
//                catgame.setActiveScene(scene + 2);
//            }
//        }
//    }
//    public void handleCollision(final Rat rat)
//    {
//        setAnchorLocation(new Coordinate2D(
//                new Random().nextInt((int) (getSceneWidth() - getWidth())),
//                new Random().nextInt((int) (getSceneHeight() - getHeight())))
//        );
//        health--;
//        health--;
//        healthText.setHealthText(health);
//
//        if(health < 1){
//            catgame.setActiveScene(4);
//        }
//    }
//    public void handleCollision(final Slijm slijm) {
//        setFrictionConstant(0);
//    }
}
