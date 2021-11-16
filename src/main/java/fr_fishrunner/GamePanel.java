package fr_fishrunner;
import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable{

    public Thread getGameThread() {
        return this.gameThread;
    }
    public int getPlayerX() {
        return this.playerX;
    }
    public void setPlayerX(int playerX) {
        this.playerX = playerX;
    }
    public int getPlayerInitY() {
        return this.playerInitY;
    }
    public int getPlayerY() {
        return this.playerY;
    }
    public void setPlayerY(int playerY) {
        this.playerY = playerY;
    }
    public int getPlayerSp() {
        return this.playerSp;
    }
    public void setPlayerSp(int playerSp) {
        this.playerSp = playerSp;
    }
    public void setCurrentTimeN(long currentTimeN) {
        this.currentTimeN = currentTimeN;
    }
    public int getTileSize() {
        return this.tileSize;
    }

    private final int oTileSize = 16; //my sprites will be 16*16
    private final int scale = 3;

    public double getNewDrawTime() {
        return newDrawTime;
    }

    public void setNewDrawTime(double newDrawTime) {
        this.newDrawTime = newDrawTime;
    }

    double newDrawTime;


    private final int tileSize = oTileSize * scale; //we scale the sprites to be displayed properly 48*48px

    KeyHandler keyH = new KeyHandler();
    Thread gameThread;

    //Player default pos
    private int playerX = 150;
    private int playerInitY = 400;
    private int playerY = playerInitY;
    private int playerSp = 4;

    public double getDrawInterval() {
        return drawInterval;
    }
    public void setDrawInterval(double drawInterval) {
        this.drawInterval = drawInterval;
    }

    private double drawInterval;
    private double remainingTime = this.getNewDrawTime() - System.nanoTime();


    private long currentTimeN;//en nano sec

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
    }

    public void startGameThread(){
        gameThread = new Thread(this);
        gameThread.start();
    };

    @Override
    public void run(){

        this.setDrawInterval(10000000);
        while(gameThread != null){
            this.setCurrentTimeN(System.nanoTime());
            this.setNewDrawTime(System.nanoTime() + drawInterval);
            update();
            repaint();//JPanel method that will call paintComponent
            Thread.sleep(long remainingTime);
        };
    }

    public void update(){
        if(keyH.isUpPressed()){
            this.setPlayerY(playerSp -1);
        }
        else{
            this.setPlayerY(playerInitY);
        }
    }

   public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;//cast g to Graphics2D
        g2.setColor(Color.black);
        g2.fillRect(this.getPlayerX(), this.getPlayerY(), this.getTileSize(), this.getTileSize());
        g2.dispose();
    }


}