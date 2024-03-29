package org.example.entitys;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class IngredientText extends TextEntity {

    private int ingredientsFound = 0;
    private String INGREDIENTS_TEXT = "Ingredients to go: ";
    public IngredientText(Coordinate2D initialLocation) {
        super(initialLocation);

        setFont(Font.font("Roboto", FontWeight.NORMAL, 30));
        setFill(Color.GREEN);
        setText(INGREDIENTS_TEXT + ingredientsFound);
    }

    public void setIngredientText(int ingredientsToGo){
        setText("Ingredients to go: " + ingredientsToGo);
    }

    public void upIngredientText(){
        ingredientsFound++;
        setText("Ingredients to go: " + ingredientsFound);
    }
    public int getIngredientsFound(){
        return ingredientsFound;
    }
}
