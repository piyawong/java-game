package Game2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Gameplay2 extends JPanel implements KeyListener, ActionListener {
    Player1 p1 = new Player1();
    Player2 p2 = new Player2();
    public Gameplay2(){
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(true);
    }
    public void paint(Graphics g){
        p1.draw(g);
        p2.draw(g);
        repaint();
    }


    @Override
    public void actionPerformed(ActionEvent e) {

    }


    @Override
    public void keyTyped(KeyEvent e) { }
    @Override
    public void keyReleased(KeyEvent e) { }


    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_UP  ){
            p1.moveUp();

        }
        if(e.getKeyCode() == KeyEvent.VK_DOWN){
            p1.moveDown();
            if(e.getKeyCode() == KeyEvent.VK_LEFT){
                p1.moveLeft();}
            if(e.getKeyCode() == KeyEvent.VK_RIGHT){
                p1.moveRight();
            }
        }
        if(e.getKeyCode() == KeyEvent.VK_LEFT){
            p1.moveLeft();
        }
        if(e.getKeyCode() == KeyEvent.VK_RIGHT){
            p1.moveRight();
        }


        if(e.getKeyCode() == KeyEvent.VK_W){
            p2.moveUp();
        }
        if(e.getKeyCode() == KeyEvent.VK_S){
            p2.moveDown();
        }
        if(e.getKeyCode() == KeyEvent.VK_A){
            p2.moveLeft();
        }
        if(e.getKeyCode() == KeyEvent.VK_D){
            p2.moveRight();
        }





    }



}
