package fr_fishrunner.entity;
import fr_fishrunner.GamePanel;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

public class Obstacle extends Entity{

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

        private final int maxX = 1001;
        private final int minX = 50;

        private Random choix = new Random();

        GamePanel gp;

        public Obstacle(GamePanel gp){
            super();
            this.setX(1000);
            this.setY(400);
            this.setSpeed(10);

            this.gp = gp;
            getObImage();
        }

        public void getObImage() {
            try{
                tv = ImageIO.read(getClass().getResourceAsStream("/obstacles/tv.png"));
                baril = ImageIO.read(getClass().getResourceAsStream("/obstacles/baril.png"));}
            catch(IOException e){
                e.printStackTrace();
            }
        }

        public void draw (Graphics2D g2)  {

            BufferedImage image = null;
            if(choix.nextInt(10) < 5) {
                image = tv;
            }
            else{
                image = baril;}
            g2.drawImage(image, X, Y, gp.getTileSize(), gp.getTileSize(), null);
        }

        public void update(){

            if(X < maxX && x < minX){
                X -= speed;
        }}

        public void setX(int x) {
            X = x;
        }
        public void setSpeed(int speed) {
            this.speed = speed;
        }
    }



}
