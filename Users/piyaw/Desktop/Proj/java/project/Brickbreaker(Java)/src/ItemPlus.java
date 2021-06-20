import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class ItemPlus extends Item {
    private String type = "Plus";
    BufferedImage plus;
    public ItemPlus(int itemposX ,int itemposY){
        super(itemposX,itemposY);
        try {
            plus = ImageIO.read(getClass().getResource("Pics/Plus.jpg"));
        } catch (IOException e) {
            System.out.println("ERROR");
            e.printStackTrace();
        }

    }
    public void draw(Graphics g){
        g.setColor(Color.blue);
        g.drawImage(plus,itemposX,itemposY,itemWidth,itemHeight,null);
    }
    public String getType(){
        return this.type;
    }
}
