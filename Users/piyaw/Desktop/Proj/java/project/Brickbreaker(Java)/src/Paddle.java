import javax.swing.*;
import java.awt.*;

public class Paddle {
    public int playerX = 310;
    public int playerY = 550;
    public int width = 100;
    public int height = 8;

    public void draw(Graphics g){
        g.setColor(Color.green);
        g.fillRect(playerX,playerY,width,height);

    }


}
