import org.w3c.dom.css.Rect;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;
//เหลือเอาปุ่มกดซ้ายขวาออก
//แก้ตำแหน่งที่เด้งของpaddle
//แก้การขยับด้วยเม้า


public class Gameplay extends JPanel implements KeyListener, ActionListener {
    private boolean play = false;
    private boolean over = false;
    private boolean finish = false;
    private boolean slow = false;
    private int score =0;
    private Random ran =new Random();

    //press esc to slow game






    public BufferedImage bg,paddleLeft,paddleRight,start;


  //  private int totalBricks = 161;
    private int totalBricks = 322;


    private final ArrayList<Point> points = new ArrayList<>();


    private Timer timer;
    private int delay = 6;

    public int paddleX = 310;
    public int paddleY = 680;
    public int paddleWidht = 150;
    public int paddleHeight = 30;
    public boolean isStop = false;


  //  public ArrayList<Rectangle> rects = new ArrayList<>();
    //private Paddle paddle;
    private MapGenerator map;
    private ArrayList<Ball> balls = new ArrayList<>();
    private ArrayList<Item> items = new ArrayList<>();
    private ArrayList<Bullet> bullets = new ArrayList<>();

  //  private int totalBall = balls.size();

    public Gameplay() {



        try {
             bg = ImageIO.read(getClass().getResource("Pics/Bg.png"));
             paddleLeft = ImageIO.read(getClass().getResource("Pics/PaddleLeft.png"));
             paddleRight = ImageIO.read(getClass().getResource("Pics/PaddleRight.png"));
             start = ImageIO.read(getClass().getResource("Pics/start.png"));
        } catch (IOException e) {
            System.out.println("ERROR");
            e.printStackTrace();
        }

        map = new MapGenerator(9,7);

        addKeyListener(this);
        addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                super.mouseDragged(e);
                    points.add(e.getPoint());
                    repaint();

            }
        });








        setFocusable(true);
        setFocusTraversalKeysEnabled(true);
        timer = new Timer(delay,this);

        timer.start();

    }

    public void paint(Graphics g){
            g.drawImage(bg, 1, 1, 780, 750, this);
            g.drawImage(start, 200, 200, 300, 300, this);

        if(play ==true) {
            g.setColor(Color.black);
            g.fillRect(1, 1, 1920, 750);
            Graphics2D g2 = (Graphics2D) (g);

            g2.drawImage(bg, 1, 1, 780, 750, this);
            g2.drawImage(paddleLeft, (int) (paddleX - (paddleWidht * (0.5))), paddleY, (int) (paddleWidht * (0.5)), paddleHeight, this);
            g2.drawImage(paddleRight, paddleX, paddleY, (int) (paddleWidht * (0.5)), paddleHeight, this);


            //drawing map
            map.draw((Graphics2D) g);

            //borders
        g.setColor(Color.yellow);
        g.fillRect(0,0,3,800);
        g.fillRect(0,0,800,3);
        g.fillRect(777,0,3,800);

            //the paddle

//        g.setColor(Color.black);
//        g.fillRect((int)(paddleX),paddleY,(int)(paddleWidht*(0.1)),paddleHeight);
//        g.setColor(Color.black);
//        g.fillRect((int)(paddleX+(0.1)*paddleWidht),paddleY,(int)(paddleWidht*(0.30)),paddleHeight);
//        g.setColor(Color.black);
//        g.fillRect((int)(paddleX+(0.40)*paddleWidht),paddleY,(int)(paddleWidht*(0.1)),paddleHeight);
//
//        g.setColor(Color.black);
//        g.fillRect((int)(paddleX-(0.10)*paddleWidht),paddleY,(int)(paddleWidht*(0.1)),paddleHeight);
//        g.setColor(Color.black);
//        g.fillRect((int)(paddleX-(0.40)*paddleWidht),paddleY,(int)(paddleWidht*(0.30)),paddleHeight);
//        g.setColor(Color.black);
//        g.fillRect((int)(paddleX-(0.5)*paddleWidht),paddleY,(int)(paddleWidht*(0.1)),paddleHeight);

            //scores
            g.setColor(Color.white);
            g.setFont(new Font("serif",Font.BOLD,25));
            g.drawString("SCORE = "+score, 550, 40);

            g.setColor(Color.white);
            g.setFont(new Font("serif",Font.BOLD,25));
            g.drawString("PRESS ESC TO PAUSE GAME ", 30, 40);
            if(isStop ==true){
                g.setColor(Color.white);
                g.setFont(new Font("serif",Font.BOLD,25));
                g.drawString("PRESS ESC TO PLAY GAME ", 200, 440);
            }



            //the ball
            if (balls.size() > 0) {
                for (Ball b : balls) {
                    b.draw(g);
                }
            }

            //Item
            if (items.size() > 0) {
                for (Item i : items) {
                    i.draw(g);
                }
            }
            //bullet
            if (bullets.size() > 0) {
                for (Bullet b : bullets) {
                    b.draw(g);
                }
            }
            if(balls.size()==0){
                over = true;
                g.drawImage(bg, 1, 1, 1000, 750, this);
                g.setColor(Color.RED);
                g.setFont(new Font("serif",Font.BOLD,35));
                g.drawString("GAME OVER!! YOUR SCORE = "+score, 80, 300);
                g.setColor(Color.WHITE);
                g.drawString("PRESS R TO REPLAY ", 180, 400);

            }
            if(totalBricks==0){
                over = true;
                g.drawImage(bg, 1, 1, 1000, 750, this);
                g.setColor(Color.blue);
                g.setFont(new Font("serif",Font.BOLD,32));
                g.drawString("YOU ARE THE WINNER YOUR SCORE = "+score, 30, 300);
                g.setColor(Color.WHITE);
                g.drawString("PRESS R TO REPLAY ", 180, 400);

            }


            g.dispose();
        }
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        //System.out.println(points.get(0));
        //System.out.println("ACtion");
        timer.start();

        if(play){
            for(Point p : points){
               // System.out.println(p.getX());
                if(p.getX()>paddleWidht*0.5&&p.getX()<760-paddleWidht*0.5) {
                    paddleX = (int) p.getX();
                }
            }
           // System.out.println("ball = "+balls.size());
            //fL sL mL mR sR fR

            Rectangle paddleLeft = new Rectangle(paddleX-paddleWidht,paddleY,(int)(paddleWidht*(0.5)),paddleHeight);//widht = 100,height = 8
            Rectangle paddleRight = new Rectangle(paddleX,paddleY,(int)(paddleWidht*(0.5)),paddleHeight);//widht = 100,height = 8
            Rectangle finalLeft = new Rectangle((int)(paddleX-(0.5)*paddleWidht),paddleY,(int)(paddleWidht*(0.1)),paddleHeight);
            Rectangle left = new Rectangle((int)(paddleX-(0.40)*paddleWidht),paddleY,(int)(paddleWidht*(0.30)),paddleHeight);
            Rectangle middleLeft = new Rectangle((int)(paddleX-(0.10)*paddleWidht),paddleY,(int)(paddleWidht*(0.1)),paddleHeight);
            Rectangle middleRight = new Rectangle((int)(paddleX),paddleY,(int)(paddleWidht*(0.1)),paddleHeight);
            Rectangle right = new Rectangle((int)(paddleX+(0.1)*paddleWidht),paddleY,(int)(paddleWidht*(0.30)),paddleHeight);
            Rectangle finalRight = new Rectangle((int)(paddleX+(0.40)*paddleWidht),paddleY,(int)(paddleWidht*(0.1)),paddleHeight);




            //paddle and ball
            //FL > FR > ML > MR > L > R
                if(balls.size()>0){
                    for(Ball b :balls){
                        Rectangle ballRect = new Rectangle(b.ballposX, b.ballposY, b.ballWidth, b.ballHeight);
                        if (ballRect.intersects(finalLeft)) {
                            System.out.println("finalLeft");
                            b.ballYdir = -b.ballYdir;
                           // b.ballYdir =4;
                            b.ballXdir = -4;

                        }
                        else if (ballRect.intersects(finalRight)) {
                            System.out.println("finalright");
                            b.ballYdir = -b.ballYdir;
                            //b.ballYdir =-4;
                            b.ballXdir = 4;

                        }
                        else if (ballRect.intersects(middleLeft)) {
                            System.out.println("middleleft");
                            b.ballYdir = -b.ballYdir;
                            if(b.ballXdir<0) {
                                b.ballXdir = -1;
                            } else {
                                b.ballXdir = 1;
                            }

                        }
                        else if (ballRect.intersects(middleRight)) {
                            System.out.println("middleright");
                            b.ballYdir = -b.ballYdir;
                            if(b.ballXdir>0) {
                                b.ballXdir = -1;
                            } else {
                                b.ballXdir = 1;
                            }
                            b.ballXdir=1;

                        }
                        else if (ballRect.intersects(left)) {
                            System.out.println("left");
                            b.ballYdir = -b.ballYdir;
                            b.ballYdir =-2;
                            b.ballXdir = -3;

                        }
                        else if (ballRect.intersects(right)) {
                            System.out.println("right");
                            b.ballYdir = -b.ballYdir;
                            b.ballYdir =-2;
                            b.ballXdir = 3;

                        }


                    }

                }
                //paddle and Item
            if(items.size()>0){
                for(Item i:items){
                    Rectangle item = new Rectangle(i.itemposX,i.itemposY,i.itemWidth,i.itemHeight);
                    if(item.intersects(paddleLeft)||item.intersects(paddleRight)){
                        if(i.getType().equals("Fast")){
                            System.out.println("get Fast");
                            delay-=1;
                            timer.setDelay(delay);
                            items.remove(i);
                            break;

                        }
                        if(i.getType().equals("Minus")){
                            paddleWidht-=40;
                            System.out.println("get Minus");
                            items.remove(i);
                            break;
                        }
                        if(i.getType().equals("Plus")){
                            System.out.println("get Plus");
                            paddleWidht+=40;
                            items.remove(i);
                            break;
                        }
                        if(i.getType().equals("Slow")){
                            System.out.println("get slow");
                            delay+=1;
                            timer.setDelay(delay);
                            items.remove(i);
                            break;
                        }
                        if(i.getType().equals("Split")){
                            System.out.println("get Split");

                            balls.add(new Ball(balls.get(0).ballposX+10,balls.get(0).ballposY));
                            items.remove(i);
                            break;
                        }
                        if(i.getType().equals("Gun")){
                            System.out.println("get gun");

                            bullets.add(new Bullet(paddleX,paddleY));
                            bullets.add(new Bullet(paddleX,paddleY));
                            bullets.add(new Bullet(paddleX,paddleY));
                            items.remove(i);
                            break;
                        }


                    }

                }
            }

                //ball and brick
            A: for(int i =0;i<map.map.length;i++){
                for(int j=0;j<map.map[0].length;j++ ){
                    //System.out.println("I = "+i+"  J = "+j);
                    if(map.map[i][j]>0){
                        int brickX = j*map.brickWidth +100;
                        int brickY = i*map.brickHeight +80;
                        int brickWidth = map.brickWidth;
                        int brickHeight = map.brickHeight-3;

                        Rectangle rect = new Rectangle(brickX,brickY,brickWidth,brickHeight);
                        if(bullets.size()>0){
                            for(Bullet bu : bullets){
                                Rectangle ballRect = new Rectangle(bu.ballposX, bu.ballposY, bu.ballWidth, bu.ballHeight);
                                Rectangle brickRect = rect;
                                if(ballRect.intersects(brickRect)){
                                    map.hitBrick( i, j);
                                    totalBricks--;
                                    score += 10;
                                    bullets.clear();
                                    break ;
                                }
                            }
                        }
                        if(balls.size()>0) {
                            for(Ball b:balls) {
                            Rectangle ballRect = new Rectangle(b.ballposX, b.ballposY, b.ballWidth, b.ballHeight);
                            Rectangle brickRect = rect;


                            if (ballRect.intersects(brickRect)) {
                                int r = ran.nextInt(100);
                                System.out.println("r = "+r);

                                    if(r<3){
                                        System.out.println("Fast");
                                        items.add(new ItemFast(brickX,brickY));
                                    }
                                    else if(r<6) {
                                        items.add(new ItemMinus(brickX,brickY));
                                        System.out.println("Minus");
                                    }
                                    else if(r<9){
                                        items.add(new ItemPlus(brickX,brickY));
                                        System.out.println("Plus");
                                    }

                                    else if(r<12){
                                        items.add(new ItemSlow(brickX,brickY));
                                        System.out.println("Slow");
                                    }
                                    else if(r<24){
                                        items.add(new ItemSplit(brickX,brickY));
                                        System.out.println("Split");
                                    }
                                    else if(r<25){
                                        items.add(new ItemGun(brickX,brickY));

                                    }


                                map.hitBrick( i, j);
                                totalBricks--;
                                score += 10;

                                if (b.ballposX + 14 <= brickRect.x || b.ballposX + 1 >= brickRect.x + brickRect.width) {
                                    b.ballXdir = -b.ballXdir;
                                } else {
                                    b.ballYdir = -b.ballYdir;
                                }

                                break A;
                            }
                            }
                        }

                    }
                }
            }
            if(items.size()>0){
                for(Item i:items){
                    i.move();
                    if(i.itemposY>720){
                        if(balls.size()>0){
                            items.remove(i);
                            System.out.println("Item pop");
                            break;
                        }
                    }
                }
            }

            if(balls.size()>0){
                for(Ball b: balls){
                    b.move();
                    if(b.ballposY>720){
                        if(balls.size()>0){
                            balls.remove(b);
                            System.out.println("pop");
                            break;
                        }
                    }
                }
            }
            if(bullets.size()>0){
                for(Bullet bu : bullets){
                    bu.move();
                }
            }



        }

        repaint();
    }

    @Override
    public void keyTyped(KeyEvent e) { }
    @Override
    public void keyReleased(KeyEvent e) { }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode()==KeyEvent.VK_RIGHT){
          //  System.out.println("Right");

            if(paddleX>=660){
                paddleX=600;
            }   else {
                moveRight();
            }
        }
        if(e.getKeyCode()==KeyEvent.VK_LEFT){
            if(paddleX<10){
                paddleX=10;
            }  else {
                moveLeft();
            }
        }
        if(e.getKeyCode()==KeyEvent.VK_SPACE){
            if(play == false) {
                balls.add(new Ball(paddleX, paddleY-20));
            }
            }
        if(e.getKeyCode()==KeyEvent.VK_ESCAPE){
            System.out.println(delay);
            if(isStop == false){
            System.out.println("STOP");
            timer.stop();
            this.isStop = true;
            } else if(isStop == true) {
                timer.start();
                System.out.println("play");
            isStop = false;
        }}
            play= true;
        if(e.getKeyCode()==KeyEvent.VK_Q){
            balls.add(new Ball(paddleX,paddleY-100));
        }
        if(e.getKeyCode()==KeyEvent.VK_R){
            if(play==true){
                if(over == true) {
                    play = false;
                    over = false;
                    score = 0;
                    map = new MapGenerator(9, 7);
                    paddleWidht = 150;
                    delay = 6;
                    balls.clear();
                    items.clear();
                    totalBricks = 161;
                    timer.setDelay(delay);
                }
            }
        }
        }


    public void moveRight(){
        play=true;
        paddleX+=40;
    }
    public void moveLeft(){
        play=true;
        paddleX-=40;
    }


}
