package fr_fishrunner;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class KeyHandler implements KeyListener {
    public boolean isUpPressed() {
        return upPressed;
    }
    public void setUpPressed(boolean upPressed) {
        this.upPressed = upPressed;
    }

    private boolean upPressed;

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        if(code == KeyEvent.VK_Z || code == KeyEvent.VK_W) {
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
