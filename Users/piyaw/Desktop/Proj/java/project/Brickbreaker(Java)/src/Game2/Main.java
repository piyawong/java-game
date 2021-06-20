package Game2;

import javax.swing.*;
//ฐานกว้างขึ้น
//ลูกบอลกระจาย
public class Main {
    public static void main(String[] args){

        JFrame frame = new JFrame();
        Gameplay2 gameplay = new Gameplay2();


        frame.setSize(858,480);
        frame.setTitle("Dungeonny");
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(gameplay);
        frame.setVisible(true);


    }
}
