package org.example.entitys.blackpixelcat;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.Newtonian;
import com.github.hanyaeger.api.entities.SceneBorderTouchingWatcher;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.api.scenes.SceneBorder;
import com.github.hanyaeger.api.userinput.KeyListener;
import javafx.scene.input.KeyCode;

import java.util.HashSet;
import java.util.Set;

public class BlackPixelCat extends DynamicSpriteEntity implements KeyListener, Newtonian, Collider, SceneBorderTouchingWatcher {
    private int speed = 2;
    private boolean touchdown = true;
    private Set<KeyCode> latestPressedKeys = new HashSet<>();
    public int health = 10;
    public BlackPixelCat(Coordinate2D initialLocation) {
        super("sprites/blacCatPixel.png", initialLocation, new Size(40,80));
    }

    @Override
    public void onPressedKeysChange(Set<KeyCode> pressedKeys) {
        latestPressedKeys = pressedKeys;
        if (touchdown && pressedKeys.isEmpty()) {
            setSpeed(0);
        }else if(pressedKeys.contains(KeyCode.LEFT) || pressedKeys.contains(KeyCode.A)){
            setMotion(speed,270d);
        } else if(pressedKeys.contains(KeyCode.RIGHT) || pressedKeys.contains(KeyCode.D)){
            setMotion(speed,90d);
        } else if(pressedKeys.contains(KeyCode.UP) || pressedKeys.contains(KeyCode.W)){
            setMotion(speed,180d);
        } else if(pressedKeys.contains(KeyCode.DOWN) || pressedKeys.contains(KeyCode.S)){
            setMotion(speed,0d);
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

    ///Health
    public void setHealth(int newHealth) {
        health = newHealth;
    }

    public int getHealth() {
        return health;
    }

    ///Speed
    public void setSpeedBlackPixelCat(int newSpeed) {
        speed = newSpeed;
    }

    public int getSpeedBlackPixelCat() {
        return speed;
    }
}
