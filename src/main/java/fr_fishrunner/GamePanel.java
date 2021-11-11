package fr_fishrunner;
import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable{
    final int oTileSize = 16; //my sprites will be 16*16
    final int scale = 3;
    final int tileSize = oTileSize * scale; //we scale the sprites to be displayed properly 48*48px

    final int maxCol = 16;
    final int maxRow = 12;
    final int SWidth = tileSize * maxCol;//768 px
    final int SHeight = tileSize * maxRow;//576px

    KeyHandler keyH = new KeyHandler();
    Thread gameThread;

    //Player default pos
    int playerX = 150;
    int playerInitY = 150;
    int playerY = playerInitY;
    int playerSp = 4;

    public GamePanel(){
        this.setPreferredSize(new Dimension(SWidth, SHeight)); //set the size of the JPanel
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true);
    }

    public void startGameThread(){
        gameThread = new Thread(this);
        gameThread.start();
    };

    @Override
    public void run(){
        while(gameThread != null){
            System.out.println("game running");
            update();
            repaint();//JPanel method that will call paintComponent
        };
    }

    public void update(){
        if(keyH.upPressed = true){
            playerY -= playerSp;
        }
        else{
            playerY = playerInitY;
        }
    }

   public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;//cast g to Graphics2D
        g2.setColor(Color.blue);
        g2.fillRect(playerX, playerY, tileSize, tileSize);
        g2.dispose();
    }

}