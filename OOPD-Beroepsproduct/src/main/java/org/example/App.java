package org.example;

import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.YaegerGame;
import com.github.hanyaeger.api.scenes.YaegerScene;

/**
 * Hello world!
 *
 */
public class App extends YaegerGame
{
    public static void main( String[] args )
    {

        launch(args);
    }

    @Override
    public void setupGame() {
        setGameTitle("Waterworld");
        setSize(new Size(800,600));
    }

    @Override
    public void setupScenes() {
        addScene(0, (YaegerScene) new TitleScene(this));
    }
}
