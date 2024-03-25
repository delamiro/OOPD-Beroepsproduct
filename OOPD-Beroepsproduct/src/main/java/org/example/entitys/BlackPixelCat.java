package org.example.entitys;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.*;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.api.scenes.SceneBorder;
import com.github.hanyaeger.api.userinput.KeyListener;
import javafx.scene.input.KeyCode;
import org.example.Catgame;

import java.util.List;
import java.util.Random;
import java.util.Set;

public class BlackPixelCat extends DynamicSpriteEntity implements KeyListener, SceneBorderCrossingWatcher, SceneBorderTouchingWatcher, Newtonian, Collided, Collider {
    private HealthText healthText;
    Catgame catgame;
    private int health = 2;
    public BlackPixelCat(Coordinate2D location, HealthText healthText,Catgame catgame){

        super("sprites/blacCatPixel.png", location, new Size(20,40), 1, 2);
        setGravityConstant(1);
        setFrictionConstant(0.04);
        this.healthText = healthText;
        this.catgame = catgame;
        healthText.setHealthText(health);
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
        setAnchorLocation(new Coordinate2D(
                new Random().nextInt((int)(getSceneWidth()-getWidth())),
                new Random().nextInt((int)(getSceneHeight()-getHeight())))
        );

        health--;
        healthText.setHealthText(health);
        if(health < 0){
            catgame.setActiveScene(1);
        }
    }

}
