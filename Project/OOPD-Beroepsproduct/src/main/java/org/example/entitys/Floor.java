package org.example.entitys;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.Direction;
import com.github.hanyaeger.api.entities.impl.RectangleEntity;
import javafx.scene.paint.Color;
import org.example.entitys.blackpixelcat.BlackPixelCatCollisionBox;
import org.example.entitys.blackpixelcat.BlackPixelCat;

import java.util.List;

public class Floor extends RectangleEntity implements Collided {
    BlackPixelCat blackPixelCat;
    public Floor(Coordinate2D initialLocation, Size size, BlackPixelCat blackPixelCat) {
        super(initialLocation, size);
        setAnchorPoint(AnchorPoint.BOTTOM_LEFT);
        setFill(Color.RED);
        this.blackPixelCat = blackPixelCat;
    }

    @Override
    public void onCollision(List<Collider> collidingObjects) {
        for (var collider : collidingObjects) {
            if (collider instanceof BlackPixelCatCollisionBox) {
                blackPixelCat.setAnchorLocationY(getBoundingBox().getMinY() + 1);
                blackPixelCat.nullifySpeedInDirection(Direction.DOWN);
            }
        }
    }
}
