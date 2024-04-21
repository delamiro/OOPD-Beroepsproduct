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
    private final int WALKING_SPEED = 2;
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

}
