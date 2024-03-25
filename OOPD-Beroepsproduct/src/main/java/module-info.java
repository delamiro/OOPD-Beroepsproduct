module App {
    requires hanyaeger;

    exports org.example;
    opens backgrounds;
    opens sounds;
    opens sprites;
    exports org.example.entitys;
    exports org.example.scenes;
}