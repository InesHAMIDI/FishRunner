package fr_fishrunner.tile;

import fr_fishrunner.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class TileManager {
    private GamePanel gp;
    private Tile[] tiles;
    private ArrayList<String> chemins = new ArrayList<>();

    public TileManager(GamePanel gp){
        this.gp = gp;
        tiles = new Tile[5];
        getTileImage();
        this.chemins.add(0, "/tiles/fond1.png");
        this.chemins.add(1,"/tiles/fond2.png");
        this.chemins.add(2, "/tiles/fond3.png");
        this.chemins.add(3, "/tiles/fonduni.png");
    }

    public void getTileImage(){
        try{
            for(int i = 0; i > 4; i++){
            tiles[i] = new Tile();
            tiles[i].setImage(ImageIO.read(getClass().getResourceAsStream(chemins.get(i))));
            }

        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void draw(Graphics2D g2){
        g2.drawImage(tiles[0].getImage(), 0, 0, gp.getTileSize(), gp.getTileSize(), null);
    }


}
