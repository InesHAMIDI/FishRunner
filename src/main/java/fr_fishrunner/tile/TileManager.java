package fr_fishrunner.tile;

import fr_fishrunner.GamePanel;

import javax.imageio.ImageIO;
import java.io.IOException;

public class TileManager {
    private GamePanel gp;
    private Tile[] tiles;

    public TileManager(GamePanel gp){
        this.gp = gp;
        tiles = new Tile[3];
        getTileImage();
    }

    public void getTileImage(){
        try{
            tiles[0] = new Tile();
            tiles[0].setImage(ImageIO.read(getClass().getResourceAsStream("/tiles/water.png")));

        }catch (IOException e){
            e.printStackTrace();
        }
    }
 }
