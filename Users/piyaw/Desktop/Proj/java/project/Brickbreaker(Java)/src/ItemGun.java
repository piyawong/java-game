import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class ItemGun extends Item {
    private String type = "Gun";
    BufferedImage minus;
    public ItemGun(int itemposX ,int itemposY){
        super(itemposX,itemposY);
        try {

            minus = ImageIO.read(getClass().getResource("Pics/Gun.png"));
        } catch (IOException e) {
            System.out.println("ERROR");
            e.printStackTrace();
        }

    }
    public void draw(Graphics g){
        g.setColor(Color.red);
       // g.fillRect(itemposX, itemposY, itemWidth, itemHeight);
        g.drawImage(minus,itemposX,itemposY,itemWidth,itemHeight,null);
    }
    @Override
    public String getType(){
        return this.type;
    }
}
