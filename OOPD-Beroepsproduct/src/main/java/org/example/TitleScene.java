package org.example;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.YaegerEntity;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import com.github.hanyaeger.api.scenes.StaticScene;
import com.github.hanyaeger.api.scenes.YaegerScene;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class TitleScene extends StaticScene {

    private static final String HAMTER_TEXT = "PLEASE GIVE ME A 10";
    public TitleScene(App app) {
    }

    @Override
    public void setupScene() {
        setBackgroundAudio("sounds/hampter.mp3");
        setBackgroundImage("backgrounds/hampter.jpg");

    }

    @Override
    public void setupEntities() {
        var select = new TextEntity(new Coordinate2D(TextCenter(), getHeight()/2), HAMTER_TEXT);
        select.setFill(Color.BLACK);
        select.setFont(Font.font("Roboto", FontWeight.BOLD, 23));
        addEntity(select);
    }

    public double TextCenter(){
        double test = HAMTER_TEXT.length();
        return (getWidth()/2) - (test/2);
    }
}
