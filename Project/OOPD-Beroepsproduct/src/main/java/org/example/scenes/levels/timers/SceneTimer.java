package org.example.scenes.levels.timers;

import com.github.hanyaeger.api.Timer;
import org.example.scenes.levels.DonkerebosScene;

public class  SceneTimer extends Timer {

    private DonkerebosScene scene;

    public SceneTimer(DonkerebosScene scene) {
        super(1000);
        this.scene = scene;
    }

    @Override
    public void onAnimationUpdate(long timestamp) {
        scene.updateTimer();
    }
}
