package org.example.entitys;

import com.github.hanyaeger.api.Timer;
import org.example.Catgame;

public class GameTimer extends Timer {

    private Catgame catgame;
    public GameTimer(long intervalInMs, Catgame catgame) {

        super(intervalInMs);
        this.catgame = catgame;
    }


    @Override
    public void onAnimationUpdate(long l) {
        catgame.setActiveScene(4);
    }

}
