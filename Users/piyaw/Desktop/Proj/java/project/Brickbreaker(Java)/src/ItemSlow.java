import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class ItemSlow extends Item{
    private String type = "Slow";
    BufferedImage slow;
    public ItemSlow(int itemposX ,int itemposY){
        super(itemposX,itemposY);
        try {
            slow = ImageIO.read(getClass().getResource("Pics/Slow.jpg"));
        } catch (IOException e) {
            System.out.println("ERROR");
            e.printStackTrace();
        }

    }
    public void draw(Graphics g){
        g.setColor(Color.blue);
        g.drawImage(slow,itemposX,itemposY,itemWidth,itemHeight,null);
    }
    public String getType(){
        return this.type;
    }
}
