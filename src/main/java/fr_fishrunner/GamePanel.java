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

    Thread gameThread;

    public GamePanel(){
        this.setPreferredSize(new Dimension(SWidth, SHeight)); //set the size of the JPanel
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
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

    }

   public void paintComponents(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
    }

}