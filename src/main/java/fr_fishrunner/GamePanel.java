package fr_fishrunner;
import fr_fishrunner.entity.Player;
import fr_fishrunner.tile.TileManager;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable{

        private final int oTileSize = 16; //my sprites will be 16*16
        private final int scale = 3;
        private final int tileSize = oTileSize * scale; //we scale the sprites to be displayed properly 48*48px

       // private double nextDrawTime;

        KeyHandler keyH = new KeyHandler();
        Thread gameThread;
        TileManager tileM = new TileManager(this);
        Player player = new Player(this, keyH);

        public GamePanel(){
            super();
            //576px
            int maxRow = 12;
            int SHeight = tileSize * maxRow;
            //768 px
            int maxCol = 20;
            int SWidth = tileSize * maxCol;
            this.setPreferredSize(new Dimension(SWidth, SHeight)); //set the size of the JPanel
            this.setBackground(Color.blue);
            this.setDoubleBuffered(true);
            this.addKeyListener(keyH);
            this.setFocusable(true);
        }

        public void startGameThread(){
            gameThread = new Thread(this);
            gameThread.start();
        }

        @Override
        public void run(){
            double delta = 0;
            double lastTime = System.nanoTime();
            long timer = 0;
            int drawCount = 0;
            while(gameThread !=null){
                long currentTime = System.nanoTime();
                //en nano sec
                int FPS = 60;
                double drawInterval = 1000000000 / FPS;
                delta += (currentTime - lastTime)/ drawInterval;
                timer += (currentTime - lastTime);
                lastTime = currentTime;

                if(delta >=1){
                    update();
                    repaint();
                    delta--;
                    drawCount++;
                }
                if (timer >= 1000000000){
                    System.out.println("FPS " + drawCount);
                    drawCount = 0;
                    timer = 0;
                }
            }
        }

        public void update(){
            player.update();
        }

       public void paintComponent(Graphics g){
            super.paintComponent(g);
            Graphics2D g2 = (Graphics2D)g;//cast g to Graphics2D
            tileM.draw(g2);
            player.draw(g2);
            g2.dispose();
        }

        public int getTileSize() {
            return this.tileSize;
        }

}