package org.example.entitys;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class IngredientText extends TextEntity {


    public IngredientText(Coordinate2D initialLocation) {
        super(initialLocation);

        setFont(Font.font("Roboto", FontWeight.NORMAL, 30));
        setFill(Color.GREEN);
    }

    public void setIngredientText(int ingrtedientAmount){
        setText("Ingredients: " + ingrtedientAmount);
    }
}
