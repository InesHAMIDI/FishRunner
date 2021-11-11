package fr_fishrunner;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class KeyHandler implements KeyListener {
    public boolean upPressed;

    @Override
    public void KeyPressed(KeyEvent e){
        int code = e.getKeyCode();
        if(code == KeyEvent.VK_Z || code == KeyEvent.VK_W)
        {
            upPressed = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e){
        int code = e.getKeyCode();
        if(code == KeyEvent.VK_Z || code == KeyEvent.VK_W){
            upPressed = false;
        }
    }

}
