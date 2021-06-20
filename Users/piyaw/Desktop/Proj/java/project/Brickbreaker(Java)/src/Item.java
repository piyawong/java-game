import java.awt.*;

public class Item {
    public int itemposX ;
    public int itemposY;
    public int itemWidth = 86 ;
    public int itemHeight = 30;
    public int speed = 2;
    private String type = "normal";

    public Item(int itemposX ,int itemposY){
        this.itemposX=itemposX;
        this.itemposY = itemposY;

    }
    public void draw (Graphics g){
        g.setColor(Color.magenta);
        g.fillRect(itemposX,itemposY,itemWidth,itemHeight);
    }
    public void move(){
        itemposY+=speed;
    }
    public String getType(){
        return this.type;
    }

}
