import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class ItemFast extends Item {
    private String type = "Fast";
    BufferedImage fast;
    public ItemFast (int itemposX ,int itemposY){
        super(itemposX,itemposY);
        try {

            fast = ImageIO.read(getClass().getResource("Pics/Fast.jpg"));

        } catch (IOException e) {
            System.out.println("ERROR");
            e.printStackTrace();
        }

    }
    public void draw(Graphics g){
        g.setColor(Color.blue);
        g.drawImage(fast,itemposX,itemposY,itemWidth,itemHeight,null);
    }
    public String getType(){
        return this.type;
    }
}
