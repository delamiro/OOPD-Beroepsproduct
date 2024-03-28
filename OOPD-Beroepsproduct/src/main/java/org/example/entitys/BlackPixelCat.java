package org.example.entitys;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.*;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.api.scenes.SceneBorder;
import com.github.hanyaeger.api.userinput.KeyListener;
import javafx.scene.input.KeyCode;
import org.example.Catgame;
import org.example.entitys.enemys.PixelCat;
import org.example.entitys.enemys.Rat;
import org.example.entitys.ingredients.Ingredient;

import java.util.List;
import java.util.Random;
import java.util.Set;

public class BlackPixelCat extends DynamicSpriteEntity implements KeyListener, SceneBorderCrossingWatcher, SceneBorderTouchingWatcher, Newtonian, Collided, Collider {
    private HealthText healthText;
    private IngredientText ingredientText;
    Catgame catgame;
    private int health = 2;
    private int ingredientsToGo = 0;
    public BlackPixelCat(Coordinate2D location, HealthText healthText, IngredientText ingredientText, Catgame catgame){

        super("sprites/blacCatPixel.png", location, new Size(40,80), 1, 2);
        setGravityConstant(1);
        setFrictionConstant(0.04);
        this.healthText = healthText;
        this.ingredientText = ingredientText;
        this.catgame = catgame;
        healthText.setHealthText(health);
        ingredientText.setIngredientText(ingredientsToGo);
    }

    @Override
    public void onPressedKeysChange(Set<KeyCode> pressedKeys){
        if(pressedKeys.contains(KeyCode.LEFT)){
            setMotion(3,270d);
            setCurrentFrameIndex(0);
        } else if(pressedKeys.contains(KeyCode.RIGHT)){
            setMotion(3,90d);
            setCurrentFrameIndex(1);
        } else if(pressedKeys.contains(KeyCode.UP)){
            setMotion(3,180d);
        } else if(pressedKeys.contains(KeyCode.DOWN)){
            setMotion(3,0d);
        }
    }

    @Override
    public void notifyBoundaryTouching(SceneBorder border){
        setSpeed(0);

        switch(border){
            case TOP:
                setAnchorLocationY(1);
                break;
            case BOTTOM:
                setAnchorLocationY(getSceneHeight() - getHeight() - 1);
                break;
            case LEFT:
                setAnchorLocationX(1);
                break;
            case RIGHT:
                setAnchorLocationX(getSceneWidth() - getWidth() - 1);
            default:
                break;
        }

    }

    @Override
    public void notifyBoundaryCrossing(SceneBorder sceneBorder) {

    }
    @Override
    public void onCollision(List<Collider> collidingObject){

        for (var collider : collidingObject) {
            if (collider instanceof Ingredient) {
                ingredientsToGo++;
                ingredientText.setIngredientText(ingredientsToGo);


            } else if (collider instanceof PixelCat){
                setAnchorLocation(new Coordinate2D(
                        new Random().nextInt((int) (getSceneWidth() - getWidth())),
                        new Random().nextInt((int) (getSceneHeight() - getHeight())))
                );
                health--;
                healthText.setHealthText(health);
            }
            else if (collider instanceof Rat){
                setAnchorLocation(new Coordinate2D(
                        new Random().nextInt((int) (getSceneWidth() - getWidth())),
                        new Random().nextInt((int) (getSceneHeight() - getHeight())))
                );
                health--;
                healthText.setHealthText(health);
            }

        }

        if(health < 0){
            catgame.setActiveScene(4);
        }
    }
}
