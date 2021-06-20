import java.awt.*;
import java.util.Random;

public class Bullet {

    public int ballWidth = 22;
    public int ballHeight = 22;
    public int ballposX ;
    public int ballposY ;
    public int ballYdir = -8;
    public Color color ;
    Random random = new Random();

    public Bullet (int ballposX,int ballposY){
        this.ballposX = ballposX;
        this.ballposY = ballposY;
        int r = random.nextInt(6);

        switch (r) {
            case 0 :
                this.color = Color.WHITE;
                break;
            case 1 :
                this.color = Color.BLUE;
                break;
            case 2 :
                this.color = Color.green;
                break;
            case 3 :
                this.color = Color.yellow;
                break;
            case 4 :
                this.color = Color.orange;
                break;
            case 5 :
                this.color = Color.red;
                break;
            default:
                this.color = Color.PINK;
        }


    }
    public void draw(Graphics g){
        g.setColor(color);
        g.fillOval(ballposX,ballposY,ballWidth,ballHeight);

    }
    public void move(){
        ballposY+=ballYdir;


    }
}
