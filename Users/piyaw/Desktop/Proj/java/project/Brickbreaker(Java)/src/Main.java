import javax.swing.*;
//ฐานกว้างขึ้น
//ลูกบอลกระจาย
public class Main {
    public static void main(String[] args){

        JFrame frame = new JFrame();
        Gameplay gameplay = new Gameplay();

        frame.setSize(780,750);
        frame.setTitle("Breakout ball");
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(gameplay);
        frame.setVisible(true);


    }
}
