module App {
    requires hanyaeger;

    exports org.example;
    opens backgrounds;
    opens sounds;
    opens sprites;
    opens entitys;
    exports org.example.entitys;
    exports org.example.shared.buttons;
    exports org.example.scenes.levels;
    exports org.example.entitys.enemys;
    exports org.example.entitys.blackpixelcat;
    exports org.example.scenes.gameoverscreens;
}