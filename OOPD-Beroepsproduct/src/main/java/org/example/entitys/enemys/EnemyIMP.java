package org.example.entitys.enemys;

import com.github.hanyaeger.api.entities.Direction;

public interface EnemyIMP {
    public void hit();
    public int getSpeed();
    public Direction getDirection();
    public String getResource();
}
