package Game2;

import java.awt.*;

public class Player2 {
    public int playerXpos = 450 ;
    public int playerYpos = 240;
    public int playerWidth = 16;
    public int playerHeight = 28;
    public int vel = 10;
    public boolean left = false;
    public boolean right = false;
    public boolean up = false;
    public boolean down = false;
    public boolean standing = false;
    public boolean shooting = false;
    public int walkCount = 9;

    public Player2(){

    }
    public void draw (Graphics g){
        g.setColor(Color.cyan);
        g.fillRect(playerXpos, playerYpos,playerWidth,playerHeight);

    }
    public void moveUp(){
        playerYpos-=vel;
    }
    public void moveDown(){
        playerYpos+=vel;
    }
    public void moveRight(){
        playerXpos+=vel;
    }
    public void moveLeft(){
        playerXpos-=vel;
    }

}
