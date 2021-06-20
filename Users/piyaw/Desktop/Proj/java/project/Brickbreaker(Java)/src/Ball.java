import java.awt.*;
import java.util.Random;

public class Ball {

    public int ballWidth = 15;
    public int ballHeight = 15;
    public int ballposX ;
    public int ballposY ;
    public int ballXdir = -1;
    public int ballYdir = -2;
    public Color color ;
    Random random = new Random();

    public Ball (int ballposX,int ballposY){
        this.ballposX = ballposX;
        this.ballposY = ballposY;
        int r = random.nextInt(8);

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
        int r2 = random.nextInt(2);
        switch (r2){
            case 0:
                this.ballXdir = -1;
                break;
            case 1:
                this.ballXdir = 1;
                break;
        }
        System.out.println("r2 = "+r2);

    }
    public void draw(Graphics g){
        g.setColor(color);
        g.fillOval(ballposX,ballposY,ballWidth,ballHeight);

    }
    public void move(){
        ballposX+=ballXdir;
        ballposY+=ballYdir;

        if(ballposX<0){
            //System.out.println("X<0");
            ballXdir = -ballXdir;
        }
        if(ballposY<0){
            ballYdir = -ballYdir;
        }
        if(ballposX >760){
            // System.out.println("X>670");
            ballXdir = -ballXdir;
        }

    }
}
