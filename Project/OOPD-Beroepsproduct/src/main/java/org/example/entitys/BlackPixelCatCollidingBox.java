package org.example.entitys;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.impl.RectangleEntity;
import javafx.scene.paint.Color;

public class BlackPixelCatCollidingBox extends RectangleEntity implements Collider {
    public static final double OPACITY = 0;
    private static final Color COLOR = Color.RED;

    public BlackPixelCatCollidingBox(final Coordinate2D initialLocation, final Size size) {
        super(initialLocation, size);
        setAnchorPoint(AnchorPoint.BOTTOM_LEFT);

        // The color is set to ensure it stands out while it is not transparant. The reason
        //        // make it visible is that its much easier during development.
        setFill(COLOR);

        // The Opacity is used to make this floor transparant
        //setOpacity(OPACITY);
    }
}
