import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class ItemSplit extends Item{
    private String type = "Split";
    BufferedImage split;
    public ItemSplit(int itemposX ,int itemposY){
        super(itemposX,itemposY);
        try {
            split = ImageIO.read(getClass().getResource("Pics/Split.jpg"));
        } catch (IOException e) {
            System.out.println("ERROR");
            e.printStackTrace();
        }


    }
    public void draw(Graphics g){
        g.setColor(Color.blue);
        g.drawImage(split,itemposX,itemposY,itemWidth,itemHeight,null);
    }
    public String getType(){
        return this.type;
    }
}
