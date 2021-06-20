import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class MapGenerator {
    public int map[][];
    public int brickWidth;
    public int brickHeight;
    public BufferedImage Purple,Blue,GreenO,Yellow,Orange,Red,Red2,Green,Green2;

    public MapGenerator(int row, int col) {
        try {
            Purple = ImageIO.read(getClass().getResource("Pics/Purple.jpg"));
            Blue = ImageIO.read(getClass().getResource("Pics/Blue.jpg"));
            GreenO = ImageIO.read(getClass().getResource("Pics/GreenO.jpg"));
            Green = ImageIO.read(getClass().getResource("Pics/Green.jpg"));
            Green2 = ImageIO.read(getClass().getResource("Pics/Green2.jpg"));
            Yellow = ImageIO.read(getClass().getResource("Pics/Yellow.jpg"));
            Orange = ImageIO.read(getClass().getResource("Pics/Orange.jpg"));
            Red = ImageIO.read(getClass().getResource("Pics/Red.jpg"));
            Red2 = ImageIO.read(getClass().getResource("Pics/Red2.jpg"));



        } catch (IOException e) {
            System.out.println("ERROR");
            e.printStackTrace();
        }
        map = new int[row][col];
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if(i<2){
                    map[i][j] = 20;
                }
                else if(i<5){
                    map[i][j] = 9;
                }   else if(i<7){
                    map[i][j] = 2;
                }   else {
                    map[i][j] = 1;
                }
            }
        }

        //540 /150
        brickWidth = 602 / col ;
        brickHeight = 233 / row ;
    }

    public void draw(Graphics2D g) {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if(map[i][j]>0){
                    if(map[i][j]==20){
                        g.setColor(Color.blue);
                        g.drawImage(Red,j*brickWidth+100,i*brickHeight +80,brickWidth,brickHeight-3,null);
                    }
                    if(map[i][j]==15){
                        g.setColor(Color.blue);
                        g.drawImage(Orange,j*brickWidth+100,i*brickHeight +80,brickWidth,brickHeight-3,null);
                    }
                    if(map[i][j]==10){
                        g.setColor(Color.CYAN);
                        g.drawImage(Purple,j*brickWidth+100,i*brickHeight +80,brickWidth,brickHeight-3,null);
                    }
                    if(map[i][j]==5){
                        g.setColor(Color.LIGHT_GRAY);
                        g.drawImage(Yellow,j*brickWidth+100,i*brickHeight +80,brickWidth,brickHeight-3,null);
                    }
                    if(map[i][j]==9){
                        g.setColor(Color.red);
                        g.drawImage(GreenO,j*brickWidth+100,i*brickHeight +80,brickWidth,brickHeight-3,null);
                    }
                    if(map[i][j]==6){
                        g.setColor(Color.pink);
                        g.drawImage(Green,j*brickWidth+100,i*brickHeight +80,brickWidth,brickHeight-3,null);
                    }
                    if(map[i][j]==3){
                        g.setColor(Color.pink);
                        g.drawImage(Yellow,j*brickWidth+100,i*brickHeight +80,brickWidth,brickHeight-3,null);
                    }
                    if(map[i][j]==2){
                        g.setColor(Color.white);
                        g.drawImage(Blue,j*brickWidth+100,i*brickHeight +80,brickWidth,brickHeight-3, null);
                    }
                    if(map[i][j]==1){
                        g.setColor(Color.white);
                        g.drawImage(Purple,j*brickWidth+100,i*brickHeight +80,brickWidth,brickHeight-3,null);
                    }







                }
            }
        }

    }
    public void hitBrick(int row ,int col){

        if(map[row][col]==20||map[row][col] == 15||map[row][col]==10||map[row][col]==5){
            map[row][col]-=5;
        }
        else if(map[row][col] == 9||map[row][col] == 6||map[row][col]==3){
            map[row][col]-=3;
        }   else {
            map[row][col] -=1;
        }


    }

}
