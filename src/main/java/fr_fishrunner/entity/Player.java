package fr_fishrunner.entity;
import fr_fishrunner.GamePanel;
import fr_fishrunner.KeyHandler;
import fr_fishrunner.tile.Tile;
import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

public class Player extends Entity{
    private Tile sprite = new Tile();

    public int getY() {
        return Y;
    }
    public void setY(int y) {
        Y = y;
    }
    public int getSpeed() {
        return speed;
    }

    private int Y;
    private int speed;
    private int X;
    private final int initY = 400;

    GamePanel gp;
    KeyHandler keyH;

    public Player(GamePanel gp, KeyHandler KeyH){
        super();
        this.setX(150);
        this.setY(initY);
        this.setSpeed(10);

        this.gp = gp;
        this.keyH = KeyH;
    }

    public void setPlayerImage(){

    }

    public void draw(Graphics2D g2)  {
        g2.drawImage(sprite.getImage(), X, Y, gp.getTileSize(), gp.getTileSize(), null);
    }

    public void update(){
        if(keyH.isUpPressed()){
            this.Y -= speed;
        }
        else if (!keyH.isUpPressed())
        {
            this.Y = initY + speed;
        }
    }



    public void setX(int x) {
        X = x;
    }
    public void setSpeed(int speed) {
        this.speed = speed;
    }
}


