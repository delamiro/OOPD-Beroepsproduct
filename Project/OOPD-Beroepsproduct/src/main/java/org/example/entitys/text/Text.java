package org.example.entitys.text;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.paint.Color;


public class Text extends TextEntity {
    public Text(Coordinate2D initialLocation) {
        super(initialLocation);
        setFont(Font.font("Roboto", FontWeight.NORMAL, 30));
        setFill(Color.WHITE);
    }
 
    public void changeText(String text) {
        setText(text);
    }
}
