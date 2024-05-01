package org.example.shared.buttons;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import com.github.hanyaeger.api.userinput.MouseButtonPressedListener;
import com.github.hanyaeger.api.userinput.MouseEnterListener;
import com.github.hanyaeger.api.userinput.MouseExitListener;
import javafx.scene.Cursor;
import javafx.scene.input.MouseButton;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import org.example.Catgame;

public class Button extends TextEntity implements MouseButtonPressedListener, MouseEnterListener, MouseExitListener {
    private ButtonIMP buttonIMP;

    public Button(final Coordinate2D initialPosition, final String text, ButtonIMP buttonIMP){
        super(initialPosition, text);
        this.buttonIMP = buttonIMP;
        setFont(Font.font("Roboto", FontWeight.NORMAL, 25));
    }
    @Override
    public void onMouseButtonPressed(MouseButton mouseButton, Coordinate2D coordinate2D) {
        buttonIMP.doAction();
    }

    @Override
    public void onMouseEntered() {
        setCursor(Cursor.HAND);
    }

    @Override
    public void onMouseExited() {
        setCursor(Cursor.DEFAULT);
    }
}
