package fr_fishrunner;
import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable{

    private final int oTileSize = 16; //my sprites will be 16*16
    private final int scale = 3;

    private double nextDrawTime;
    private final int tileSize = oTileSize * scale; //we scale the sprites to be displayed properly 48*48px

    KeyHandler keyH = new KeyHandler();
    Thread gameThread;

    //Player default pos
    private int playerX = 150;
    private final int playerInitY = 400;
    private int playerY;
    private int playerSp = 2;

    private double drawInterval;
    private double remainingTime = this.getNextDrawTime() - System.nanoTime();

    public GamePanel(){
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
        int FPS = 60;
        double drawInterval = 1000000000/FPS;//en nano sec
        playerY = playerInitY;
    }

    public void startGameThread(){
        gameThread = new Thread(this);
        gameThread.start();
    };

    @Override
    public void run(){

        this.setDrawInterval(10000000);
        this.setNextDrawTime(System.nanoTime() + drawInterval);

        while(gameThread != null){
            this.setCurrentTimeN(System.nanoTime());
            update();
            repaint();//JPanel method that will call paintComponent

            try{
                this.setRemainingTime(remainingTime/1000000);

                if(remainingTime<0){
                    this.setRemainingTime(0);
                }

                Thread.sleep((long) remainingTime);
                nextDrawTime += drawInterval;
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        };
    }

    public void update(){
        if(keyH.isUpPressed()){
            this.setPlayerY(playerY - playerSp);
        }
        else{
            this.setPlayerY(playerY + playerSp);
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
    public void setCurrentTimeN(long currentTimeN) {
        //en nano sec
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
    public void setDrawInterval(double drawInterval) {
        this.drawInterval = drawInterval;
    }
    public void setRemainingTime(double remainingTime) {
        this.remainingTime = remainingTime;
    }
}