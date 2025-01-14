package gamestates;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

/**
 * StateMethods interface is used to define the methods that each state class should implement.
 */
public interface StateMethods {
    public void update();
    public void draw(Graphics g);
    public void mouseClicked(MouseEvent e);
    public void mouseReleased(MouseEvent e);
    public void mousePressed(MouseEvent e);
    public void mouseMoved(MouseEvent e);
    public void keyPressed(KeyEvent e);
    public void keyReleased(KeyEvent e);
}
