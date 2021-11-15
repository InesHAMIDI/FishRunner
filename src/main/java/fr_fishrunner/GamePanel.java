package fr_fishrunner;
import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable{
    public int getoTileSize() {
        return oTileSize;
    }
    public int getScale() {
        return scale;
    }
    public int getTileSize() {
        return tileSize;
    }
    public int getMaxCol() {
        return maxCol;
    }
    public int getMaxRow() {
        return maxRow;
    }
    public int getSWidth() {
        return SWidth;
    }
    public int getSHeight() {
        return SHeight;
    }
    public KeyHandler getKeyH() {
        return keyH;
    }
    public void setKeyH(KeyHandler keyH) {
        this.keyH = keyH;
    }
    public Thread getGameThread() {
        return gameThread;
    }
    public void setGameThread(Thread gameThread) {
        this.gameThread = gameThread;
    }
    public int getPlayerX() {
        return playerX;
    }
    public void setPlayerX(int playerX) {
        this.playerX = playerX;
    }
    public int getPlayerInitY() {
        return playerInitY;
    }
    public void setPlayerInitY(int playerInitY) {
        this.playerInitY = playerInitY;
    }
    public int getPlayerY() {
        return playerY;
    }
    public void setPlayerY(int playerY) {
        this.playerY = playerY;
    }
    public int getPlayerSp() {
        return playerSp;
    }
    public void setPlayerSp(int playerSp) {
        this.playerSp = playerSp;
    }

    private final int oTileSize = 16; //my sprites will be 16*16
    private final int scale = 3;
    private final int tileSize = oTileSize * scale; //we scale the sprites to be displayed properly 48*48px

    private final int maxCol = 16;
    private final int maxRow = 12;
    private final int SWidth = tileSize * maxCol;//768 px
    private final int SHeight = tileSize * maxRow;//576px

    KeyHandler keyH = new KeyHandler();
    Thread gameThread;

    //Player default pos
    private int playerX = 150;
    private int playerInitY = 150;
    private int playerY = playerInitY;
    private int playerSp = 4;

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