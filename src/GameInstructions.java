import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameInstructions extends JFrame {
    private final int WHITH=1000; // גודל הפאנל
    private final int HIGHT=600;
    private final int X_START=600; //מיקום הפאנל
    private final int Y_START=0;

    public GameInstructions(){
        JFrame fram=new JFrame();
        fram.setBounds(X_START,Y_START,WHITH,HIGHT);
        fram.setBackground(Color.orange);
        JTextArea instructions = new JTextArea("                  Help Goku save the world !!\n" +
                "    In order to defeat Priza and save the world, \n you must collect all 7 Dragon Balls.\n" +
                "    If you miss even one ball,\n" +
                "    Or you're hit by Priza's energy balls three times,\n" +
                "    You will lose and the earth will be destroyed !!!\n" +
                "\n" +
                "    Go ahead and get going!");
        instructions.setFont(new Font("text",Font.BOLD,40));
        fram.add(instructions);
                instructions.setBackground(Color.ORANGE);
                instructions.setVisible(true);
        fram.setVisible(true);
            fram.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            }


}
