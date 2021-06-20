import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class ItemMinus extends Item {
    private String type = "Minus";
    BufferedImage minus;
    public ItemMinus(int itemposX ,int itemposY){
        super(itemposX,itemposY);
        try {

            minus = ImageIO.read(getClass().getResource("Pics/Minus.jpg"));
        } catch (IOException e) {
            System.out.println("ERROR");
            e.printStackTrace();
        }

    }
    public void draw(Graphics g){
        g.setColor(Color.red);
        g.drawImage(minus,itemposX,itemposY,itemWidth,itemHeight,null);
    }
    @Override
    public String getType(){
        return this.type;
    }
}
