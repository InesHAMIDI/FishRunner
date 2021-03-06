package fr_fishrunner.entity;
import fr_fishrunner.GamePanel;
import fr_fishrunner.KeyHandler;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Player extends Entity{

    public int getY() {
        return Y;
    }
    public void setY(int y) {
        Y = y;
    }
    public int getSpeed() {
        return speed;
    }
    public int getScore() {
        return score;
    }
    public void setScore(int score) {
        this.score = score;
    }

    private int Y;
    private int speed;
    private int X;
    private final int initY = 400;

    private int score;

    GamePanel gp;
    KeyHandler keyH;

    public Player(GamePanel gp, KeyHandler KeyH){
        super();
        this.setX(150);
        this.setY(initY);
        this.setSpeed(10);
        this.setScore(0);

        this.gp = gp;
        this.keyH = KeyH;
        getPlayerImage();
    }

    public void getPlayerImage() {
        try{
            sprite = ImageIO.read(getClass().getResourceAsStream("/player/player.png"));}
        catch(IOException e){
            e.printStackTrace();
            }
    }

    public void draw (Graphics2D g2)  {
        BufferedImage image = null;
        g2.drawImage(sprite, X, Y, gp.getTileSize(), gp.getTileSize(), null);
    }

    public void update(){
        if(keyH.isUpPressed()){
            this.Y -= speed;
        }
        else if (!keyH.isUpPressed())
        {
            this.Y = initY + speed/4;
        }
    }

    public int GameOver(){
        return getScore();
    }

    public void setX(int x) {
        X = x;
    }
    public void setSpeed(int speed) {
        this.speed = speed;
    }
}


