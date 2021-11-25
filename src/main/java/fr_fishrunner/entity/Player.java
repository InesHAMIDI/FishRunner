package fr_fishrunner.entity;
import fr_fishrunner.KeyHandler;
import fr_fishrunner.tile.Tile;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

public class Player {
    private Tile sprite = new Tile();
    private KeyHandler keyH = new KeyHandler();

    private int Y;
    private int speed;
    private int X;
    private int initY;

    public void draw(Graphics2D g2)  {
        try{
            sprite.setImage(ImageIO.read(getClass().getResourceAsStream("/player/player.png")));
        }
        catch (IOException e){
        e.printStackTrace();
    }
    }

    public void update(){
        if(keyH.isUpPressed()){
            Y -= speed;
        }
        else if (keyH.isUpPressed() == false)
        {
            Y = initY + speed;
        }
        }
    }

}
