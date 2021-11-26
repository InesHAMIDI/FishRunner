package fr_fishrunner.entity;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Entity {

    public int getX() {
        return x;
    }
    public void setX(int x) {
        this.x = x;
    }
    public int getY() {
        return y;
    }
    public void setY(int y) {
        this.y = y;
    }
    public int getSpeed() {
        return speed;
    }
    public void setSpeed(int speed) {
        this.speed = speed;
    }

    private int x;
    private int y;
    private int speed;

    public BufferedImage sprite, tv, baril;

}
