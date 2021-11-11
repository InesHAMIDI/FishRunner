package fr_fishrunner;
import javax.swing.JPanel;
import java.awt.*;


public class GamePanel extends JPanel implements Runnable{
    final int TileSize = 16; //my sprites will be 16*16
    final int scale = 3;
    final int tileSize = TileSize * scale; //we scale the sprites to be displayed properly 48*48px

    final int maxCol = 16;
    final int maxRow = 12;
    final int SWidth = tileSize * maxCol;//768 px
    final int SHeight = tileSize * maxRow;//576px

    KeyHandler keyH = new KeyHandler();
    Thread gameThread;

    //Player default pos
    int playerX = 100;
    int playerY = 100;
    int playerSp = 4;

    public GamePanel(){
        this.setPreferredSize(new Dimension(SWidth, SHeight)); //set the size of the JPanel
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true);
    }

    public void startGameTh(){
        gameThread = new Thread(this);
        gameThread.start();
    };

    @Override
    public void run(){
        while(gameThread != null){
            System.out.println("game running");
            update();
            repaint();

        };
    }

    public void update(){
        if(keyH.upPressed = true){
            playerY -= playerSp;
        }
    }

   public void paintComponents(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        g2.setColor(Color.white);
        g2.fillRect(playerX, playerY, tileSize, tileSize);
        g2.dispose();
    }

}