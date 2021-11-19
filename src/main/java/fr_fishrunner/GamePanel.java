package fr_fishrunner;
import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable{

        private final int oTileSize = 16; //my sprites will be 16*16
        private final int scale = 3;

        private long currentTime;
        private double nextDrawTime;
        private final int tileSize = oTileSize * scale; //we scale the sprites to be displayed properly 48*48px

        private double delta;
        private double lastTime;

        KeyHandler keyH = new KeyHandler();
        Thread gameThread;

        //Player default pos
        private int playerInitY = 400;
        private int playerX = 150;
        private int playerY = playerInitY;
        private int playerSp = 10;
        private final int FPS = 60;
        private double drawInterval = 1000000000/FPS;//en nano sec
        private double remainingTime;

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
        };

        @Override
        public void run(){

            nextDrawTime = System.nanoTime() + drawInterval;

            while(gameThread != null){
                this.setCurrentTime(System.nanoTime());
                update();
                repaint();//JPanel method that will call paintComponent
                remainingTime = nextDrawTime - System.nanoTime();
                try{
                    this.setRemainingTime(remainingTime/1000000);

                    if(remainingTime<0){
                        this.setRemainingTime(0);
                    }

                    Thread.sleep((long) remainingTime);
                    nextDrawTime = drawInterval + System.nanoTime();
                }catch(InterruptedException e){
                    e.printStackTrace();
                }
            };
        }

        public void run2(){
            delta = 0;
            lastTime = System.nanoTime();
            while(gameThread !=null){
                update();
                repaint();
            }
        }

    public void update(){
            if(keyH.isUpPressed()){
                playerY -= playerSp;
            }
            else if (keyH.isUpPressed() == false)
              {
                playerY = playerInitY + playerSp;
            }
        }

       public void paintComponent(Graphics g){
            super.paintComponent(g);
            Graphics2D g2 = (Graphics2D)g;//cast g to Graphics2D
            g2.setColor(Color.black);
            g2.fillRect(this.getPlayerX(), this.getPlayerY(), this.getTileSize(), this.getTileSize());
            g2.dispose();
        }

        public int getPlayerX() {
            return this.playerX;
        }
        public int getPlayerY() {
            return this.playerY;
        }
        public void setPlayerY(int playerY) {
            this.playerY = playerY;
        }
        public void setCurrentTime(long currentTime){
            this.currentTime = currentTime;//en nano sec
        }
        public int getTileSize() {
            return this.tileSize;
        }
        public double getNextDrawTime() {
            return nextDrawTime;
        }
        public void setNextDrawTime(double nextDrawTime) {
            this.nextDrawTime = nextDrawTime;
        }
        public void setRemainingTime(double remainingTime) {
            this.remainingTime = remainingTime;
        }
        private void setDrawInterval(double i) {this.drawInterval = i;};
}