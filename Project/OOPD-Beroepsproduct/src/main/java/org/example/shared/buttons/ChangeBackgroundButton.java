package org.example.shared.buttons;

import org.example.scenes.gameoverscreens.GameOverGood;

public class ChangeBackgroundButton implements ButtonIMP{
    private GameOverGood gameOverGood;

    public ChangeBackgroundButton(GameOverGood gameOverGood){
        this.gameOverGood = gameOverGood;
    }

    @Override
    public void doAction() {
        gameOverGood.setBackgroundImage("backgrounds/good.png");
    }
}
