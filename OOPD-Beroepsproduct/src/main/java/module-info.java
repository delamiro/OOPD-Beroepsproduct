module App {
    requires hanyaeger;

    exports org.example;
    opens backgrounds;
    opens sounds;
    opens sprites;
    exports org.example.entitys;
    exports org.example.scenes;
    exports org.example.shared.buttons;
    exports org.example.scenes.levels;
    exports org.example.scenes.secret;
    exports org.example.entitys.ingredients;
}